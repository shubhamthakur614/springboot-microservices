package com.microservices.employeeservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservices.employeeservice.dto.DepartmentDto;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface ApiClient {
	//what ever the controller method we are call that method we have to give here and it automatically 
	//did the method implementation of that method
	@GetMapping("/api/departments/{departmentcode}")
	DepartmentDto getDepartmentByDepartmentCode(@PathVariable("departmentcode") String departmentcode);

}
