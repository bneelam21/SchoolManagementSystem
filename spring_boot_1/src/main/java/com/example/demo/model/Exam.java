package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="exam_info")
public class Exam 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long exam_id;
	@Column
	private String exam_name;
	@Column
	private String subject;
	@Column
	private String exam_date;
	@Column
	private String exam_duration;
	@Column
	private String standard;
	@Column
	private String max_marks;
	@Column
	private String room_no;
	@Column
	private String invigilator;
	public String getExam_name() {
		return exam_name;
	}
	public void setExam_name(String exam_name) {
		this.exam_name = exam_name;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getExam_date() {
		return exam_date;
	}
	public void setExam_date(String exam_date) {
		this.exam_date = exam_date;
	}
	public String getExam_duration() {
		return exam_duration;
	}
	public void setExam_duration(String exam_duration) {
		this.exam_duration = exam_duration;
	}
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
	public String getMax_marks() {
		return max_marks;
	}
	public void setMax_marks(String max_marks) {
		this.max_marks = max_marks;
	}
	public String getRoom_no() {
		return room_no;
	}
	public void setRoom_no(String room_no) {
		this.room_no = room_no;
	}
	public String getInvigilator() {
		return invigilator;
	}
	public void setInvigilator(String invigilator) {
		this.invigilator = invigilator;
	}
	
	
}