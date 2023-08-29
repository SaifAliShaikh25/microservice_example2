package com.examplemicroservice.feignclient.utils;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.examplemicroservice.department.entity.Department;

@FeignClient(value = "myFeignClientDemo", url = "http://localhost:9191/departments")
public interface FeignServiceUtils {

	@GetMapping("/all")
	public List<Department> getDepartmentsAll();
}
