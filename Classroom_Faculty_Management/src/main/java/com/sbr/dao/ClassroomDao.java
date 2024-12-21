package com.sbr.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sbr.entities.Classroom;

@Repository
public class ClassroomDao {
	@Autowired
	SessionFactory sessionFactory;
	Classroom classroom;

	public List<Classroom> getAllClassrooms() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Classroom.class);
		List<Classroom> list = criteria.list();
		return list;
	}

	public void saveClassroom(Classroom classroom) {
		Session session = sessionFactory.openSession();
		Transaction txTransaction = session.beginTransaction();
		session.saveOrUpdate(classroom);
		txTransaction.commit();
	}

	public void deleteClassroom(Long id) {
		Session session = sessionFactory.openSession();
		Transaction txTransaction = session.beginTransaction();
		Classroom classroom3 = session.load(Classroom.class, id);
		session.delete(classroom3);
		txTransaction.commit();

	}

}
