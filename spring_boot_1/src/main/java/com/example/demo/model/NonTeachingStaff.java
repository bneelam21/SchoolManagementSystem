package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class NonTeachingStaff extends Person
{
	@Id
	private String employee_id;
	private String designation;
	public String getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	
}