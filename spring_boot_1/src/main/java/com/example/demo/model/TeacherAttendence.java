package com.example.demo.model;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name = "employee_attendence")
public class TeacherAttendence 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long attendence_id;

	@Column
	private String employee_id;
	@Column
	private LocalDate Entry_date;
	@Column
	private Time logintime;
	@Column
	private Time logouttime;
	
	public TeacherAttendence()
	{
		
	}
	public String getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}
	public LocalDate getEntry_date() {
		return Entry_date;
	}
	public void setEntry_date(LocalDate entry_date) {
		Entry_date = entry_date;
	}
	public Time getLogintime() {
		return logintime;
	}
	public void setLogintime(Time logintime) {
		this.logintime = logintime;
	}
	public Time getLogouttime() {
		return logouttime;
	}
	public void setLogouttime(Time logouttime) {
		this.logouttime = logouttime;
	}
}
