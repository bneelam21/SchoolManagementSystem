package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "sports")
public class Sports 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long sports_id;
	@Column
	private String student_id;
	@Column
	private String student_name;
	@Column
	private int standard;
	@Column
	private String game;
	
	public String getStudent_id() 
	{
		return student_id;
	}
	public void setStudent_id(String student_id) 
	{
		this.student_id = student_id;
	}
	public String getStudent_name() 
	{
		return student_name;
	}
	public void setStudent_name(String student_name) 
	{
		this.student_name = student_name;
	}
	public int getStandard() 
	{
		return standard;
	}
	public void setStandard(int standard) 
	{
		this.standard = standard;
	}
	public String getGame() 
	{
		return game;
	}
	public void setGame(String game) 
	{
		this.game = game;
	}
}
