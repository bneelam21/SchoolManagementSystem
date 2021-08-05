package com.example.demo.repository;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Exam;

public interface ExamRepository  extends CrudRepository<Exam, String>{
	
	//@Query("select e.exam_name, e.subject, e.standard from exam_info e where e.exam_date = ?1")
	@Query("select e from exam_info e where e.exam_date = ?1")
	public Collection<Exam> getByDate(String exam_date);
	
	//@Query("select e.exam_name, e.subject, e.exam_date from exam_info e where e.standard = ?1")
	@Query("select e from exam_info e where e.standard = ?1")
	public Collection<Exam> getByStandard(String standard);
	
	//@Query("select e.subject, e.exam_date, e.standard from exam_info e where e.exam_name = ?1")
	@Query("select e from exam_info e where e.exam_name = ?1")
	public Collection<Exam> getByName(String exam_name);
}