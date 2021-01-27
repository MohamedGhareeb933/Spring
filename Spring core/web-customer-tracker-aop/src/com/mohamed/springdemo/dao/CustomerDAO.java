package com.mohamed.springdemo.dao;

import java.util.List;

import com.mohamed.springdemo.entity.Customer;

// Data Access Object Interface
public interface CustomerDAO {
	
	public List<Customer> getCustomerList();

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int id);

	public void deleteCustomer(int id);

	public List<Customer> searchCustomer(String searchCustomer);
	
}
