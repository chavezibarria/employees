package com.testbdi.springboot.app.employees.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testbdi.springboot.app.employees.models.entity.Employee;
import com.testbdi.springboot.app.employees.models.service.IEmployeeService;

@RestController
@RequestMapping("/")
public class EmployeeController {

	
	@Autowired
	private IEmployeeService employeeService;
	
	@GetMapping("/listar")
	public List<Employee> listar(){
		return employeeService.findAll();
	}
	
	@GetMapping("/listar/{id}")
	public Employee detalle(@PathVariable Long id) {
		return employeeService.findById(id);
	}
	
	@GetMapping("/borrar/{id}")
	public void borrar(@PathVariable Long id) {
		employeeService.delete(id);
	}
	
	
}
