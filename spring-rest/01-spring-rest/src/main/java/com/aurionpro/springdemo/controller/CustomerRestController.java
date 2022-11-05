package com.aurionpro.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.springdemo.entity.Customer;
import com.aurionpro.springdemo.service.CustomerService;

@RestController
@RequestMapping("/app")
public class CustomerRestController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/customers")
	public List<Customer> getCustomers() {

		return customerService.getCustomers();

	}

	@GetMapping("/customers/{customerID}")
	public Customer getCustomerById(@PathVariable int customerID) {
		Customer customer = customerService.getcustomerById(customerID);
		return customer;

	}

	
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer customer) {

		customer.setId(0);
		customerService.addCustomer(customer);
		
		return customer;

	}
	
	@PutMapping("/customers")
	public Customer putCustomer(@RequestBody Customer customer) {

		customerService.addCustomer(customer);
		
		return customer;

	}
	
    @DeleteMapping("/customers/{customerID}")
	public void deleteCustomerById(@PathVariable int customerID) {
		 customerService.deleteCustomer(customerID);
		

	}

}
