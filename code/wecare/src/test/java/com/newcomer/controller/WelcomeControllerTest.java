package com.newcomer.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import com.newcomer.wecare.App;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class WelcomeControllerTest {

	@LocalServerPort
	private int port;
	
	@Autowired
	private WelcomeController ctl;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void testContextLoad() {
		assertThat(ctl).isNotNull();
	}
	
	@Test
	public void shouldReturnWelcomePage() {
		assertThat(restTemplate.getForObject("http://localhost:" + port + "/", String.class))
			.contains("Welcome to weCare system! Sign in to upload files or generate reports.");
	}

}
