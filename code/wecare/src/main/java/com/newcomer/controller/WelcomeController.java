package com.newcomer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {
	
	/**
	 * Display the welcome page.
	 * @return the view's name of welcome page.
	 */
	@RequestMapping("/")
	public String welcomePage() {
		return "redirect:/login";
	}
}
