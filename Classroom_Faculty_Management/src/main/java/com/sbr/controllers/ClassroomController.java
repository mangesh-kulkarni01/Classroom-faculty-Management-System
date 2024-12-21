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

import com.sbr.entities.Classroom;
import com.sbr.services.ClassroomService;

@RestController
@RequestMapping("/api/classrooms")
public class ClassroomController {

	@Autowired
	private ClassroomService classroomService;

	@GetMapping
	public List<Classroom> getAllClassrooms() {
		return classroomService.getAllClassrooms();
	}

	@GetMapping("/{id}")
	public Classroom getClassroomById(@PathVariable Long id) {
		Classroom byId = classroomService.getClassroomById(id);
		return byId;
	}

	@PostMapping
	public Classroom createClassroom(@RequestBody Classroom classroom) {
		classroomService.saveClassroom(classroom);
		return classroom;
	}

	@PutMapping("/{id}")
	public Classroom updateClassroom(@PathVariable Long id, @RequestBody Classroom classroomDetails) {
		Classroom classroom = classroomService.getClassroomById(id);
		if (classroom != null) {
			classroom.setName(classroomDetails.getName());
			classroomService.saveClassroom(classroom);
		}
		return classroom;
	}

	@DeleteMapping("/{id}")
	public String deleteClassroom(@PathVariable Long id) {
		if (id == null) {
			return "no id found for deleting";
		} else {
			classroomService.deleteClassroom(id);
			return "data deleted...";
		}
	}
}
