package com.testbdi.springboot.app.employees.models.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.testbdi.springboot.app.employees.models.entity.Employee;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Override
	public List<Employee> findAll() {
		return null;
	}

	@Override
	public Employee findById(Long Id) {
		return null;
	}

}
