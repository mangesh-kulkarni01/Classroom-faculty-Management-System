package com.sbr.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sbr.entities.Department;

@Repository
public class DepartmentDao {
	@Autowired
	SessionFactory sessionFactory;

	public List<Department> getAllDepartments() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Department.class);
		List<Department> list = criteria.list();
		session.close();
		return list;
	}

	public Department saveDepartment(Department department) {
		Session session = sessionFactory.openSession();
		Transaction txTransaction = session.beginTransaction();
		session.saveOrUpdate(department);
		txTransaction.commit();
		return department;

	}

	public Department deleteDepartment(Long id) {
		Session session = sessionFactory.openSession();
		Transaction txTransaction = session.beginTransaction();
		Department department = session.load(Department.class, id);
		session.delete(department);
		txTransaction.commit();
		return department;

	}

}
