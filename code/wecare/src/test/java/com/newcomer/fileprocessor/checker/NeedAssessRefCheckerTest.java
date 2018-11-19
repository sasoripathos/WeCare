package com.newcomer.fileprocessor.checker;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.newcomer.wecare.App;

@RunWith(SpringRunner.class)
@TestPropertySource(locations="classpath:test.properties")
@SpringBootTest(classes = App.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
public class NeedAssessRefCheckerTest {
	
	private String [] a = new String[] {"Example2", "10387105", "FOSS/GCMS Client ID", "12345679", 
			"2000-01-01","A4E 7F5", "2018-10-25", "French", "French", "Public library", 
			"Community centre / library", "No", "No", "", "", "Yes", "Yes", "Yes", "Yes", "Yes",
			"No", "No", "Yes", "Yes", "Yes", "Yes", "Yes", "Yes", "Yes", "Find employment",
			"Yes", "Yes", "Find employment", "Yes", "Yes", "Within one year", "No",
			"O - Management occupations", "Yes", "Yes", "Yes", "Yes", "Yes", "Yes", "Yes", "Yes",
			"Yes", "Yes", "Yes", "Yes", "Yes", "Yes", "Yes", "Yes", "Yes", "Yes", "Yes", "Yes", "Yes",
			"Yes", "Yes", "Yes", "Yes", "Yes", "Yes", "Yes", "Yes", "Yes", "Yes", "Yes", "Infant (6-18 months)",
			"Short term", "Infant (6-18 months)", "Short term", "Infant (6-18 months)", "Short term", "Infant (6-18 months)",
			"Short term", "Infant (6-18 months)", "Short term", "Yes", "Yes", "Yes", "English", "English", "Yes", "French",
			"Chinese", "Yes", "Yes", "2018-10-26", "New record", };
	
	private List<String> rowOne;
	
	@Autowired
	private NeedAssessRefChecker checker;
	
	@Before
	public void init() {
		rowOne = Arrays.asList(a);
	}
	
	@Test
	public void testCheckValid() {
		List<CellError> a = checker.check(1, rowOne);
		assertEquals(0, a.size());
	}
	
	@Test
	public void testCheckInvalid() {
		rowOne.set(5, "");
		rowOne.set(47, "");
		rowOne.set(49, "");
		List<CellError> a = checker.check(5, rowOne);
		assertEquals(2, a.size());
		assertEquals("Cell(6, 6): Cell cannot be empty.", a.get(0).toString());
		assertEquals("Cell(6, 48): Cell cannot be empty.", a.get(1).toString());
	}
}
