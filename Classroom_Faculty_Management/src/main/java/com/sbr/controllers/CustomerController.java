package com.sbr.controllers;

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

import com.sbr.entities.Customer;
import com.sbr.services.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@GetMapping
	public List<Customer> getAllCustomerList() {

		return customerService.getAllCustomerList();
	}

	@GetMapping("/{id}")
	public Customer getCustomerById(@PathVariable Long id) {
		return customerService.getCustomerById(id);

	}

	@PostMapping
	public Customer creatCustomer(@RequestBody Customer customer) {
		customerService.saveCustomer(customer);
		return customer;

	}

	@PutMapping("/{id}")
	public Customer updateCustomer(@PathVariable long id, @RequestBody Customer customer) {
		Customer customerId = customerService.getCustomerById(id);
		if (customerId != null) {
			customerId.setName(customer.getName());
			customerId.setEmail(customer.getEmail());
			customerId.setAccounts(customer.getAccounts());
			customerService.saveCustomer(customerId);
		}
		return customerId;

	}

	@DeleteMapping("/{id}")
	public String deleCustomerById(@PathVariable Long id) {
		Customer deleCustomerById = customerService.deleCustomerById(id);
		return "deleted SuccessFul" + deleCustomerById;
	}
}
