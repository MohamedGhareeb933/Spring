package com.example.springboot.thymeleafdemo.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {
	
	@GetMapping("/time")
	public String printTime(Model theModel) {
		theModel.addAttribute("theDate", new Date());
		
		return "print-time";
	}
}
