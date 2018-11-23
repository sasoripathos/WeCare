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

/**
 * This class is a stateless orchestration service (singleton) which processes the incoming files.
 * The orchestration includes:
 *     1. link corresponding checker and loader classes for the recognized template.
 *     2. read data from the template.
 *     3. check whether there is any error (which needs human investigation) in the data.
 *     4. save the data in database if there is no error in data.
 *
 */
@Service
public class FileProcessor {

	/**
	 * Context of the application, for get loader/checker by template name.
	 */
	@Autowired
	private ApplicationContext context;
	
	/**
	 * Given the type of a template, return the corresponding loader.
	 * @param type the type of template.
	 * @return a TemplateLoader for the specific template.
	 */
	private TemplateLoader getLoader(String type) {
		TemplateLoader loader = null;
		try {
			loader = (TemplateLoader) context.getBean(type);
		} catch (NoSuchBeanDefinitionException e) {
			// If no such bean, do nothing but return null
		}
		return  loader;
	}
	
	/**
	 * Given the type of a template, return the corresponding checker.
	 * @param type type the type of template.
	 * @return a TemplateLoader for the specific template.
	 */
	private TemplateChecker getChecker(String type) {
		TemplateChecker checker = null;
		try {
			checker = (TemplateChecker) context.getBean(type + " Checker");
		} catch (NoSuchBeanDefinitionException e) {
			// If no such bean, do nothing but return null
		}
		return checker;
	}
	
	/**
	 * File process orchestration.
	 * @param file the uploaded template.
	 * @return the list of errors exists in the data. If the file is unrecognizable, return null;
	 *     If there is no errors, an empty list will be return.
	 */
	public List<CellError> process(MultipartFile file) {
		// Get template type
		TemplateReader reader = new TemplateReader(file);
		String type = reader.getTemplateType();
		
		// Select corresponding template checker and loader
		TemplateChecker checker = getChecker(type);
		TemplateLoader loader = getLoader(type);
		
		if(loader == null) { // If no loader, then template unknown, return null object
			return null;
		} else { // Else
			// Read data from template
			List<List<String>> data = reader.getRows(loader.getTemplateColumnNumber());
			// Check data for errors
			List<CellError> errors = new ArrayList<CellError>();
			for(int i=0; i<data.size(); i++) { 
				errors.addAll(checker.check(i+3, data.get(i)));
			}
			// If no errors, ask loader save data
			if(errors.size() == 0 ) {
				for (List<String> row:data) {
					loader.load(row);
				}
			}
			return errors;
		}
	}
}
