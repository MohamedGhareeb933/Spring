package com.luv2code.springdemo.restController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class SayHello {
	
	@GetMapping("/test")
	public String sayHelloRest() {
		return "hello RestController";
	}

}
