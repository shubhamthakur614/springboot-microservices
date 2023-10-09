package com.microservices.departmentservice.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.departmentservice.dto.DepartmentDto;
import com.microservices.departmentservice.entity.Department;
import com.microservices.departmentservice.repository.DepartmentRespository;
import com.microservices.departmentservice.service.DepartmentService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentRespository departmentRespository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

		// converting the dto to entity class using model mapper library
		Department department = modelMapper.map(departmentDto, Department.class);
		Department saved = departmentRespository.save(department);
		return modelMapper.map(saved, DepartmentDto.class);
	}

	@Override
	public DepartmentDto getDepartmentByDepartmentCode(String departmentCode) {
		Department findByDepartmentCode = departmentRespository.findByDepartmentCode(departmentCode);
		return modelMapper.map(findByDepartmentCode, DepartmentDto.class);
	}

}
