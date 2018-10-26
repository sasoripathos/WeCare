package com.newcomer.fileprocessor;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

public class TemplateReader {
	private MultipartFile file;
	
	public TemplateReader(MultipartFile file) {
		this.file = file;
	}
	
	public String getTemplateType() {
		//TODO: file type check
		XSSFWorkbook myWorkBook;
		String[] lines = null;
		try {
			myWorkBook = new XSSFWorkbook(file.getInputStream());
			XSSFSheet mySheet = myWorkBook.getSheetAt(0);
			XSSFRow row = mySheet.getRow(0);
			Cell header = row.getCell(0);
			String title = header.getStringCellValue();
			System.out.println(title);
			lines = title.split("\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(lines != null && lines.length > 0 ) {
			System.out.println(lines[lines.length -1]);
			return lines[lines.length -1];
		}
		return "Unknown";
	}
}
