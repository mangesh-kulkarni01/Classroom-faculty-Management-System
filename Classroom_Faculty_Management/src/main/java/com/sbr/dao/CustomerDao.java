package com.sbr.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sbr.entities.Customer;

@Repository
public class CustomerDao {
	@Autowired
	SessionFactory sessionFactory;

	public List<Customer> getAllCustomerList() {

		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Customer.class);
		List<Customer> list = criteria.list();
		for (Customer customer : list) {
			System.err.println(customer);
		}
		return list;

	}

	public Customer saveCustomer(Customer customer) {
		Session session = sessionFactory.openSession();
		Transaction txTransaction = session.beginTransaction();
		session.saveOrUpdate(customer);
		txTransaction.commit();
		return customer;

	}

	public Customer deleCustomerById(Long id) {
		Session session = sessionFactory.openSession();
		Transaction txTransaction = session.beginTransaction();
		Customer customer = session.load(Customer.class, id);
		session.delete(customer);
		txTransaction.commit();
		return customer;
	}

}
