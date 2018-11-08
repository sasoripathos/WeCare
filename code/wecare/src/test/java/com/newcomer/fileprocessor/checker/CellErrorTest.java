package com.newcomer.fileprocessor.checker;

import static org.junit.Assert.*;

import org.junit.Test;

public class CellErrorTest {
	
	@Test
	public void testNullErrorMessage() {
		assertEquals("Cell cannot be empty.", CellError.nullError);
	}
	
	@Test
	public void testCreate() {
		CellError a = new CellError(1,2,"abc");
		assertNotEquals(null, a);
	}
	
	@Test
	public void testToString() {
		CellError a = new CellError(1,2,"abc");
		assertEquals("Cell(2, 3): abc", a.toString());
	}
}
