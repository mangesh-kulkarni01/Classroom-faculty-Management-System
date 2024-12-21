package com.sbr.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbr.dao.CourseDao;
import com.sbr.entities.Course;

@Service
public class CourseService {
	@Autowired
	CourseDao courseDao;

	public List<Course> getAllCourses() {
		List<Course> allCourses = courseDao.getAllCourses();
		return allCourses;
	}

	public Course getCourseById(Long id) {
		List<Course> allCourses = courseDao.getAllCourses();
		for (Course course : allCourses) {
			if (id == course.getId()) {
				return new Course(id, course.getName());
			}
		}
		return null;
	}

	public Course saveCourse(Course course) {
		Course saveCourse = courseDao.saveCourse(course);
		return saveCourse;

	}

	public Course deleteCourse(Long id) {
		Course deleteCourseById = courseDao.deleteCourseById(id);
		return deleteCourseById;
	}

}
