package com.shapara.springdemo.mvc;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.shapara.springdemo.mvc.validation.CourseCode;

public class Customer {
	
	private String firstName;
	
	@NotNull(message="is Required") // last name must be fill in 
	@Size(min=1, max=20, message="is Required") // has length of characters min 1 and max of 20 and custom message is required 
	private String lastName;
	
	@NotNull(message="is Required")  // must fill in - has custom message 
	@Min(value = 1, message="must be Greate Than 1") // has min value of 1 and Custom message in case less than 1 has Entered
	@Max(value = 10, message="must be Less than 10") // has max value of 10 - custom message 
	private Integer freePasses;
	
	
	//regular expression 5 char lower and upper case and digits Accepted 
	@Pattern(regexp="[a-zA-Z0-9]{5}", message= "only 5 Digits is Accepted")  
	private String postalCode;
	
	//custom validity course code prefixed with shr or luv
	@CourseCode(value={"SHR", "LUV"}, message="must Start with SHR or LUV")
	private String courseCode;
	
	
	
	// setters and getters 
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getFreePasses() {
		return freePasses;
	}

	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	

}
