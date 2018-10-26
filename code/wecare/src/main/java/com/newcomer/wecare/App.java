package com.newcomer.wecare;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.newcomer.controller.DashBoardController;



@SpringBootApplication(scanBasePackages = {"com.newcomer"})
@EnableMongoRepositories("com.newcomer")
@EntityScan("com.newcomer")
public class App {
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args); 
		System.out.println("Hello world!");
		
		//find users in User collection where email address is alice@gmail.com
		DashBoardController.readData("User", "email", "alice@gmail.com");
		//find entries in collection User where name is Bob
		DashBoardController.readData("User", "name", "Bob");
	}
}
