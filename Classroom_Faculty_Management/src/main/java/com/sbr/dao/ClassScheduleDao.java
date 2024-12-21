package com.sbr.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sbr.entities.ClassSchedule;

@Repository
public class ClassScheduleDao {
	@Autowired
	SessionFactory sessionFactory;

	public List<ClassSchedule> getAllClassSchedules() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(ClassSchedule.class);
		List<ClassSchedule> list = criteria.list();

		return list;
	}

	public ClassSchedule saveClassSchedule(ClassSchedule classSchedule) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(classSchedule);
		transaction.commit();
		return classSchedule;
	}

	public ClassSchedule deleteClassSchedule(Long id) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		ClassSchedule classSchedule = session.load(ClassSchedule.class, id);
		session.delete(classSchedule);
		transaction.commit();
		return classSchedule;
	}

}
