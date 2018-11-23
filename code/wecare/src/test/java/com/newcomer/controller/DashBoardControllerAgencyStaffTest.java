package com.newcomer.controller;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

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
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.newcomer.dbservice.MockFileRepository;
import com.newcomer.dbservice.NeedAssessRefRepository;
import com.newcomer.dbservice.NewcomerRepository;
import com.newcomer.dbservice.SupportServiceRepository;
import com.newcomer.dbservice.UserRepository;
import com.newcomer.entity.User;
import com.newcomer.fileprocessor.checker.CellError;
import com.newcomer.wecare.App;

@RunWith(SpringRunner.class)
@TestPropertySource(locations="classpath:test.properties")
@SpringBootTest(classes = App.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
@AutoConfigureMockMvc
public class DashBoardControllerAgencyStaffTest {

	@Autowired
	private UserRepository repo;
	
	@Autowired
	private MockMvc mockmvc;
	
	@Autowired
	private MockFileRepository mockrepo;
	
	@Autowired
	private NeedAssessRefRepository narRepo;
	
	@Autowired
	private NewcomerRepository newcomerRepo;
	
	@Autowired
	private SupportServiceRepository supservRepo;
	
	private HttpSession session;
	
	@Before
	public void init() throws Exception {
		User a = new User("Amy", "amy@gmail.com", "Agency", "12345", "ABC");
		User loginUser = new User();
		repo.save(a);
		session = mockmvc.perform(post("/login")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("email", "amy@gmail.com")
				.param("password", "12345")
				.sessionAttr("loginUser", loginUser))
			.andReturn().getRequest().getSession();
	}
	
	@Test
	public void testGetDashBoard() throws Exception {
		mockmvc.perform(get("/dashboard").session((MockHttpSession) session))
			.andExpect(status().isOk())
			.andExpect(model().attribute("loginUser", hasProperty("name", is("Amy"))))
			.andExpect(model().attribute("loginUser", hasProperty("email", is("amy@gmail.com"))))
			.andExpect(model().attribute("loginUser", hasProperty("role", is("Agency"))));
	}
	
	@Test
	public void testUploadMockFilePass() throws Exception {
		InputStream in = this.getClass().getResourceAsStream("MockTemplate_Pass.xlsx");
		MockMultipartFile file = new MockMultipartFile("file1", "MockTemplate_Pass.xlsx", "multipart/form-data", in);
		mockmvc.perform(multipart("/upload").file(file).session((MockHttpSession) session))
			.andExpect(status().isOk())
			.andExpect(view().name("upload_result"))
			.andExpect(model().attribute("resultState", is("Successful")));
		assertEquals(4, mockrepo.findAll().size());
	}
	
	@Test
	public void testUploadMockFileFail() throws Exception {
		InputStream in = this.getClass().getResourceAsStream("MockTemplate_Error.xlsx");
		MockMultipartFile file = new MockMultipartFile("file1", "MockTemplate_Error.xlsx", "multipart/form-data", in);
		List<CellError> errors = new ArrayList<CellError>();
		errors.add(new CellError(5,1,CellError.nullError));
		MvcResult result = mockmvc.perform(multipart("/upload").file(file).session((MockHttpSession) session))
			.andExpect(status().isOk())
			.andExpect(view().name("upload_result"))
			.andExpect(model().attribute("resultState", is("Failed")))
			.andExpect(model().attribute("reason", is("Errors exist")))
			.andReturn();
		
		assertEquals(0, mockrepo.findAll().size());
		assertEquals(errors.toString(), result.getModelAndView().getModel().get("errors").toString());
	}
	
	@Test
	public void testUploadMockFileUnknown() throws Exception {
		InputStream in = this.getClass().getResourceAsStream("UnknownTemplate.xlsx");
		MockMultipartFile file = new MockMultipartFile("file1", "UnknownTemplate.xlsx", "multipart/form-data", in);
		List<CellError> errors = new ArrayList<CellError>();
		errors.add(new CellError(5,1,CellError.nullError));
		mockmvc.perform(multipart("/upload").file(file).session((MockHttpSession) session))
			.andExpect(status().isOk())
			.andExpect(view().name("upload_result"))
			.andExpect(model().attribute("resultState", is("Failed")))
			.andExpect(model().attribute("reason", is("Unknown template")));
		
		assertEquals(0, mockrepo.findAll().size());
	}
	
	@Test
	public void testUploadNarFilePass() throws Exception {
		InputStream in = this.getClass().getResourceAsStream("nar_Pass.xlsx");
		MockMultipartFile file = new MockMultipartFile("file1", "nar_Pass.xlsx", "multipart/form-data", in);
		mockmvc.perform(multipart("/upload").file(file).session((MockHttpSession) session))
			.andExpect(status().isOk())
			.andExpect(view().name("upload_result"))
			.andExpect(model().attribute("resultState", is("Successful")));
		assertEquals(2, narRepo.findAll().size());
		assertEquals(2, newcomerRepo.findAll().size());
		assertEquals(2, supservRepo.findAll().size());
	}
	
	@Test
	public void testUploadNarFileFail() throws Exception {
		InputStream in = this.getClass().getResourceAsStream("nar_Error.xlsx");
		MockMultipartFile file = new MockMultipartFile("file1", "nar_Error.xlsx", "multipart/form-data", in);
		List<CellError> errors = new ArrayList<CellError>();
		errors.add(new CellError(3,3,CellError.nullError));
		errors.add(new CellError(4,39,CellError.nullError));
		MvcResult result = mockmvc.perform(multipart("/upload").file(file).session((MockHttpSession) session))
			.andExpect(status().isOk())
			.andExpect(view().name("upload_result"))
			.andExpect(model().attribute("resultState", is("Failed")))
			.andExpect(model().attribute("reason", is("Errors exist")))
			.andReturn();
		
		assertEquals(0, narRepo.findAll().size());
		assertEquals(0, newcomerRepo.findAll().size());
		assertEquals(0, supservRepo.findAll().size());
		assertEquals(errors.toString(), result.getModelAndView().getModel().get("errors").toString());
	}
	
	@After
	public void clean() {
		repo.deleteAll();
		mockrepo.deleteAll();
		narRepo.deleteAll();
		newcomerRepo.deleteAll();
		supservRepo.deleteAll();
		session.invalidate();
	}

}
