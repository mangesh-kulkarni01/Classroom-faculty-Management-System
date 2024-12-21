package com.sbr.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbr.dao.FacultyAttendenceDao;
import com.sbr.entities.FacultyAttendance;

@Service
public class FacultyAttendanceService {
	@Autowired
	FacultyAttendenceDao facultyAttendenceDao;

	public List<FacultyAttendance> getAllFacultyAttendances() {

		List<FacultyAttendance> allFacultyAttendances = facultyAttendenceDao.getAllFacultyAttendances();

		return allFacultyAttendances;
	}

	public FacultyAttendance getFacultyAttendanceById(Long id) {
		List<FacultyAttendance> allFacultyAttendances = facultyAttendenceDao.getAllFacultyAttendances();
		for (FacultyAttendance facultyAttendance : allFacultyAttendances) {
			if (facultyAttendance.getId() == id) {
				return facultyAttendance;
			}
		}
		return null;
	}

	public FacultyAttendance saveFacultyAttendance(FacultyAttendance facultyAttendance) {
		return facultyAttendenceDao.saveFacultyAttendance(facultyAttendance);

	}

	public FacultyAttendance deleteFacultyAttendance(Long id) {
		return facultyAttendenceDao.deleteFacultyAttendance(id);

	}

}
