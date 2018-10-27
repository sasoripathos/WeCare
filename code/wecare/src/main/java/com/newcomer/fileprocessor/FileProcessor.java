package com.newcomer.fileprocessor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.newcomer.fileprocessor.loader.NeedAssessRefLoader;
import com.newcomer.fileprocessor.loader.TemplateLoader;

@Service
public class FileProcessor {
	
	@Autowired
	private NeedAssessRefLoader narLoader;
	
	private TemplateLoader getLoader(String type) {
		if(type.equalsIgnoreCase("Needs Assessment and Referrals Service")) {
			return narLoader;
		} else { // TODO: here is well to add more loader
			return narLoader;
		}
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
			System.out.println("Known Type: " + loader.getTemplateType());
			List<List<String>> data = reader.getRows(loader.getTemplateColumnNumber());
			for(List<String> row: data) {
				loader.load(row);
			}
		}
	}
}
