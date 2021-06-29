package com.testbdi.springboot.app.employees.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.testbdi.springboot.app.employees.models.entity.Employee;

public interface EmployeeDao extends CrudRepository<Employee, Long> {

}
