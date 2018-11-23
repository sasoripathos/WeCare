package com.newcomer.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

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
public class LogoutControllerTest {

	@Autowired
	private UserRepository repo;
	
	@Autowired
	private MockMvc mockmvc;

	@Before
	public void init() throws Exception {
		User a = new User("Amy", "amy@gmail.com", "Agency", "12345", "ABC");
		User b = new User("Boris", "boris@gmail.com", "TEQ", "65432", "");
		User c = new User("Cindy", "cindy@gmail.com", "UTSC", "98765", "");
		repo.save(a);
		repo.save(b);
		repo.save(c);
	}
	
	@Test
	public void testAgencyUserLogout() throws Exception {
		User a = new User();
		HttpSession session = mockmvc.perform(post("/login")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("email", "amy@gmail.com")
				.param("password", "12345")
				.sessionAttr("loginUser", a))
			 .andReturn().getRequest().getSession();
		
		mockmvc.perform(post("/logout").session((MockHttpSession) session))
			.andExpect(status().is3xxRedirection())
			.andExpect(view().name("redirect:/"));
		
		try {
			session.isNew();
			fail();
		} catch(IllegalStateException e) {
			
		}
	}
	
	@Test
	public void testUTSCUserLogout() throws Exception {
		User a = new User();
		HttpSession session = mockmvc.perform(post("/login")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("email", "cindy@gmail.com")
				.param("password", "98765")
				.sessionAttr("loginUser", a))
			 .andReturn().getRequest().getSession();
		
		mockmvc.perform(post("/logout").session((MockHttpSession) session))
			.andExpect(status().is3xxRedirection())
			.andExpect(view().name("redirect:/"));
		
		try {
			session.isNew();
			fail();
		} catch(IllegalStateException e) {
		}
	}
	
	@Test
	public void testTEQUserLogout() throws Exception {
		User a = new User();
		HttpSession session = mockmvc.perform(post("/login")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("email", "boris@gmail.com")
				.param("password", "65432")
				.sessionAttr("loginUser", a))
			 .andReturn().getRequest().getSession();
		
		mockmvc.perform(post("/logout").session((MockHttpSession) session))
			.andExpect(status().is3xxRedirection())
			.andExpect(view().name("redirect:/"));
		
		try {
			session.isNew();
			fail();
		} catch(IllegalStateException e) {
			
		}
	}
	
	@After
	public void clean() {
		repo.deleteAll();
	}
}
