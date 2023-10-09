package com.microservices.employeeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.employeeservice.entity.Employee;

@Repository
public interface EmployeeRespository extends JpaRepository<Employee, Long>{

}
