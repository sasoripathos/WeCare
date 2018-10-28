package com.newcomer.fileprocessor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.newcomer.fileprocessor.checker.CellError;
import com.newcomer.fileprocessor.checker.TemplateChecker;
import com.newcomer.fileprocessor.loader.TemplateLoader;

@Service
public class FileProcessor {

	@Autowired
	private ApplicationContext context;
	
	private TemplateLoader getLoader(String type) {
		TemplateLoader loader = null;
		try {
			loader = (TemplateLoader) context.getBean(type);
		} catch (NoSuchBeanDefinitionException e) {
			// If no such bean, do nothing
		}
		return  loader;
	}
	
	private TemplateChecker getChecker(String type) {
		TemplateChecker checker = null;
		try {
			checker = (TemplateChecker) context.getBean(type + " Checker");
		} catch (NoSuchBeanDefinitionException e) {
			// If no such bean, do nothing
		}
		return checker;
	}
	
	public List<CellError> process(MultipartFile file) {
		TemplateReader reader = new TemplateReader(file);
		// Get template type
		String type = reader.getTemplateType();
		// Select corresponding template checker
		TemplateChecker checker = getChecker(type);
		// Select corresponding template loader
		TemplateLoader loader = getLoader(type);
		// If no loader, then template unknown
		if(loader == null) {
			System.out.println("Unknown template type");
			return null;
		} else {
			System.out.println("Known Type: " + type);
			List<List<String>> data = reader.getRows(loader.getTemplateColumnNumber());
			List<CellError> errors = new ArrayList<CellError>();
			for(int i=0; i<data.size(); i++) { // Check data first
				errors.addAll(checker.check(i, data.get(i)));
			}
			if(errors.size() == 0 ) {
				for (List<String> row:data) {
					loader.load(row);
				}
			}
			return errors;
		}
	}
}
