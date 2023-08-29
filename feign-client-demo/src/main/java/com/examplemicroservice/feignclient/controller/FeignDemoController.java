package com.examplemicroservice.feignclient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examplemicroservice.department.entity.Department;
import com.examplemicroservice.feignclient.utils.FeignServiceUtils;

@RestController
@RequestMapping("/feigndemo")
public class FeignDemoController {

	@Autowired
	private FeignServiceUtils feignServiceUtils;
	
	@GetMapping("/all-departments")
	public List<Department> getAllDepartments(){
		
		return feignServiceUtils.getDepartmentsAll();
	}
}
