package com.microservices.employeeservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.employeeservice.dto.ApiResponseDto;
import com.microservices.employeeservice.dto.EmployeeDto;
import com.microservices.employeeservice.service.EmployeeService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {

	private EmployeeService employeeService;

	// Build save Employee Method
	@PostMapping
	public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {
		EmployeeDto saveEmployee = employeeService.saveEmployee(employeeDto);
		return new ResponseEntity<>(saveEmployee, HttpStatus.CREATED);
	}

	// @Path param used to pass value i url with "?" ex. /api/departments?code=10
//	@GetMapping("/{id}")
//	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") long id) {
//		EmployeeDto EmployeeById = employeeService.getEmployeeById(id);
//		return new ResponseEntity<>(EmployeeById, HttpStatus.OK);
//	}

	// modifying method for the communication between employee and department
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponseDto> getEmployeeById(@PathVariable("id") long id) {
		ApiResponseDto apiResponseDto = employeeService.getEmployeeById(id);
		return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
	}
}
