package com.example.demo.model;
import java.sql.Time;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="staff_attendence")
public class NonTeachingStaffAttendence {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long attendence_id;
	@Column
	private String employee_id;
	@Column
	private LocalDate entry_date;
	@Column
	private Time login_time;
	@Column
	private Time logout_time;
	public String getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}
	public LocalDate getEntry_date() {
		return entry_date;
	}
	public void setEntry_date(LocalDate entry_date) {
		this.entry_date = entry_date;
	}
	public Time getLogin_time() {
		return login_time;
	}
	public void setLogin_time(Time login_time) {
		this.login_time = login_time;
	}
	public Time getLogout_time() {
		return logout_time;
	}
	public void setLogout_time(Time logout_time) {
		this.logout_time = logout_time;
	}
	
	
}