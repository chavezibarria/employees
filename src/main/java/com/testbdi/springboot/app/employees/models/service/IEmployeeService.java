package com.testbdi.springboot.app.employees.models.service;

import java.util.List;

import com.testbdi.springboot.app.employees.models.entity.Employee;

public interface IEmployeeService {
	
	public List<Employee> findAll();
	
	public Employee findById(Long id);
	
	public Employee addOrUpdateEmployee(Employee employee);
	
	public void delete(Long id);
}
