package com.microservices.departmentservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.departmentservice.dto.DepartmentDto;
import com.microservices.departmentservice.service.DepartmentService;

import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/departments")
@AllArgsConstructor
public class DepartmentController {

	private DepartmentService departmentService;

	// Build save Department Method
	@PostMapping
	public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto) {
		DepartmentDto saveDepartment = departmentService.saveDepartment(departmentDto);
		return new ResponseEntity<>(saveDepartment, HttpStatus.CREATED);
	}

	//@Path param used to pass value i url with "?" ex. /api/departments?code=10
	@GetMapping("/{departmentcode}")
	public ResponseEntity<DepartmentDto> getDepartmentByDepartmentCode(
			@PathVariable("departmentcode") String departmentcode) {
		DepartmentDto departmentByDepartmentCode = departmentService.getDepartmentByDepartmentCode(departmentcode);
		return new ResponseEntity<>(departmentByDepartmentCode, HttpStatus.OK);
	}

}
