package com.newcomer.dbservice;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.newcomer.entity.SupportService;
import com.newcomer.wecare.App;

@RunWith(SpringRunner.class)
@TestPropertySource(locations="classpath:test.properties")
@SpringBootTest(classes = App.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
public class SupportServiceTest {

	@Autowired
	private SupportServiceRepository repo;
	
	@Before
	public void init() {
		SupportService ins = new SupportService ();
		ins.setIdentifierValue("123456789");
		ins.setReceived(true);
		ins.setChildCare(true);
		ins.setChild1Age("16");
		ins.setChild1CareType("Long Term");
		ins.setChild2Age("");
		ins.setChild2CareType("");
		ins.setChild3Age("");
		ins.setChild3CareType("");
		ins.setChild4Age("");
		ins.setChild4CareType("");
		ins.setChild5Age("");
		ins.setChild5CareType("");
		ins.setTransportation(false);
		ins.setDisabilities(false);
		ins.setTranslateBetween("");
		ins.setTranslateAnd("");
		ins.setInterpreteBetween("English");
		ins.setInterpreteAnd("French");
		ins.setCrisisCounselling(false);
		ins.setUpdateReason("no reason");
		
		repo.save(ins);
	}
	
	@Test
	public void testSaveServiceRecord() {
		SupportService a = new SupportService ();
		a.setIdentifierValue("741852963");
		a.setReceived(true);
		a.setChildCare(true);
		a.setChild1Age("6");
		a.setChild1CareType("Short Term");
		a.setChild2Age("5");
		a.setChild2CareType("Long Term");
		a.setChild3Age("2");
		a.setChild3CareType("Long Term");
		a.setChild4Age("");
		a.setChild4CareType("");
		a.setChild5Age("");
		a.setChild5CareType("");
		a.setTransportation(true);
		a.setDisabilities(true);
		a.setTranslateBetween("English");
		a.setTranslateAnd("French");
		a.setInterpreteBetween("English");
		a.setInterpreteAnd("French");
		a.setCrisisCounselling(false);
		a.setUpdateReason("some reason");
		
		assertNotEquals(null, repo.save(a));
	}
	
	@Test
	public void testCanFindServiceRecord() {
		SupportService a = repo.findByIdentifierValue("123456789");
		assertEquals("123456789",a.getIdentifierValue());
		assertEquals("16",a.getChild1Age());
		assertEquals("Long Term", a.getChild1CareType());
		assertEquals("", a.getChild2Age());
	}
	
	@Test
	public void testCannotFindServiceRecord() {
		SupportService a = repo.findByIdentifierValue("741852963");
		assertEquals(null, a);
	}
	
	@After
	public void clean() {
		repo.deleteAll();
	}
}
