package com.newcomer.fileprocessor;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.newcomer.wecare.App;

@RunWith(SpringRunner.class)
@TestPropertySource(locations="classpath:test.properties")
@SpringBootTest(classes = App.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
public class ValueTranslatorTest {
	
	@Autowired
	private ValueTranslator trans;
	
	@Test
	public void testTrueRightCase() {
		assertTrue(trans.toBool("Yes"));
	}
	
	@Test
	public void testTrueMixCase() {
		assertTrue(trans.toBool("YeS"));
	}
	
	@Test
	public void testFalseRightCase() {
		assertFalse(trans.toBool("No"));
	}
	
	@Test
	public void testFalseMixCase() {
		assertFalse(trans.toBool("nO"));
	}
}
