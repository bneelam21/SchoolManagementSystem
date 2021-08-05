package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student extends Person
{
	@Id
	@Column
	private String student_id;
	@Column
	private String student_rank;
	@Column
	private String class_room;
	
	public String getStudent_id() {
		return student_id;
	}
	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	public String getStudent_rank() {
		return student_rank;
	}
	public void setStudent_rank(String student_rank) {
		this.student_rank = student_rank;
	}
	public String getClass_room() {
		return class_room;
	}
	public void setClass_room(String class_room) {
		this.class_room = class_room;
	}
	public Student()
	{
		
	}
	public Student(String name, String age, String gender, String address, String student_id, String student_rank,
			String class_room) {
		super(name, age, gender, address);
		this.student_id = student_id;
		this.student_rank = student_rank;
		this.class_room = class_room;
	}

	
}
