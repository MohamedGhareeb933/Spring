package com.shapara.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements 
			ConstraintValidator<CourseCode, String> {
	
	private String[] coursePrefix;
	
	@Override
	public void initialize(CourseCode theCourseCode) {
		// course prefix is equal to default annotation Array.
		coursePrefix = theCourseCode.value();
	}

	// first string argument is the value of html form
	// second arg is to give additional error messages 
	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext constraintValidatorContext) {
		
		boolean result = false;
		
		// check whether the user has entered an input in HTML FORM
		if(theCode !=null) { 
			// iterate thorough array of  value of the prefix
			for	(String getPrefix : coursePrefix) {
				
				// return true of the HTML Form input starts with valid value
				result = theCode.startsWith(getPrefix);
				
                // if we found a match then break out of the loop
				if(result) break;
			}
		}else {
			return true;
		}
		
		return result;
	}

	
}
