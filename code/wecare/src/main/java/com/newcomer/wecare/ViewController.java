package com.newcomer.wecare;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.newcomer.dbservice.UserRepository;
import com.newcomer.entity.User;


@Controller
public class ViewController {
	
	/**
	 * MongoDB repository for user.
	 */
	@Autowired
	private UserRepository repo;
	
	/**
	 * Current session's user.
	 */
	private User user;
	
	/**
	 * Display the welcome page.
	 * @return the view's name of welcome page.
	 */
	@RequestMapping("/")
	public String welcomePage() {
		return "index";
	}
	
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
		this.user = repo.findByEmail(email);
		if(user != null && user.getEmail().equals(email)
				&& user.getPassword().equals(loginUser.getPassword())) {
			// If provided credential is valid
			HttpSession session = request.getSession(false);
			// Attach user email to this session
			session.setAttribute("user", email);
			// Set session time out to be 30 minutes
			session.setMaxInactiveInterval(60*30);
			return "redirect:/dashboard";
		}
		return "redirect:/login";
	}
	
	/**
	 * Display the dashboard.
	 * @param request request the HTTP request for displaying dashboard.
	 * @param model the model for data transmission.
	 * @return the index page if no user login or session has timed out, the view's name of
	 *     dashboard if user logged in and session hasn't timed out.
	 */
	@RequestMapping("/dashboard")
	public String dashboard(HttpServletRequest request, Model model) {
		HttpSession session = this.isLogin(request);
		if(session == null) {
			System.out.println("session has timeout");
			return "redirect:/";
		}
		model.addAttribute("loginUser", this.user);
		return "dashboard";
	}
	
	/**
	 * Check whether the current session has a user logged in and whether has timeout.
	 * @param request one request for resources in this web application
	 * @return null if no user login or session has timed out, return the session object otherwise.
	 */
	private HttpSession isLogin(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session == null || session.getAttribute("user") == null) {
			return null;
		} else {
			return session;
		}
	}

}
