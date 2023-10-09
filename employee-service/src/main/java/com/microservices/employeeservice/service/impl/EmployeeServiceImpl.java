package com.microservices.employeeservice.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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

	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		Employee employee = modelMapper.map(employeeDto, Employee.class);
		Employee saved = employeeRespository.save(employee);
		return modelMapper.map(saved, EmployeeDto.class);
	}

	@Override
	public EmployeeDto getEmployeeById(Long id) {
		Employee employee = employeeRespository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
		return modelMapper.map(employee, EmployeeDto.class);
	}

}
