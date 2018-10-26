package com.newcomer.controller;

import java.io.IOException;


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
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;



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
		byte[] content = new byte[100];
		try {
			int a = file.getInputStream().read(content);
			System.out.println("Read: " + a + " bytes");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Something is wrong");
		}
		return "upload_result";
	}
	
	
	
	
	/**
	 * A method to read from the database given any collection and a query
	 * @param db_collection
	 * @param query
	 * @return the data read from mongodb
	 */
	@SuppressWarnings("deprecation")
	@PostMapping("/query")
	public static String readData(String db_collection, String entry, String query) {
		// Will add code to read data below;
		
		
		try {
			
			String url         = "mongodb://weCare:newcomers100@ds117691.mlab.com:17691/team3";
			MongoClientURI uri = new MongoClientURI(url);
			MongoClient mongo_client = new MongoClient(uri);
			MongoDatabase db = mongo_client.getDatabase("team3");
			MongoCollection<org.bson.Document> collection = db.getCollection(db_collection);
			
			MongoCursor<org.bson.Document> users = collection.find().iterator();
			
			while(users.hasNext()){
				
				org.bson.Document data = users.next();
				if(data.containsKey(entry)){
					
					String attr = data.getString(entry);
					if(attr.equals(query)){
						System.out.println(attr);
						System.out.println(data);
						
					}
					
				}
				
				
			}
			users.close();
			mongo_client.close();
			
			
			
		} catch (MongoException e) {
			
		}
		return "";
	}

}
