package com.newcomer.fileprocessor;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

/**
 * This class is a service which reads data from a file.
 */
public class TemplateReader {
	/**
	 * The index of row where the data starts.
	 */
	private static final int startRowIndex = 3;
	
	private MultipartFile file;
	
	public TemplateReader(MultipartFile file) {
		this.file = file;
	}
	
	/**
	 * Get the type of the template if recognizable, otherwise return "unknown".
	 * @return "unknown" or a string standing for template type.
	 */
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
					// If there is content in the cell, get the content
					String title = header.getStringCellValue().trim();
					lines = title.split("\n");
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(lines != null && lines.length > 0) {
			// If there is content in the head cell
			String answer = lines[lines.length -1].trim();
			if(answer.equals("")) {
				// If the last line has no word, template unknown
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
	
	/**
	 * Read data in column 1 to column maxColumn from one EXCEL row. 
	 * @param row an EXCEL row.
	 * @param maxColumn the max column number.
	 * @return a list of string that contains the data in given row.
	 */
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
	
	/**
	 * Read data in column 1 to column maxColumn from all EXCEL rows. 
	 * @param maxColumn the max column number.
	 * @return a 2D list of string that contains the data in all rows.
	 */
	public List<List<String>> getRows(int maxColumn) {
		List<List<String>> rows = new ArrayList<List<String>>();
		XSSFWorkbook myWorkBook;
		try {
			myWorkBook = new XSSFWorkbook(file.getInputStream());
			XSSFSheet mySheet = myWorkBook.getSheetAt(0);
			// Read all rows
			for (int i=startRowIndex;;i++) {
				XSSFRow row = mySheet.getRow(i);
				if(row == null) {
					break; // if the row is null, reach the end of data
				}
				List<String> data = getRow(row, maxColumn);
				if(String.join("", data).equals("")) {
					// if the row's data in all is "", reach the end of data
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
