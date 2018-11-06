package com.newcomer.entity;

import static org.junit.Assert.*;

import org.junit.Test;

public class SupportServiceTest {
	
	@Test
	public void testIdGetterSetter() {
	    SupportService ins = new SupportService();
	    ins.setId("abc");
	    assertEquals("abc", ins.getId());
	    ins.setId("def");
	    assertEquals("def", ins.getId());
	}
	
	@Test
	public void testIdentifierValueGetterSetter() {
	    SupportService ins = new SupportService();
	    ins.setIdentifierValue("abc");
	    assertEquals("abc", ins.getIdentifierValue());
	    ins.setIdentifierValue("def");
	    assertEquals("def", ins.getIdentifierValue());
	}
	
	@Test
	public void testReceivedGetterSetter() {
	    SupportService ins = new SupportService();
	    ins.setReceived(true);
	    assertTrue(ins.getReceived());
	    ins.setReceived(false);
	    assertFalse(ins.getReceived());
	}
	
	@Test
	public void testChildCareGetterSetter() {
	    SupportService ins = new SupportService();
	    ins.setChildCare(true);
	    assertTrue(ins.getChildCare());
	    ins.setChildCare(false);
	    assertFalse(ins.getChildCare());
	}
	
	@Test
	public void testChild1AgeGetterSetter() {
	    SupportService ins = new SupportService();
	    ins.setChild1Age("abc");
	    assertEquals("abc", ins.getChild1Age());
	    ins.setChild1Age("def");
	    assertEquals("def", ins.getChild1Age());
	}
	
	@Test
	public void testChild1CareTypeGetterSetter() {
	    SupportService ins = new SupportService();
	    ins.setChild1CareType("abc");
	    assertEquals("abc", ins.getChild1CareType());
	    ins.setChild1CareType("def");
	    assertEquals("def", ins.getChild1CareType());
	}
	
	@Test
	public void testChild2AgeGetterSetter() {
	    SupportService ins = new SupportService();
	    ins.setChild2Age("abc");
	    assertEquals("abc", ins.getChild2Age());
	    ins.setChild2Age("def");
	    assertEquals("def", ins.getChild2Age());
	}
	
	@Test
	public void testChild2CareTypeGetterSetter() {
	    SupportService ins = new SupportService();
	    ins.setChild2CareType("abc");
	    assertEquals("abc", ins.getChild2CareType());
	    ins.setChild2CareType("def");
	    assertEquals("def", ins.getChild2CareType());
	}
	
	@Test
	public void testChild3AgeGetterSetter() {
	    SupportService ins = new SupportService();
	    ins.setChild3Age("abc");
	    assertEquals("abc", ins.getChild3Age());
	    ins.setChild3Age("def");
	    assertEquals("def", ins.getChild3Age());
	}
	
	@Test
	public void testChild3CareTypeGetterSetter() {
	    SupportService ins = new SupportService();
	    ins.setChild3CareType("abc");
	    assertEquals("abc", ins.getChild3CareType());
	    ins.setChild3CareType("def");
	    assertEquals("def", ins.getChild3CareType());
	}
	
	@Test
	public void testChild4AgeGetterSetter() {
	    SupportService ins = new SupportService();
	    ins.setChild4Age("abc");
	    assertEquals("abc", ins.getChild4Age());
	    ins.setChild4Age("def");
	    assertEquals("def", ins.getChild4Age());
	}
	
	@Test
	public void testChild4CareTypeGetterSetter() {
	    SupportService ins = new SupportService();
	    ins.setChild4CareType("abc");
	    assertEquals("abc", ins.getChild4CareType());
	    ins.setChild4CareType("def");
	    assertEquals("def", ins.getChild4CareType());
	}
	
	@Test
	public void testChild5AgeGetterSetter() {
	    SupportService ins = new SupportService();
	    ins.setChild5Age("abc");
	    assertEquals("abc", ins.getChild5Age());
	    ins.setChild5Age("def");
	    assertEquals("def", ins.getChild5Age());
	}
	
	@Test
	public void testChild5CareTypeGetterSetter() {
	    SupportService ins = new SupportService();
	    ins.setChild5CareType("abc");
	    assertEquals("abc", ins.getChild5CareType());
	    ins.setChild5CareType("def");
	    assertEquals("def", ins.getChild5CareType());
	}
	
	@Test
	public void testTransportationGetterSetter() {
	    SupportService ins = new SupportService();
	    ins.setTransportation(true);
	    assertTrue(ins.getTransportation());
	    ins.setTransportation(false);
	    assertFalse(ins.getTransportation());
	}
	
	@Test
	public void testDisabilitiesGetterSetter() {
	    SupportService ins = new SupportService();
	    ins.setDisabilities(true);
	    assertTrue(ins.getDisabilities());
	    ins.setDisabilities(false);
	    assertFalse(ins.getDisabilities());
	}
	
	@Test
	public void testTranslateBetweenGetterSetter() {
	    SupportService ins = new SupportService();
	    ins.setTranslateBetween("abc");
	    assertEquals("abc", ins.getTranslateBetween());
	    ins.setTranslateBetween("def");
	    assertEquals("def", ins.getTranslateBetween());
	}
	
	@Test
	public void testTranslateAndGetterSetter() {
	    SupportService ins = new SupportService();
	    ins.setTranslateAnd("abc");
	    assertEquals("abc", ins.getTranslateAnd());
	    ins.setTranslateAnd("def");
	    assertEquals("def", ins.getTranslateAnd());
	}
	
	@Test
	public void testInterpreteBetweenGetterSetter() {
	    SupportService ins = new SupportService();
	    ins.setInterpreteBetween("abc");
	    assertEquals("abc", ins.getInterpreteBetween());
	    ins.setInterpreteBetween("def");
	    assertEquals("def", ins.getInterpreteBetween());
	}
	
	@Test
	public void testInterpreteAndGetterSetter() {
	    SupportService ins = new SupportService();
	    ins.setInterpreteAnd("abc");
	    assertEquals("abc", ins.getInterpreteAnd());
	    ins.setInterpreteAnd("def");
	    assertEquals("def", ins.getInterpreteAnd());
	}
	
	@Test
	public void testCrisisCounsellingGetterSetter() {
	    SupportService ins = new SupportService();
	    ins.setCrisisCounselling(true);
	    assertTrue(ins.getCrisisCounselling());
	    ins.setCrisisCounselling(false);
	    assertFalse(ins.getCrisisCounselling());
	}
	
	@Test
	public void testUpdateReasonGetterSetter() {
	    SupportService ins = new SupportService();
	    ins.setUpdateReason("abc");
	    assertEquals("abc", ins.getUpdateReason());
	    ins.setUpdateReason("def");
	    assertEquals("def", ins.getUpdateReason());
	}

	
}
