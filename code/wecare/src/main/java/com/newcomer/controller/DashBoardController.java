package com.newcomer.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.newcomer.dbservice.UserRepository;
import com.newcomer.entity.User;
import com.newcomer.fileprocessor.FileProcessor;
import com.newcomer.fileprocessor.checker.CellError;

@Controller
public class DashBoardController {

	/**
	 * MongoDB repository for user.
	 */
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private FileProcessor processor;
	
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
	public ModelAndView fileUpload(@RequestParam("file1") MultipartFile file) {
		List<CellError> errors = processor.process(file);
		ModelAndView resultPage= new  ModelAndView("upload_result");
		if(errors == null) {
			resultPage.addObject("resultState", "Failed");
			resultPage.addObject("reason", "Unknown template");
		} else if (errors.size() == 0) {
			resultPage.addObject("resultState", "Succeed");
			//resultPage.addObject("reason", "");
			System.out.println("Upload Success");
		} else {
			resultPage.addObject("resultState", "Failed");
			resultPage.addObject("reason", "Errors exist");
			resultPage.addObject("errors", errors);
			System.out.println("There are errors");
		}
		//return "upload_result";
		return resultPage;
	}

}
