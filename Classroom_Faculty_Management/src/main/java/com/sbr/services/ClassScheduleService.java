package com.sbr.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbr.dao.ClassScheduleDao;
import com.sbr.entities.ClassSchedule;

@Service
public class ClassScheduleService {
	@Autowired
	ClassScheduleDao classScheduleDao;

	public List<ClassSchedule> getAllClassSchedules() {
		List<ClassSchedule> allClassSchedules = classScheduleDao.getAllClassSchedules();
		return allClassSchedules;
	}

	public ClassSchedule getClassScheduleById(Long id) {
		List<ClassSchedule> allClassSchedules = classScheduleDao.getAllClassSchedules();
		for (ClassSchedule classSchedule : allClassSchedules) {
			if (classSchedule.getId() == id) {
				return classSchedule;
			}
		}
		return null;
	}

	public ClassSchedule saveClassSchedule(ClassSchedule classSchedule) {

		return classScheduleDao.saveClassSchedule(classSchedule);
	}

	public ClassSchedule deleteClassSchedule(Long id) {
		return classScheduleDao.deleteClassSchedule(id);

	}

}
