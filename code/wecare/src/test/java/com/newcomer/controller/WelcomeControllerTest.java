package com.newcomer.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.newcomer.wecare.App;


@RunWith(SpringRunner.class)
@TestPropertySource(locations="classpath:test.properties")
@SpringBootTest(classes = App.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
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
			.contains("This platform allows agencies to serve new arrivals in the Scarborough area!");
	}

}
