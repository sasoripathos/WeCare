package com.newcomer.wecare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.newcomer")
@EntityScan("com.newcomer")
public class App {
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args); 
		System.out.println("Hello world!");
	}
}
