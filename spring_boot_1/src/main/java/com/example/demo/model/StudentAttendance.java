package com.example.demo.model;

import java.sql.Time;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="student_attendance")
public class StudentAttendance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long attendence_id;

	@Column
	private String student_id;
	@Column
	private LocalDate entry_date;
	@Column
	private Time login_time;
	@Column
	private Time logout_time;
	
	public StudentAttendance() {
		this.student_id = null;
		this.entry_date = null;
		this.login_time = null;
		this.logout_time = null;
	}

	public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
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

	public StudentAttendance(String student_id, LocalDate entry_date, Time login_time, Time logout_time) {
		this.student_id = student_id;
		this.entry_date = entry_date;
		this.login_time = login_time;
		this.logout_time = logout_time;
	}
	
	
	
}