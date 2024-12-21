package com.sbr.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbr.dao.CustomerDao;
import com.sbr.entities.Customer;

@Service
public class CustomerService {

	@Autowired
	CustomerDao customerDao;

	public List<Customer> getAllCustomerList() {
		List<Customer> allCustomerList = customerDao.getAllCustomerList();
		return allCustomerList;

	}

	public Customer getCustomerById(Long id) {
		List<Customer> allCustomerList = customerDao.getAllCustomerList();
		for (Customer customer : allCustomerList) {
			if (customer.getId() == id) {
				return new Customer(id, customer.getName(), customer.getEmail(), customer.getAccounts());
			}

		}
		return null;
	}

	public Customer saveCustomer(Customer customer) {
		customerDao.saveCustomer(customer);
		return customer;

	}

	public Customer deleCustomerById(Long id) {

		return customerDao.deleCustomerById(id);

	}

}
