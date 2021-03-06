package com.newcomer.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.newcomer.dbservice.UserRepository;
import com.newcomer.entity.User;
import com.newcomer.exception.InvalidParameterException;
import com.newcomer.exception.UserExistedException;
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
	
	/**
	 * FileProcessot services
	 */
	@Autowired
	private FileProcessor processor;
	
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
		HttpSession session = request.getSession(false);
		User user = repo.findByEmail((String)session.getAttribute("user"));
		// Load login user to dashboard
		model.addAttribute("loginUser", user);
		return "dashboard";
	}
	
	/**
	 * Extract data from template, check error and save data.
	 * 
	 * @param file the uploaded template.
	 * @return upload result page.
	 */
	@PostMapping("/upload")
	public ModelAndView fileUpload(@RequestParam("file1") MultipartFile file) {
		// Process file
		List<CellError> errors = processor.process(file);
		ModelAndView resultPage= new  ModelAndView("upload_result");
		if(errors == null) {
			// If null result is return, template is unknown
			resultPage.addObject("resultState", "Failed");
			resultPage.addObject("reason", "Unknown template");
		} else if (errors.size() == 0) {
			// If no error is returned, upload succeed
			resultPage.addObject("resultState", "Successful");
		} else {
			// Else, there are some errors, upload failed
			resultPage.addObject("resultState", "Failed");
			resultPage.addObject("reason", "Errors exist");
			resultPage.addObject("errors", errors);
		}
		return resultPage;
	}
	
	/**
	 * Create new account for new system user.
	 */
	@PostMapping("/newaccount")
	public String addAccount(RedirectAttributes rediAttr, @RequestParam("firstname") String name, 
			@RequestParam("email") String email, @RequestParam("password") String password, 
			@RequestParam("role") String role, @RequestParam("agency") String agency)
					throws UserExistedException, InvalidParameterException {

		// By default the parameters will should be required
		if(name.trim().equals("") || email.trim().equals("") || password.trim().equals("") || role.trim().equals("")) {
			// If any required parameter is empty, throw exception
			throw new InvalidParameterException();
		}
		if(role.trim().equals("Agency") && agency.trim().equals("")) {
			// If agency is not specified when try to create an agency account, throw exception
			throw new InvalidParameterException();
		}
		
		User exist = repo.findByEmail(email);
		if(exist != null) {
			// If email is used, throw exception
			throw new UserExistedException(email);
			
		} else {
			// create new account
			User newUser = new User(name, email, role, password, agency);
			repo.save(newUser);
			
		}
		rediAttr.addFlashAttribute("state", "New account created successfully!");
		return "redirect:/dashboard";
	}
	
	
	/**
	 * Generate report for user query.
	 */
	@SuppressWarnings("resource")
	@GetMapping("/query")
	@ModelAttribute
	public ResponseEntity<InputStreamResource> data(@RequestParam("template") String template,
			@RequestParam("query") String query, String db_collection,
			Model model) throws FileNotFoundException {
		System.out.println(template);
		System.out.println(query);
		
		if (!template.equals(new String("NeedAssessRef"))) {
			model.addAttribute("my_results", "No such template");
			CSVWriter file = null;
			try {
				file = new CSVWriter(new FileWriter("empty.csv"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(file.hashCode());
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
			e1.printStackTrace();
		}
		CSVWriter csvWriter = new CSVWriter(report);
			try {
				String url         = "mongodb://weCare:newcomers100@ds117691.mlab.com:17691/team3";
				MongoClientURI uri = new MongoClientURI(url);
				MongoClient mongo_client = new MongoClient(uri);
				MongoDatabase db = mongo_client.getDatabase("team3");
				MongoCollection<org.bson.Document> collection = db.getCollection(template);
				csvWriter = writeData(collection,csvWriter);
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
			 .contentType(MediaType.TEXT_PLAIN).contentLength(file.length())
			 .body(resource);
		}
	
	/**
	 * Write mongodb documents data into .csv file.
	 */
	private CSVWriter writeData(MongoCollection<org.bson.Document> coll, CSVWriter csvWriter){
		MongoCursor<org.bson.Document> data = coll.find().iterator();
		try {
			String id       = "identifierValue";
			String details  = "procDetail";
			String recrdId  = "updateRecordID";
			String stDate   = "startDate";
			String language = "serviceLanguage";
			String instType = "institutionType";
			String ref      = "referredBy";
			String shared   = "completedAndShared";
			String enDate   = "endDate";
			// Write column headers
	        csvWriter.writeNext(new String[]{id, details,recrdId, stDate, language,instType,ref,shared, enDate});
	        // Write each row into the file
	        while(data.hasNext()){
				Document nxt = data.next();
				String col1 = nxt.get("identifierValue").toString();
				String col2 = nxt.get("procDetail").toString();
				String col3 = nxt.get("updateRecordID").toString();
				String col4 = nxt.get("startDate").toString();
				String col5 = nxt.get("serviceLanguage").toString();
				String col6 = nxt.get("institutionType").toString();
				String col7 = nxt.get("referredBy").toString();
				String col8 = nxt.get("completedAndShared").toString();
				String col9 = nxt.get("completedAndShared").toString();
				csvWriter.writeNext(new String[]{col1,col2,col3,col4,col5,col6,col7,col8,col9});
				
			}
	        csvWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		data.close();
		return csvWriter;
	}
	
}
