package com.sbr.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sbr.entities.Faculty;

@Repository
public class FacultyDao {
	@Autowired
	SessionFactory sessionFactory;

	public List<Faculty> getAllFaculties() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Faculty.class);
		List<Faculty> list = criteria.list();

		return list;
	}

	public Faculty saveFaculty(Faculty faculty) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(faculty);
		transaction.commit();

		return faculty;
	}

	public Faculty deleteFaculty(Long id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Faculty faculty = session.load(Faculty.class, id);
		session.delete(faculty);
		transaction.commit();
		return faculty;
	}

}
