package com.sbr.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbr.dao.FacultyDao;
import com.sbr.entities.Faculty;

@Service
public class FacultyService {
	@Autowired
	FacultyDao facultyDao;

	public List<Faculty> getAllFaculties() {

		List<Faculty> allFaculties = facultyDao.getAllFaculties();
		return allFaculties;
	}

	public Faculty getFacultyById(Long id) {
		List<Faculty> allFaculties = facultyDao.getAllFaculties();
		for (Faculty faculty : allFaculties) {
			if (faculty.getId() == id) {
				return faculty;
			}
		}
		return null;
	}

	public Faculty saveFaculty(Faculty faculty) {
		return facultyDao.saveFaculty(faculty);
	}

	public Faculty deleteFaculty(Long id) {
		return facultyDao.deleteFaculty(id);

	}

}
