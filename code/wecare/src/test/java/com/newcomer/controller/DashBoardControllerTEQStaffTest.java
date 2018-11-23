package com.newcomer.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import javax.servlet.http.HttpSession;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.newcomer.dbservice.UserRepository;
import com.newcomer.entity.User;
import com.newcomer.wecare.App;

@RunWith(SpringRunner.class)
@TestPropertySource(locations="classpath:test.properties")
@SpringBootTest(classes = App.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
@AutoConfigureMockMvc
public class DashBoardControllerTEQStaffTest {
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private MockMvc mockmvc;
	
	private HttpSession session;
	
	@Before
	public void init() throws Exception {
		User a = new User("Bob", "bob@gmail.com", "TEQ", "12345", "");
		User loginUser = new User();
		repo.save(a);
		session = mockmvc.perform(post("/login")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("email", "bob@gmail.com")
				.param("password", "12345")
				.sessionAttr("loginUser", loginUser))
			.andReturn().getRequest().getSession();
	}
	
	@Test
	public void testAddAccountEmptyParameter() throws Exception {
		mockmvc.perform(post("/newaccount").session((MockHttpSession) session)
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("firstname", "").param("email", "123@abc.com").param("password", "12345")
				.param("role", "Agency").param("agency", ""))
			.andExpect(status().is3xxRedirection())
			.andExpect(view().name("redirect:/dashboard"));
		// Insert doesn't success
		assertNull(repo.findByEmail("123@abc.com"));
	}
	
	@Test
	public void testAddAccountNoAgencyForAgencyUser() throws Exception {
		mockmvc.perform(post("/newaccount").session((MockHttpSession) session)
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("firstname", "someone").param("email", "123@abc.com").param("password", "12345")
				.param("role", "Agency").param("agency", ""))
			.andExpect(status().is3xxRedirection())
			.andExpect(view().name("redirect:/dashboard"));
		// Insert doesn't success
		assertNull(repo.findByEmail("123@abc.com"));
	}
	
	@Test
	public void testAddAccountUserExisted() throws Exception {
		mockmvc.perform(post("/newaccount").session((MockHttpSession) session)
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("firstname", "someone").param("email", "bob@gmail.com").param("password", "12345")
				.param("role", "UTSC").param("agency", ""))
			.andExpect(status().is3xxRedirection())
			.andExpect(view().name("redirect:/dashboard"));
		// Insert doesn't success
		assertEquals(1, repo.findAll().size());
	}
	
	@Test
	public void testAddAccountAgencyUserSuccess() throws Exception {
		mockmvc.perform(post("/newaccount").session((MockHttpSession) session)
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("firstname", "someone").param("email", "123@abc.com").param("password", "12345")
				.param("role", "Agency").param("agency", "abc"))
			.andExpect(status().is3xxRedirection())
			.andExpect(view().name("redirect:/dashboard"));
		// Insert doesn't success
		User newUser = repo.findByEmail("123@abc.com");
		assertNotNull(newUser);
		assertEquals("someone", newUser.getName());
		assertEquals("123@abc.com", newUser.getEmail());
		assertEquals("12345", newUser.getPassword());
		assertEquals("Agency", newUser.getRole());
		assertEquals("abc", newUser.getAgency());
	}
	
	@Test
	public void testAddAccountTEQUserSuccess() throws Exception {
		mockmvc.perform(post("/newaccount").session((MockHttpSession) session)
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("firstname", "someone").param("email", "123@abc.com").param("password", "12345")
				.param("role", "TEQ").param("agency", ""))
			.andExpect(status().is3xxRedirection())
			.andExpect(view().name("redirect:/dashboard"));
		// Insert doesn't success
		User newUser = repo.findByEmail("123@abc.com");
		assertNotNull(newUser);
		assertEquals("someone", newUser.getName());
		assertEquals("123@abc.com", newUser.getEmail());
		assertEquals("12345", newUser.getPassword());
		assertEquals("TEQ", newUser.getRole());
		assertEquals("", newUser.getAgency());
	}
	
	@Test
	public void testAddAccountUTSCUserSuccess() throws Exception {
		mockmvc.perform(post("/newaccount").session((MockHttpSession) session)
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("firstname", "someone").param("email", "123@abc.com").param("password", "12345")
				.param("role", "UTSC").param("agency", ""))
			.andExpect(status().is3xxRedirection())
			.andExpect(view().name("redirect:/dashboard"));
		// Insert doesn't success
		User newUser = repo.findByEmail("123@abc.com");
		assertNotNull(newUser);
		assertEquals("someone", newUser.getName());
		assertEquals("123@abc.com", newUser.getEmail());
		assertEquals("12345", newUser.getPassword());
		assertEquals("UTSC", newUser.getRole());
		assertEquals("", newUser.getAgency());
	}
	
	@After
	public void clean() {
		repo.deleteAll();
		session.invalidate();
	}


}
