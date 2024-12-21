package com.sbr.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbr.entities.Course;
import com.sbr.services.CourseService;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

	@Autowired
	private CourseService courseService;

	@GetMapping
	public List<Course> getAllCourses() {
		return courseService.getAllCourses();
	}

	@GetMapping("/{id}")
	public Course getCourseById(@PathVariable Long id) {
		return courseService.getCourseById(id);
	}

	@PostMapping
	public Course createCourse(@RequestBody Course course) {
		Course saveCourse = courseService.saveCourse(course);
		return saveCourse;
	}

	@PutMapping("/{id}")
	public Course updateCourse(@PathVariable Long id, @RequestBody Course courseDetails) {
		Course course = courseService.getCourseById(id);// DB se
		if (course != null) {
			course.setName(courseDetails.getName()); // hamara data set
			courseService.saveCourse(course);
		}
		return course;
	}

	@DeleteMapping("/{id}")
	public String deleteCourse(@PathVariable Long id) {
		Course deleteCourse = courseService.deleteCourse(id);
		return "Deleted Successful: " + deleteCourse.getId() + " " + deleteCourse.getName();
	}
}
