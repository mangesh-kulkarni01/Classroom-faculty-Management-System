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

import com.sbr.entities.Department;
import com.sbr.services.DepartmentService;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@GetMapping
	public List<Department> getAllDepartments() {
		return departmentService.getAllDepartments();
	}

	@GetMapping("/{id}")
	public Department getDepartmentById(@PathVariable Long id) {
		return departmentService.getDepartmentById(id);
	}

	@PostMapping
	public Department createDepartment(@RequestBody Department department) {
		departmentService.saveDepartment(department);
		return department;
	}

	@PutMapping("/{id}")
	public Department updateDepartment(@PathVariable Long id, @RequestBody Department departmentDetails) {
		Department department = departmentService.getDepartmentById(id);
		if (department != null) {
			department.setName(departmentDetails.getName());
			departmentService.saveDepartment(department);
		}
		return department;
	}

	@DeleteMapping("/{id}")
	public String deleteDepartment(@PathVariable Long id) {
		Department deleteDepartment = departmentService.deleteDepartment(id);
		return "Deleted Successful :-" + deleteDepartment.getId() + " " + deleteDepartment.getName();
	}
}
