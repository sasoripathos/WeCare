package com.newcomer.controller;

import static org.hamcrest.Matchers.*;
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
public class LoginControllerTest {
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private MockMvc mockmvc;

	@Before
	public void init() {
		User a = new User("Amy", "amy@gmail.com", "Agency", "12345", "ABC");
		User b = new User("Boris", "boris@gmail.com", "TEQ", "65432", "");
		User c = new User("Cindy", "cindy@gmail.com", "UTSC", "98765", "");
		repo.save(a);
		repo.save(b);
		repo.save(c);
	}
	
	@Test
	public void testGetLoginPage() throws Exception {
		mockmvc.perform(get("/login"))
			.andExpect(status().isOk())
			.andExpect(view().name("login"))
			.andExpect(model().attribute("loginUser", hasProperty("id", nullValue())))
			.andExpect(model().attribute("loginUser", hasProperty("name", nullValue())))
			.andExpect(model().attribute("loginUser", hasProperty("email", nullValue())))
			.andExpect(model().attribute("loginUser", hasProperty("role", nullValue())))
			.andExpect(model().attribute("loginUser", hasProperty("password", nullValue())))
			.andExpect(model().attribute("loginUser", hasProperty("agency", nullValue())));
	}
	
	@Test
	public void testLoginAgencyUserSuccess() throws Exception {
		User b = new User();
		HttpSession session = mockmvc.perform(post("/login")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("email", "amy@gmail.com")
				.param("password", "12345")
				.sessionAttr("loginUser", b))
			.andExpect(status().is3xxRedirection())
			.andExpect(view().name("redirect:/dashboard"))
			.andReturn().getRequest().getSession();
		mockmvc.perform(get("/dashboard").session((MockHttpSession) session))
			.andExpect(status().isOk())
			.andExpect(model().attribute("loginUser", hasProperty("name", is("Amy"))))
			.andExpect(model().attribute("loginUser", hasProperty("email", is("amy@gmail.com"))))
			.andExpect(model().attribute("loginUser", hasProperty("role", is("Agency"))));
		
	}
	
	@Test
	public void testLoginAgencyUserFail() throws Exception {
		User b = new User();
		mockmvc.perform(post("/login")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("email", "amy@gmail.com")
				.param("password", "54321")
				.sessionAttr("loginUser", b))
			.andExpect(status().is3xxRedirection())
			.andExpect(view().name("redirect:/login"));
		
	}
	
	@Test
	public void testLoginTEQUserSuccess() throws Exception {
		User b = new User();
		HttpSession session = mockmvc.perform(post("/login")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("email", "boris@gmail.com")
				.param("password", "65432")
				.sessionAttr("loginUser", b))
			.andExpect(status().is3xxRedirection())
			.andExpect(view().name("redirect:/dashboard"))
			.andReturn().getRequest().getSession();
		
		mockmvc.perform(get("/dashboard").session((MockHttpSession) session))
			.andExpect(status().isOk())
			.andExpect(model().attribute("loginUser", hasProperty("name", is("Boris"))))
			.andExpect(model().attribute("loginUser", hasProperty("email", is("boris@gmail.com"))))
			.andExpect(model().attribute("loginUser", hasProperty("role", is("TEQ"))));
	}
	
	@Test
	public void testLoginTEQUserFail() throws Exception {
		User b = new User();
		mockmvc.perform(post("/login")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("email", "boris@gmail.com")
				.param("password", "54321")
				.sessionAttr("loginUser", b))
			.andExpect(status().is3xxRedirection())
			.andExpect(view().name("redirect:/login"));
	}
	
	@Test
	public void testLoginUTSCUserSuccess() throws Exception {
		User b = new User();
		HttpSession session = mockmvc.perform(post("/login")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("email", "cindy@gmail.com")
				.param("password", "98765")
				.sessionAttr("loginUser", b))
			.andExpect(status().is3xxRedirection())
			.andExpect(view().name("redirect:/dashboard"))
			.andReturn().getRequest().getSession();
		
		mockmvc.perform(get("/dashboard").session((MockHttpSession) session))
			.andExpect(status().isOk())
			.andExpect(model().attribute("loginUser", hasProperty("name", is("Cindy"))))
			.andExpect(model().attribute("loginUser", hasProperty("email", is("cindy@gmail.com"))))
			.andExpect(model().attribute("loginUser", hasProperty("role", is("UTSC"))));
	}
	
	@Test
	public void testLoginUTSCUserFail() throws Exception {
		User b = new User();
		mockmvc.perform(post("/login")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("email", "cendy@gmail.com")
				.param("password", "98765")
				.sessionAttr("loginUser", b))
			.andExpect(status().is3xxRedirection())
			.andExpect(view().name("redirect:/login"));
	}
	
	@After
	public void clean() {
		repo.deleteAll();
	}

}
