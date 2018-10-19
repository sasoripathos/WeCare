package com.newcomer.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.newcomer.dbservice.UserRepository;
import com.newcomer.entity.User;

@Controller
public class DashBoardController {
	
	/**
	 * MongoDB repository for user.
	 */
	@Autowired
	private UserRepository repo;
	
	private User user;
	/**
	 * Display the dashboard.
	 * @param request request the HTTP request for displaying dashboard.
	 * @param model the model for data transmission.
	 * @return the index page if no user login or session has timed out, the view's name of
	 *     dashboard if user logged in and session hasn't timed out.
	 */
	@RequestMapping("/dashboard")
	public String dashboard(HttpServletRequest request, Model model) {
		// Get current login user
		HttpSession session = request.getSession();
		this.user = repo.findByEmail((String)session.getAttribute("user"));
		// Load login user to dashboard
		model.addAttribute("loginUser", this.user);
		return "dashboard";
	}

}
