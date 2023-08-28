package com.examplemicroservice.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examplemicroservice.user.VO.Department;
import com.examplemicroservice.user.VO.ResponseTemplateVO;
import com.examplemicroservice.user.entity.Users;
import com.examplemicroservice.user.service.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	public static final String USER_SERVICE = "userService";
	
	@PostMapping("/")
	public Users saveUser(@RequestBody Users user) {
		return userService.saveUser(user);
	}
	
	/*
	 * @GetMapping("/{id}") public Users findUserById(@PathVariable("id") Long
	 * userId) { return userService.findUserById(userId); }
	 */
	
	/*
	 * @GetMapping("/{id}") public ResponseTemplateVO
	 * getUserWithDepartment(@PathVariable("id") Long userId) { return
	 * userService.getUserWithDepartment(userId); }
	 */
	
	@GetMapping("/{id}")
	@CircuitBreaker(name = USER_SERVICE, fallbackMethod = "userServiceFallBackMethod")
	public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId) {
		return userService.getUserWithDepartment(userId);
	}
	
	public ResponseTemplateVO userServiceFallBackMethod(Exception exp) {
		ResponseTemplateVO vo = new ResponseTemplateVO();
		
		Department dept = new Department();
		dept.setDepartmentAddress("Sample Address");
		dept.setDepartmentCode("Sample code");
		dept.setDepartmentId((long) 1001);
		dept.setDepartmentName("Sample name");
		
		vo.setDepartment(dept);
		
		Users user = new Users();
		user.setDepartmentId((long) 10001);
		user.setEmail("sample email");
		user.setFirstName("sample first name");
		user.setLastName("Sample last name");
		user.setUserId((long) 10020);
		vo.setUser(user);
		return vo;
	}
	
}
