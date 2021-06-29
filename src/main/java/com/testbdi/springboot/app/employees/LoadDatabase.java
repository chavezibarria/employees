package com.testbdi.springboot.app.employees;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.testbdi.springboot.app.employees.models.dao.EmployeeDao;
import com.testbdi.springboot.app.employees.models.entity.Employee;

@Configuration
public class LoadDatabase {
	
	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
	
	@SuppressWarnings("deprecation")
	@Bean
	CommandLineRunner initDatabase(EmployeeDao employeeDao) {
		
		Employee employee1 = new Employee("Pepe", "P", "Pecas", new Date("01/01/2021"), new Date("01/01/2021"));
		Employee employee2 = new Employee("Calebsio", "D", "Calabacio", new Date("01/01/2021"), new Date("01/01/2021"));
		
		return args -> {
			
			log.info("Loading " +  employeeDao.save(employee1));
			
			log.info("Loading " +  employeeDao.save(employee2));
		};
	}
}
