package com.newcomer.fileprocessor.checker;

public class CellError {
	
	private int row;
	private int column;
	private String message;
	
	public static String nullError = "Cell cannot be empty.";
	
	public CellError(int row, int column, String message) {
		this.row = row;
		this.column = column;
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "Cell(" + (row+1) + ", " + (column+1) + "): " + message;
	}
}
