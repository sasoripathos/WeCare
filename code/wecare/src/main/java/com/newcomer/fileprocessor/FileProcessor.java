package com.newcomer.fileprocessor;

import java.util.HashMap;

import org.springframework.web.multipart.MultipartFile;

import com.newcomer.fileprocessor.loader.TemplateLoader;

public class FileProcessor {
	
	HashMap<String, TemplateLoader> loaders;
	
	public FileProcessor() {
		loaders = new HashMap<String, TemplateLoader>();
	}
	
	public void registerLoader(TemplateLoader loader) {
		// TODO: register checker
		loaders.put(loader.getTemplateType(), loader);
	}
	
	public void process(MultipartFile file) {
		TemplateReader reader = new TemplateReader(file);
		String type = reader.getTemplateType();

		// TODO: error check

		// Select corresponding template loader
		TemplateLoader loader = loaders.get(type);
		if(loader == null) {
			System.out.println("Unknown template type");
		} else {
			System.out.println("Known Type: " + loader.getTemplateType());
		}
		
	}
}
