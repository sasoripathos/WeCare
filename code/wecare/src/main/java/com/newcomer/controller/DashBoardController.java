package com.newcomer.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.newcomer.dbservice.UserRepository;
import com.newcomer.entity.User;
import com.newcomer.fileprocessor.FileProcessor;
import com.newcomer.fileprocessor.loader.NeedAssessRefLoader;

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
	
	@PostMapping("/upload")
	public String fileUpload(@RequestParam("file1") MultipartFile file) {
		// Create file processor
		FileProcessor processor = new FileProcessor();
		processor.registerLoader(new NeedAssessRefLoader());
		
		// Start load process
		processor.process(file);
		return "upload_result";
	}

}
