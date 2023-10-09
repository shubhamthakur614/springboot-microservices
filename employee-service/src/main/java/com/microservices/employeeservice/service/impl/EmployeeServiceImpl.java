package com.microservices.employeeservice.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservices.employeeservice.dto.ApiResponseDto;
import com.microservices.employeeservice.dto.DepartmentDto;
import com.microservices.employeeservice.dto.EmployeeDto;
import com.microservices.employeeservice.entity.Employee;
import com.microservices.employeeservice.exception.ResourceNotFoundException;
import com.microservices.employeeservice.repository.EmployeeRespository;
import com.microservices.employeeservice.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRespository employeeRespository;

	private ModelMapper modelMapper;

	private RestTemplate restTemplate;

	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		Employee employee = modelMapper.map(employeeDto, Employee.class);
		Employee saved = employeeRespository.save(employee);
		return modelMapper.map(saved, EmployeeDto.class);
	}

	@Override
	public ApiResponseDto getEmployeeById(Long id) {
		Employee employee = employeeRespository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));

		System.out.println("http://localhost:8080/api/departments/" + employee.getDepartmentCode());
		ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity(
				"http://localhost:8080/api/departments/" + employee.getDepartmentCode(), DepartmentDto.class);
		DepartmentDto departmentDto = responseEntity.getBody();

		EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);
		ApiResponseDto apiResponseDto = new ApiResponseDto(employeeDto, departmentDto);
		return apiResponseDto;
	}

}
