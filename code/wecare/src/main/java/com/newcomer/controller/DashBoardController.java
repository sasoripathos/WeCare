package com.newcomer.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Path;
import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.newcomer.dbservice.UserRepository;
import com.newcomer.entity.User;
import com.newcomer.fileprocessor.FileProcessor;
import com.newcomer.fileprocessor.checker.CellError;
import com.opencsv.CSVWriter;

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
	
	
	@GetMapping("/query")
	@ModelAttribute
	public ResponseEntity<InputStreamResource> data(@RequestParam("query") String query, String db_collection, Model model) throws FileNotFoundException {
	   
		if (!query.equals(new String("NeedAssessRef"))) {
			model.addAttribute("my_results", "No such template");
			CSVWriter file = null;
			try {
				file = new CSVWriter(new FileWriter("empty.csv"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			return ResponseEntity.ok()
					 .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + "empty.csv" + "\"")
					 .contentType(MediaType.APPLICATION_PDF).contentLength(0)
					 .body(new InputStreamResource(new FileInputStream("empty.csv")));
			
		}

		
		System.out.println("code executed");
		File file = new File("report.csv");
		FileWriter report = null;
		try {
			report = new FileWriter("report.csv");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		CSVWriter csvWriter = new CSVWriter(report);
			
			try {
				
				String url         = "mongodb://weCare:newcomers100@ds117691.mlab.com:17691/team3";
				MongoClientURI uri = new MongoClientURI(url);
				MongoClient mongo_client = new MongoClient(uri);
				MongoDatabase db = mongo_client.getDatabase("team3");
				MongoCollection<org.bson.Document> collection = db.getCollection(query);
				
				
				MongoCursor<org.bson.Document> data = collection.find().iterator();
				
				
				try {
					
					
			
			        csvWriter.writeNext(new String[]{"identifierValue", "procDetail","updateRecordID", "startDate", "serviceLanguage","institutionType","referredBy","completedAndShared", "endDate"});
			       
			        while(data.hasNext()){
						Document nxt = data.next();
						csvWriter.writeNext(new String[]{nxt.get("identifierValue").toString(),nxt.get("procDetail").toString(),nxt.get("updateRecordID").toString(),nxt.get("startDate").toString(),nxt.get("serviceLanguage").toString(),nxt.get("institutionType").toString(),nxt.get("referredBy").toString(),nxt.get("completedAndShared").toString(),nxt.get("endDate").toString()});
						
					}
			 
			        csvWriter.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        
				
			
				data.close();
				mongo_client.close();
				model.addAttribute("my_results", "Success");
				
				
			} catch (MongoException e) {
				
			}
			
			InputStreamResource resource = null;
			try {
				resource = new InputStreamResource(new FileInputStream("report.csv"));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			 return ResponseEntity.ok()
			 .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"")
			 .contentType(MediaType.APPLICATION_PDF).contentLength(file.length())
			 .body(resource);
		}
	
}
