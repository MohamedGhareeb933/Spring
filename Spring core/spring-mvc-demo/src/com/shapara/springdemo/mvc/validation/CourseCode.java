package com.shapara.springdemo.mvc.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


// Validator Class
@Constraint(validatedBy= CourseCodeConstraintValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD } )
@Retention(RetentionPolicy.RUNTIME)

// Java Annotation File.
public @interface CourseCode {
	
	// Define Default Value for Course Code , array of String cause we may enter more than one Value
	public String[] value() default {"LUV"};
	
	// Define Default Value for Error message
	public String message() default "must Start with ";
	
	//define Groups method from validation Constraint Method.
	// Class of type wildCard means Any.
    public Class<?>[] groups() default {};
    
    //define Payload Method From validation Constraint Method.
    public Class<? extends Payload>[] payload() default {};

}
