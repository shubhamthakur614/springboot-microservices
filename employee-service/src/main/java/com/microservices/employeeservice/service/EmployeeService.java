package com.microservices.employeeservice.service;

import com.microservices.employeeservice.dto.ApiResponseDto;
import com.microservices.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
	EmployeeDto saveEmployee(EmployeeDto employeeDto);
	
	ApiResponseDto getEmployeeById(Long id);

}
