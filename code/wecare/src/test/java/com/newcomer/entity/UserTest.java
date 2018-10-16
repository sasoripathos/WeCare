package com.newcomer.entity;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserTest {

	@Test
	public void testConstructorWithoutParameter() {
		User user = null;
		user = new User();
		assertNotNull(user);
		assertTrue(user instanceof User);
	}
	
	@Test
	public void testConstructorWithParameter() {
		User user = null;
		user = new User("Bob", "123@mail.com", "Agency", "12345", "ABC");
		assertNotNull(user);
		assertTrue(user instanceof User);
	}
	
	@Test
	public void testIdGetterSetter() {
		User user = null;
		user = new User("Bob", "123@mail.com", "Agency", "12345", "ABC");
		assertNotEquals("new ID", user.getId());
		user.setId("new ID");
		assertEquals("new ID", user.getId());
	}
	
	@Test
	public void testNameGetterSetter() {
		User user = null;
		user = new User("Bob", "123@mail.com", "Agency", "12345", "ABC");
		assertEquals("Bob", user.getName());
		user.setName("Alice");
		assertEquals("Alice", user.getName());
	}
	
	@Test
	public void testEmailGetterSetter() {
		User user = null;
		user = new User("Bob", "123@mail.com", "Agency", "12345", "ABC");
		assertEquals("123@mail.com", user.getEmail());
		user.setEmail("456@mail.com");
		assertEquals("456@mail.com", user.getEmail());
	}
	
	@Test
	public void testRoleGetterSetter() {
		User user = null;
		user = new User("Bob", "123@mail.com", "Agency", "12345", "ABC");
		assertEquals("Agency", user.getRole());
		user.setRole("Government");
		assertEquals("Government", user.getRole());
	}
	
	@Test
	public void testPasswordGetterSetter() {
		User user = null;
		user = new User("Bob", "123@mail.com", "Agency", "12345", "ABC");
		assertEquals("12345", user.getPassword());
		user.setPassword("54321");
		assertEquals("54321", user.getPassword());
	}
	
	@Test
	public void testAgencyGetterSetter() {
		User user = null;
		user = new User("Bob", "123@mail.com", "Agency", "12345", "ABC");
		assertEquals("ABC", user.getAgency());
		user.setAgency("SDF");
		assertEquals("SDF", user.getAgency());
	}
	

}
