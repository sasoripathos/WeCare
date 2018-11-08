package com.newcomer.fileprocessor;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

public class TemplateReaderTest {

	private InputStream in;
	private MultipartFile file;
	
	@Test
	public void testConstructor() throws IOException {
		in = this.getClass().getResourceAsStream("readertest.xlsx");
		file = new MockMultipartFile("file", "readertest.xlsx", "multipart/form-data", in);
		TemplateReader a  = new TemplateReader(file);
		assertNotEquals(null, a);
	}
	
	@Test
	public void testGetTemplateTypeUnknown() throws IOException {
		in = this.getClass().getResourceAsStream("empty.xlsx");
		file = new MockMultipartFile("file", "empty.xlsx", "multipart/form-data", in);
		TemplateReader a  = new TemplateReader(file);
		assertEquals("Unknown", a.getTemplateType());
	}
	
	@Test
	public void testGetTemplateTypeKnown() throws IOException {
		in = this.getClass().getResourceAsStream("readertest.xlsx");
		file = new MockMultipartFile("file", "readertest.xlsx", "multipart/form-data", in);
		TemplateReader a  = new TemplateReader(file);
		assertEquals("mocktype", a.getTemplateType());
	}
	
	@Test
	public void testGetRows() throws IOException {
		in = this.getClass().getResourceAsStream("readertest.xlsx");
		file = new MockMultipartFile("file", "readertest.xlsx", "multipart/form-data", in);
		TemplateReader a  = new TemplateReader(file);
		List<List<String>> rows = a.getRows(3);
		assertEquals(4, rows.size());
		for (List<String> row:rows) {
			assertEquals(3, row.size());
			assertEquals("1", row.get(0));
			assertEquals("2", row.get(1));
			assertEquals("3", row.get(2));
		}
	}
	
	@After
	public void clean() {
		try {
			in.close();
		} catch (IOException e) {
		}
	}
}
