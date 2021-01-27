package com.mohamed.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mohamed.springdemo.entity.Customer;
import com.mohamed.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//Inject Customer DAO into Customer Controller.
	@Autowired // Spring will scan for a component that implements CustomerService interface which is CustomerServiceImple
	private CustomerService customerService;
	
	@GetMapping("/list") // only response for get Request 
	public String listCustomer(Model model) {
		
		// get customers from service 
		List<Customer> customerList = customerService.CustomerList();
		// add Customers to spring mvc model
		model.addAttribute("customerList", customerList);
		
		return "list-customers";
	}
	
	@GetMapping("showFormForAdd")
	public String showFormForAdd(Model model) {
		
		Customer customer = new Customer();
		
		model.addAttribute("customer", customer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		
		customerService.saveCustomer(customer);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int id, Model model) {
		
		Customer customer = customerService.getCustomer(id);
		
		model.addAttribute("customer", customer);
		
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("customerId") int id) {
		
		customerService.deleteCustomer(id);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/search")
	public String searchCustomer(@RequestParam("searchCustomer") String searchCustomer, Model model) {
		
		List<Customer> customer = customerService.searchCustomer(searchCustomer);
		
		model.addAttribute("customerList", customer);
		
		return "list-customers";
	}
}
