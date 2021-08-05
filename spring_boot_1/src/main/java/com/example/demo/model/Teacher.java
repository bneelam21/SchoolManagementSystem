package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Teacher extends Person
{
	@Id
	@Column
	private String employee_id;
	@Column
	private String department;
	@Column
	private String salary;
	@Column
	private String designation;
	@Column
	private String experience;
	
	public Teacher()
	{
		
	}

	public Teacher(String employee_id, String department, String salary, String designation, String experience) {
		super();
		this.employee_id = employee_id;
		this.department = department;
		this.salary = salary;
		this.designation = designation;
		this.experience = experience;
	}

	public String getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}
	
		
}
