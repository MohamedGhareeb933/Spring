package com.example.springboot.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.springboot.thymeleafdemo.entity.Employee;

@Controller
@RequestMapping("/employees")
public class ThymeleafController {
	
	private List<Employee> employee;
	
	@PostConstruct
	private void loadData() {
		
		employee = new ArrayList<>();
		
		employee.add(new Employee(1, "mohamed", "ahmed", "mohamed@gmail.com"));
		employee.add(new Employee(2, "mostafa", "ahmed", "mostafa@gmail.com"));
		employee.add(new Employee(3, "ahmed", "ghareeb", "ahmed@gmail.com"));
	}
	
	@GetMapping("/list")
	public String printTime(Model theModel) {
		
		theModel.addAttribute("employees", employee);
		
		return "list-employee";
	}
	
}


