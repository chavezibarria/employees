package com.testbdi.springboot.app.employees;


import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.apache.catalina.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.testbdi.springboot.app.employees.models.dao.EmployeeDao;
import com.testbdi.springboot.app.employees.models.entity.Employee;

@Configuration
public class LoadDatabase {
	
	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
	
	@SuppressWarnings("deprecation")
	@Bean
	CommandLineRunner initDatabase(EmployeeDao employeeDao) {
		
		try {
		    
		    Reader reader = new InputStreamReader(this.getClass()
		            .getResourceAsStream("/data.json"));

		    List<Employee> employees = new Gson().fromJson(reader, new TypeToken<List<Employee>>() {}.getType());

		    employees.forEach(e -> employeeDao.save(e));
		    
		    
		    reader.close();

		} catch (Exception ex) {
		    ex.printStackTrace();
		}
		
		return args -> {
			
			log.info("data import succesfull");
			
		};
	}
	
}
