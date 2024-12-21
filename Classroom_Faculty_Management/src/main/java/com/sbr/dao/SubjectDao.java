package com.sbr.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sbr.entities.Subject;

@Repository
public class SubjectDao {
	@Autowired
	SessionFactory sessionFactory;

	public List<Subject> getAllSubjects() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Subject.class);
		List<Subject> list = criteria.list();
		return list;
	}

	public Subject saveSubject(Subject subject) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(subject);
		transaction.commit();
		return subject;

	}

	public Subject deleteSubject(Long id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Subject subject = session.load(Subject.class, id);
		session.delete(subject);
		transaction.commit();
		return subject;
	}

}
