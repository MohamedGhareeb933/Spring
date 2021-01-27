package com.shapara.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	
	
	// Controller Method to show the initial HTML form
	@RequestMapping("/RequestName")
	public String RequestName() {
		return "name-request";
	}
	
	// Controller Method to process the HTML Name Request 
	@RequestMapping("/SubmitName")
	public String SubmitName() {
		return "name-submit";
	}
	
	@RequestMapping("/Message")
	public String PrintAllCaps(HttpServletRequest request, Model model) {
		
		// read the request parameter from HTML FORM
		String theName = request.getParameter("StudentName");
		
		theName = theName.toUpperCase();
		
		model.addAttribute("Shouting", theName);
		
		return "name-submit";
	}
	

	@RequestMapping("/MessageParam")
	public String PrintAllCapsParam( // read the request parameter from HTML FORM
			@RequestParam("StudentName") String theName, Model model) { 
		
		theName = theName.toUpperCase();
		
		model.addAttribute("Shouting", theName);
		
		return "name-submit";
	}
	
}
