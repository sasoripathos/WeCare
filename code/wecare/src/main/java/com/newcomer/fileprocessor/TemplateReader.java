package com.newcomer.fileprocessor;

import java.util.ArrayList;
import java.util.List;

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
		XSSFWorkbook myWorkBook;
		String[] lines = null;
		try {
			myWorkBook = new XSSFWorkbook(file.getInputStream());
			XSSFSheet mySheet = myWorkBook.getSheetAt(0);
			XSSFRow row = mySheet.getRow(0);
			Cell header = row.getCell(0);
			String title = header.getStringCellValue();
			lines = title.split("\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(lines != null && lines.length > 0 ) {
			return lines[lines.length -1];
		}
		return "Unknown";
	}
	
	private List<String> getRow(XSSFRow row, int maxColumn) {
		List<String> data = new ArrayList<String>();
		for(int i=0;i<maxColumn;i++) {
			Cell cell = row.getCell(i);
			data.add(cell.getStringCellValue());
		}
		return data;
	} 
	
	public List<List<String>> getRows(int maxColumn) {
		List<List<String>> rows = new ArrayList<List<String>>();
		XSSFWorkbook myWorkBook;
		try {
			myWorkBook = new XSSFWorkbook(file.getInputStream());
			XSSFSheet mySheet = myWorkBook.getSheetAt(0);
			for (int i=3;i<=10;i++) {
				XSSFRow row = mySheet.getRow(i);
				if(row == null) {
					break;
				}
				List<String> data = getRow(row, maxColumn);
				if(String.join("", data).equals("")) {
					break;
				}
				rows.add(data);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}
}
