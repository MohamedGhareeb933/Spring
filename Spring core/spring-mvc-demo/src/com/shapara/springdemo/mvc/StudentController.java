package com.shapara.springdemo.mvc;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	// Taking the Values from Properties File and Assign it to CountryList Map
	// util:properties in spring-mvc.xml
	@Value("#{countriesList}") 
	private Map<String, String> CountryList;
	
	@RequestMapping("/showForm")
	public String showForm(Model model) {
		
		// create Student object
		Student student = new Student();
		
		// add Student Object to the Model
		model.addAttribute("Student", student);
		model.addAttribute("CountryList", CountryList);

		return "student-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("Student") Student student) {
		
		System.out.println("the Student: " + student.getFirstName() 
							 + " " + student.getLastName() );
		return "student-confirm";
	}
}
