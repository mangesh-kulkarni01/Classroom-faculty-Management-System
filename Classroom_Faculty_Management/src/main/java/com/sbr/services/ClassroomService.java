package com.sbr.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbr.dao.ClassroomDao;
import com.sbr.entities.Classroom;

@Service
public class ClassroomService {
	@Autowired
	ClassroomDao classroomDao;

	public List<Classroom> getAllClassrooms() {
		List<Classroom> list = classroomDao.getAllClassrooms();

		return list;
	}

	public Classroom getClassroomById(Long id) {

		List<Classroom> list = classroomDao.getAllClassrooms();

		for (Classroom classroom : list) {
			if (id == classroom.getId()) {
				return new Classroom(id, classroom.getName());
			}
		}
		return null;

	}

	public Classroom saveClassroom(Classroom classroom) {
		classroomDao.saveClassroom(classroom);
		return new Classroom(classroom.getId(), classroom.getName());
	}

	public void deleteClassroom(Long id) {
		classroomDao.deleteClassroom(id);
	}

}
