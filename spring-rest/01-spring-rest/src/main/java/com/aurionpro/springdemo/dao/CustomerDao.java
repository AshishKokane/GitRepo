package com.aurionpro.springdemo.dao;

import java.util.List;

import com.aurionpro.springdemo.entity.Customer;

public interface CustomerDao {

	public List<Customer> getCustomers();

	public Customer getCustomerByID(int customerID);

	public void addCustomers(Customer customer);

	public void deleteCustomerByID(int customerID);
}
