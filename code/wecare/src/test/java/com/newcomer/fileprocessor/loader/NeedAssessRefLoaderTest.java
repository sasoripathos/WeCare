package com.newcomer.fileprocessor.loader;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.newcomer.dbservice.NeedAssessRefRepository;
import com.newcomer.dbservice.NewcomerRepository;
import com.newcomer.dbservice.SupportServiceRepository;
import com.newcomer.entity.NeedAssessRef;
import com.newcomer.entity.Newcomer;
import com.newcomer.entity.SupportService;
import com.newcomer.wecare.App;

@RunWith(SpringRunner.class)
@TestPropertySource(locations="classpath:test.properties")
@SpringBootTest(classes = App.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
public class NeedAssessRefLoaderTest {
	
	private String [] a = new String[] {"Example2", "10387105", "FOSS/GCMS Client ID", "12345678", 
			"2000-01-01","A4E 7F5", "2018-10-25", "French", "French", "Public library", 
			"Community centre / library", "No", "No", "", "", "Yes", "Yes", "Yes", "Yes", "Yes",
			"No", "No", "Yes", "Yes", "Yes", "Yes", "Yes", "Yes", "Yes", "Find employment",
			"Yes", "Yes", "Find mate", "Yes", "Yes", "Within one year", "No",
			"O - Management occupations", "Yes", "Yes", "Yes", "Yes", "Yes", "Yes", "Yes", "Yes",
			"Yes", "Yes", "Yes", "Yes", "Yes", "Yes", "Yes", "Yes", "Yes", "Yes", "Yes", "Yes", "Yes",
			"Yes", "Yes", "Yes", "Yes", "Yes", "Yes", "Yes", "Yes", "Yes", "Yes", "Yes", "Infant (6-18 months)",
			"Short term", "Infant (6-18 months)", "Short term", "Infant (6-18 months)", "Short term", "Infant (6-18 months)",
			"Short term", "Infant (6-18 months)", "Short term", "Yes", "Yes", "Yes", "English", "English", "Yes", "French",
			"Chinese", "Yes", "Yes", "2018-10-26", "New record", };
	
	private List<String> rowOne = Arrays.asList(a);
	
	@Autowired
	private NeedAssessRefLoader loader;
	@Autowired
	private NeedAssessRefRepository narRepo;
	@Autowired
	private NewcomerRepository newcomerRepo;
	@Autowired
	private SupportServiceRepository supservRepo;
	
	
	@Test
	public void testColNum() {
		assertEquals(92, loader.getTemplateColumnNumber());
	}
	
	@Test
	public void testLoad() {
		loader.load(rowOne);
		NeedAssessRef a = narRepo.findByIdentifierValue("12345678");
		Newcomer b = newcomerRepo.findByIdentifierValue("12345678");
		SupportService c = supservRepo.findByIdentifierValue("12345678");
		assertNotEquals(null, a);
		assertNotEquals(null, b);
		assertNotEquals(null, c);
		assertEquals("2000-01-01", b.getBirthday());
		assertEquals("French", a.getServiceLanguage());
		assertEquals("Find employment", a.getImproveLanguageTo());
		assertEquals("Find mate", a.getImproveOtherTo());
		assertEquals("French", c.getInterpreteBetween());
		assertEquals("Chinese", c.getInterpreteAnd());
	}
	
	@After
	public void clean() {
		narRepo.deleteAll();
		newcomerRepo.deleteAll();
		supservRepo.deleteAll();
	}
}
