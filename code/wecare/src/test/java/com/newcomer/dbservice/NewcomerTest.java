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

import com.newcomer.entity.Newcomer;
import com.newcomer.wecare.App;

@RunWith(SpringRunner.class)
@TestPropertySource(locations="classpath:test.properties")
@SpringBootTest(classes = App.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
public class NewcomerTest {
	
	@Autowired
	private NewcomerRepository repo;
	
	@Before
	public void init() {
		Newcomer ins = new Newcomer ();
		ins.setIdentifierName("unique id");
		ins.setIdentifierValue("987654321");
		ins.setBirthday("1999-09-09");
		ins.setPhoneNumber("16476471234");
		ins.setHaveEmail(true);
		ins.setEmail("987uoft@gmail.com");
		ins.setStreetNumber("1256");
		ins.setStreetName("Military");
		ins.setStreetType("Trail");
		ins.setStreetDirection("North");
		ins.setAptNumber("473");
		ins.setCity("Toronto");
		ins.setProvince("ON");
		ins.setPostcode("1A2 B3C");
		ins.setLanguagePreference("French");
		ins.setConsent("Yes");
		ins.setProcDetail("Detail");
		
		repo.save(ins);
	}
	
	@Test
	public void testSaveNewcomer() {
		Newcomer a = new Newcomer ();
		a.setIdentifierName("unique id");
		a.setIdentifierValue("963852741");
		a.setBirthday("1998-08-08");
		a.setPhoneNumber("16476471234");
		a.setHaveEmail(true);
		a.setEmail("123test@gmail.com");
		a.setStreetNumber("1256");
		a.setStreetName("Military");
		a.setStreetType("Trail");
		a.setStreetDirection("North");
		a.setAptNumber("473");
		a.setCity("Toronto");
		a.setProvince("ON");
		a.setPostcode("1A2 B3C");
		a.setLanguagePreference("French");
		a.setConsent("Yes");
		a.setProcDetail("Detail");
		
		assertNotEquals(null, repo.save(a));
	}
	
	@Test
	public void testCanFindNewcomer() {
		Newcomer a = repo.findByIdentifierValue("987654321");
		assertEquals("987654321",a.getIdentifierValue());
		assertEquals("1999-09-09",a.getBirthday());
		assertEquals("987uoft@gmail.com",a.getEmail());
	}
	
	@Test
	public void testCannotFindNewcomer() {
		Newcomer a = repo.findByIdentifierValue("963852741");
		assertEquals(null, a);
	}
	
	@After
	public void clean() {
		repo.deleteAll();
	}
}
