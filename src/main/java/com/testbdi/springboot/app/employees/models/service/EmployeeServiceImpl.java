package com.testbdi.springboot.app.employees.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.testbdi.springboot.app.employees.exceptions.EmployeeNotFoundException;
import com.testbdi.springboot.app.employees.models.dao.EmployeeDao;
import com.testbdi.springboot.app.employees.models.entity.Employee;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;

	@Override
	@Transactional(readOnly = true)
	public List<Employee> findAll() {
		return (List<Employee>) employeeDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Employee findById(Long id) {
		return employeeDao.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee not found in database"));
	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeDao.save(employee);
	}

	@Override
	public void delete(Long id) {
		employeeDao.deleteById(id);
	}
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<String> handleNoSuchElementFoundException(EmployeeNotFoundException exception) {
	    return ResponseEntity
	        .status(HttpStatus.NOT_FOUND)
	        .body(exception.getMessage());
	}

	

}
