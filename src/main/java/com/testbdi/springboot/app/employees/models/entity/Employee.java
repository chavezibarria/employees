package com.testbdi.springboot.app.employees.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Employees")
@Getter
@Setter
public class Employee implements Serializable{
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "middle_initial")
	private String middleInitial;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "date_of_birth")
	@Temporal(TemporalType.DATE)
	private Date dateOfBith;
	
	@Column(name = "date_of_employment")
	@Temporal(TemporalType.DATE)
	private Date dateOfEmployment;
	
	private Boolean active;
	
	private static final long serialVersionUID = -8318168347968406648L;
	
	
	

}
