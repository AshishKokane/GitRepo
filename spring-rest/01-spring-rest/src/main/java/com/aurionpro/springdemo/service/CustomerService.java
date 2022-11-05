package com.aurionpro.springdemo.service;

import java.util.List;

import com.aurionpro.springdemo.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();

	public Customer getcustomerById(int customerID);

	public void addCustomer(Customer customer);

	public void deleteCustomer(int customerID);

}
