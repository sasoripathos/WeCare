package com.newcomer.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.newcomer.dbservice.UserRepository;
import com.newcomer.entity.User;


@Controller
public class LoginController {
	
	/**
	 * MongoDB repository for user.
	 */
	@Autowired
	private UserRepository repo;
	
	/**
	 * Display the login page.
	 * @param model the model for data transmission.
	 * @return the view's name of login page.
	 */
	@GetMapping("/login")
	public String loginPage(Model model) {
		model.addAttribute("loginUser", new User());
		return "login";
	}
	
	/**
	 * Login validation process.
	 * @param request the HTTP request for login.
	 * @param loginUser the container for user credentials.
	 * @return the view's name of dashboard if credential valid, the view's name of login page is
	 *     credential invalid.
	 */
	@PostMapping("/login")
	public String loginProcess(HttpServletRequest request, @ModelAttribute("loginUser") User loginUser) {
		String email = loginUser.getEmail();
		// Get stored user information based on email
		User user = repo.findByEmail(email);
		if(user != null && user.getEmail().equals(email)
				&& user.getPassword().equals(loginUser.getPassword())) {
			// If provided credential is valid
			HttpSession session = request.getSession(false);
			// Attach user email to this session
			session.setAttribute("user", email);
			// Set session time out to be 30 minutes
			session.setMaxInactiveInterval(60*30);
			// Redirect user to dashboard
			return "redirect:/dashboard";
		}
		return "redirect:/login";
	}
	
}
