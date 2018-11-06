package com.newcomer.entity;

import static org.junit.Assert.*;

import org.junit.Test;

public class NewcomerTest {
	@Test
	public void testIdGetterSetter() {
	    Newcomer ins = new Newcomer();
	    ins.setId("abc");
	    assertEquals("abc", ins.getId());
	    ins.setId("def");
	    assertEquals("def", ins.getId());
	}

	@Test
	public void testIdentifierNameGetterSetter() {
	    Newcomer ins = new Newcomer();
	    ins.setIdentifierName("abc");
	    assertEquals("abc", ins.getIdentifierName());
	    ins.setIdentifierName("def");
	    assertEquals("def", ins.getIdentifierName());
	}

	@Test
	public void testIdentifierValueGetterSetter() {
	    Newcomer ins = new Newcomer();
	    ins.setIdentifierValue("abc");
	    assertEquals("abc", ins.getIdentifierValue());
	    ins.setIdentifierValue("def");
	    assertEquals("def", ins.getIdentifierValue());
	}

	@Test
	public void testBirthdayGetterSetter() {
	    Newcomer ins = new Newcomer();
	    ins.setBirthday("abc");
	    assertEquals("abc", ins.getBirthday());
	    ins.setBirthday("def");
	    assertEquals("def", ins.getBirthday());
	}

	@Test
	public void testPhoneNumberGetterSetter() {
	    Newcomer ins = new Newcomer();
	    ins.setPhoneNumber("abc");
	    assertEquals("abc", ins.getPhoneNumber());
	    ins.setPhoneNumber("def");
	    assertEquals("def", ins.getPhoneNumber());
	}

	@Test
	public void testHaveEmailGetterSetter() {
	    Newcomer ins = new Newcomer();
	    ins.setHaveEmail(true);
	    assertTrue(ins.getHaveEmail());
	    ins.setHaveEmail(false);
	    assertFalse(ins.getHaveEmail());
	}

	@Test
	public void testEmailGetterSetter() {
	    Newcomer ins = new Newcomer();
	    ins.setEmail("abc");
	    assertEquals("abc", ins.getEmail());
	    ins.setEmail("def");
	    assertEquals("def", ins.getEmail());
	}

	@Test
	public void testStreetNumberGetterSetter() {
	    Newcomer ins = new Newcomer();
	    ins.setStreetNumber("abc");
	    assertEquals("abc", ins.getStreetNumber());
	    ins.setStreetNumber("def");
	    assertEquals("def", ins.getStreetNumber());
	}

	@Test
	public void testStreetNameGetterSetter() {
	    Newcomer ins = new Newcomer();
	    ins.setStreetName("abc");
	    assertEquals("abc", ins.getStreetName());
	    ins.setStreetName("def");
	    assertEquals("def", ins.getStreetName());
	}

	@Test
	public void testStreetTypeGetterSetter() {
	    Newcomer ins = new Newcomer();
	    ins.setStreetType("abc");
	    assertEquals("abc", ins.getStreetType());
	    ins.setStreetType("def");
	    assertEquals("def", ins.getStreetType());
	}

	@Test
	public void testStreetDirectionGetterSetter() {
	    Newcomer ins = new Newcomer();
	    ins.setStreetDirection("abc");
	    assertEquals("abc", ins.getStreetDirection());
	    ins.setStreetDirection("def");
	    assertEquals("def", ins.getStreetDirection());
	}

	@Test
	public void testAptNumberGetterSetter() {
	    Newcomer ins = new Newcomer();
	    ins.setAptNumber("abc");
	    assertEquals("abc", ins.getAptNumber());
	    ins.setAptNumber("def");
	    assertEquals("def", ins.getAptNumber());
	}

	@Test
	public void testCityGetterSetter() {
	    Newcomer ins = new Newcomer();
	    ins.setCity("abc");
	    assertEquals("abc", ins.getCity());
	    ins.setCity("def");
	    assertEquals("def", ins.getCity());
	}

	@Test
	public void testProvinceGetterSetter() {
	    Newcomer ins = new Newcomer();
	    ins.setProvince("abc");
	    assertEquals("abc", ins.getProvince());
	    ins.setProvince("def");
	    assertEquals("def", ins.getProvince());
	}

	@Test
	public void testPostcodeGetterSetter() {
	    Newcomer ins = new Newcomer();
	    ins.setPostcode("abc");
	    assertEquals("abc", ins.getPostcode());
	    ins.setPostcode("def");
	    assertEquals("def", ins.getPostcode());
	}

	@Test
	public void testLanguagePreferenceGetterSetter() {
	    Newcomer ins = new Newcomer();
	    ins.setLanguagePreference("abc");
	    assertEquals("abc", ins.getLanguagePreference());
	    ins.setLanguagePreference("def");
	    assertEquals("def", ins.getLanguagePreference());
	}

	@Test
	public void testConsentGetterSetter() {
	    Newcomer ins = new Newcomer();
	    ins.setConsent("abc");
	    assertEquals("abc", ins.getConsent());
	    ins.setConsent("def");
	    assertEquals("def", ins.getConsent());
	}

	@Test
	public void testProcDetailGetterSetter() {
	    Newcomer ins = new Newcomer();
	    ins.setProcDetail("abc");
	    assertEquals("abc", ins.getProcDetail());
	    ins.setProcDetail("def");
	    assertEquals("def", ins.getProcDetail());
	}


}
