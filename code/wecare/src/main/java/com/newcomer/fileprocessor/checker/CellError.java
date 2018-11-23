package com.newcomer.fileprocessor.checker;

/**
 * A class for holding data cell error message. 
 */
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
		// Real row number and column numbers start from one.
		return "Cell(" + (row+1) + ", " + (column+1) + "): " + message;
	}
}
