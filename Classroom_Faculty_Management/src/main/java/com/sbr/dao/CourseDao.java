package com.sbr.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sbr.entities.Course;

@Repository
public class CourseDao {
	@Autowired
	SessionFactory sessionFactory;

	public List<Course> getAllCourses() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Course.class);
		List<Course> list = criteria.list();
		return list;

	}

	public Course saveCourse(Course course) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(course);
		transaction.commit();
		return course;

	}

	public Course deleteCourseById(Long id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Course course = session.load(Course.class, id);
		session.delete(course);
		transaction.commit();
		return course;

	}

}
