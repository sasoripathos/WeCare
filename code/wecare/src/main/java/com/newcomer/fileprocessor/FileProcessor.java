package com.newcomer.fileprocessor;

import java.util.List;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
	
	public void process(MultipartFile file) {
		TemplateReader reader = new TemplateReader(file);
		String type = reader.getTemplateType();

		// TODO: error check

		// Select corresponding template loader
		TemplateLoader loader = getLoader(type);
		if(loader == null) {
			System.out.println("Unknown template type");
		} else {
			System.out.println("Known Type: " + type);
			List<List<String>> data = reader.getRows(loader.getTemplateColumnNumber());
			for(List<String> row: data) {
				loader.load(row);
			}
		}
	}
}
