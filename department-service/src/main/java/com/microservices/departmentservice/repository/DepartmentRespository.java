package com.microservices.departmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.departmentservice.entity.Department;

@Repository
public interface DepartmentRespository extends JpaRepository<Department, Long> {

	Department findByDepartmentCode(String departmentCode);
}
