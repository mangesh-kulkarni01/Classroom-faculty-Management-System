package com.sbr.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbr.dao.DepartmentDao;
import com.sbr.entities.Department;

@Service
public class DepartmentService {
	@Autowired
	DepartmentDao departmentDao;

	public List<Department> getAllDepartments() {
		List<Department> allDepartments = departmentDao.getAllDepartments();

		return allDepartments;
	}

	public Department getDepartmentById(Long id) {
		List<Department> allDepartments = departmentDao.getAllDepartments();
		for (Department department : allDepartments) {
			if (id == department.getId()) {
				return new Department(id, department.getName());
			}
		}
		return null;
	}

	public Department saveDepartment(Department department) {
		departmentDao.saveDepartment(department);
		return department;

	}

	public Department deleteDepartment(Long id) {
		Department deleteDepartment = departmentDao.deleteDepartment(id);
		return deleteDepartment;

	}

}
