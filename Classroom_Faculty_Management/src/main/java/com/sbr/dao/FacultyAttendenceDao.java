package com.sbr.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sbr.entities.FacultyAttendance;

@Repository
public class FacultyAttendenceDao {
	@Autowired
	SessionFactory sessionFactory;

	public List<FacultyAttendance> getAllFacultyAttendances() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(FacultyAttendance.class);
		List<FacultyAttendance> list = criteria.list();

		return list;
	}

	public FacultyAttendance saveFacultyAttendance(FacultyAttendance facultyAttendance) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(facultyAttendance);
		transaction.commit();
		return facultyAttendance;
	}

	public FacultyAttendance deleteFacultyAttendance(Long id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		FacultyAttendance facultyAttendance = session.load(FacultyAttendance.class, id);
		session.delete(facultyAttendance);
		transaction.commit();

		return facultyAttendance;
	}

}
