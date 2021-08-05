package com.example.demo.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;


@Repository
public class StudentRepository 
{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public List<Map<String, Object>> getRecord()
	{
		List<Map<String, Object>> details = jdbcTemplate.queryForList("select * from FeePayment");
		System.out.println(details);
		return details;
	}
	public List<Map<String, Object>> Getstudentdetails()
	{
		List<Map<String, Object>> details = jdbcTemplate.queryForList("select * from studentdata");
		System.out.println(details);
		return details;
	}
	public List<Map<String, Object>> Getteacherdetails()
	{
		List<Map<String, Object>> details = jdbcTemplate.queryForList("select * from teacherdata");
		System.out.println(details);
		return details;
	}
	public List<Map<String, Object>> GetNonTeachingStaffDetails() 
	{
		List<Map<String, Object>> details = jdbcTemplate.queryForList("select * from nonteachingstaffdata");
		System.out.println(details);
		return details;
	}
	/*public int AddStudent(Student student)
	{
		String query = "insert into student values(?,?,?)";
		int insert = jdbcTemplate.update(query,student.getStudent_id(),student.getRank(),student.getClass_room());
		return insert;
	}
	public int UpdateStudent(Student student)
	{
		String query = "update student set Ranking = " + student.getRank() + " where studentid = " + student.getStudent_id();
		int update = jdbcTemplate.update(query);
		return update;
	}*/
}
