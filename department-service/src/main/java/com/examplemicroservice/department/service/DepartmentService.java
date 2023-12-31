package com.examplemicroservice.department.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examplemicroservice.department.entity.Department;
import com.examplemicroservice.department.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	public Department saveDepartment(Department department) {
		
		return departmentRepository.save(department);
	}

	public Department findDepartmentById(Long departmentId) {

		return departmentRepository.findByDepartmentId(departmentId);
	}

	public List<Department> getDepartments() {
	
		return departmentRepository.findAll();
	}
}
