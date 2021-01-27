package com.shapara.springdemo.mvc;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	
	@InitBinder // Initializing on Every Web Request
	public void initBinder(WebDataBinder dataBinder)  {
		//removes white Space Leading and Trailing.
		StringTrimmerEditor stringTrimmer = new StringTrimmerEditor(true);
		// register Custom Editor on Data BInder
		dataBinder.registerCustomEditor(String.class, stringTrimmer);
	}
	
	
	
	@RequestMapping("/showForm") 
	// Model works as Container that Contain all types of objects Strings and DB.
	private String showForm(Model model) {
		
		// add Customer Object to Model Attribute.
		model.addAttribute("customer",  new Customer());
		
		// return JSP page File 
		return"customer-form";
	}
	
	
	@RequestMapping("/processForm")
	// @valid perform validation rules on the Customer attribute 
	// @binding result to Store the Validation Result in Binding Result 
	private String processForm(@Valid @ModelAttribute("customer") Customer customer,
			BindingResult theBinding) {
		
		System.out.println("Error Mesagges: " + theBinding);
		
		if(theBinding.hasErrors()) {
			return"customer-form";
		}else {
			return "customer-confirm";
		}
	}

}
