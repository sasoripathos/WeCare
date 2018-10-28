package com.newcomer.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {

	/**
	 * User logout
	 * @param request the HTTP request for logout.
	 * @return the view's name of welcome page.
	 */
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		session.invalidate();
		System.out.println("You have logout!");
		return "redirect:/";
	}
}
