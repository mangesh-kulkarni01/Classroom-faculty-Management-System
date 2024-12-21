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

import com.sbr.entities.ClassSchedule;
import com.sbr.services.ClassScheduleService;

@RestController
@RequestMapping("/api/class-schedules")
public class ClassScheduleController {

	@Autowired
	private ClassScheduleService classScheduleService;

	@GetMapping
	public List<ClassSchedule> getAllClassSchedules() {
		return classScheduleService.getAllClassSchedules();
	}

	@GetMapping("/{id}")
	public ClassSchedule getClassScheduleById(@PathVariable Long id) {
		return classScheduleService.getClassScheduleById(id);
	}

	@PostMapping
	public ClassSchedule createClassSchedule(@RequestBody ClassSchedule classSchedule) {
		classScheduleService.saveClassSchedule(classSchedule);
		return classSchedule;
	}

	@PutMapping("/{id}")
	public ClassSchedule updateClassSchedule(@PathVariable Long id, @RequestBody ClassSchedule classScheduleDetails) {
		ClassSchedule classSchedule = classScheduleService.getClassScheduleById(id);
		if (classSchedule != null) {
			classSchedule.setSubjectId(classScheduleDetails.getSubjectId());
			classSchedule.setClassroomId(classScheduleDetails.getClassroomId());
			classSchedule.setDayOfWeek(classScheduleDetails.getDayOfWeek());
			classSchedule.setStartTime(classScheduleDetails.getStartTime());
			classSchedule.setEndTime(classScheduleDetails.getEndTime());
			classScheduleService.saveClassSchedule(classSchedule);
		}
		return classSchedule;
	}

	@DeleteMapping("/{id}")
	public String deleteClassSchedule(@PathVariable Long id) {
		ClassSchedule deleteClassSchedule = classScheduleService.deleteClassSchedule(id);
		return "Deleted SuccessFul :-" + deleteClassSchedule;
	}
}
