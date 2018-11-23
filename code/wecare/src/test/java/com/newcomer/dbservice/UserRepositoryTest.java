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

import com.newcomer.entity.User;
import com.newcomer.wecare.App;

@RunWith(SpringRunner.class)
@TestPropertySource(locations="classpath:test.properties")
@SpringBootTest(classes = App.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository repo;
	
	@Before
	public void init() {
		User a = new User("Jack", "jack@email.com", "UTSC", "12345", "DEF");
		repo.save(a);
	}

	@Test
	public void testSaveUser() {
		User a = new User("Jason", "test@email.com", "Agency", "12345", "ABC");
		assertTrue(repo.save(a) != null);
	}
	
	@Test
	public void testCanFindUser() {
		User b = repo.findByEmail("jack@email.com");
		assertEquals(b.getEmail(), "jack@email.com");
	}
	
	@Test
	public void testCannotFindUser() {
		User b = repo.findByEmail("alice@gmail.com");
		assertTrue(b == null);
	}
	
	@After
	public void clean() {
		repo.deleteAll();
	}
}
