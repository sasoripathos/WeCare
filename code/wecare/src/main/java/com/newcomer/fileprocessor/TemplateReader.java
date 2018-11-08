package com.newcomer.fileprocessor;

import java.io.IOException;
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
			if(row != null) {
				// If the row is not empty
				Cell header = row.getCell(0);
				if (header != null) {
					// If there is content in the cell
					String title = header.getStringCellValue().trim();
					lines = title.split("\n");
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(lines != null && lines.length > 0 ) {
			// If there is content in the head cell
			String answer = lines[lines.length -1].trim();
			if(answer.equals("")) {
				// If the last line has no word
				return "Unknown";
			} else {
				// otherwise return the last line as the template type
				return lines[lines.length -1];
			}
		} else {
			// Otherwise the template is unknown
			return "Unknown";
		}
	}
	
	private List<String> getRow(XSSFRow row, int maxColumn) {
		List<String> data = new ArrayList<String>();
		for(int i=0;i<maxColumn;i++) {
			Cell cell = row.getCell(i);
			if(cell == null) {
				// If cell is null, that cell is empty
				data.add("");
			} else {
				// Else, the cell has value, removing heading and tailing spaces
				data.add(cell.getStringCellValue().trim());
			}
		}
		return data;
	} 
	
	public List<List<String>> getRows(int maxColumn) {
		List<List<String>> rows = new ArrayList<List<String>>();
		XSSFWorkbook myWorkBook;
		try {
			myWorkBook = new XSSFWorkbook(file.getInputStream());
			XSSFSheet mySheet = myWorkBook.getSheetAt(0);
			for (int i=3;;i++) {
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
