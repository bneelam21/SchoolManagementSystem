package com.example.demo.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Exam;
import com.example.demo.repository.ExamRepository;

@Service
public class ExamService {
	private ExamRepository examRepository;
	
	public ExamService(ExamRepository examRepository)
	{
		this.examRepository = examRepository;
	}
	
	public void conductExam(Exam exam) throws RuntimeException
	{
		examRepository.save(exam);
	}
	public Collection<Exam> examByDate(String exam_date)
	{
		return examRepository.getByDate(exam_date);
	}
	
	public Collection<Exam> examByStandard(String standard)
	{
		return examRepository.getByStandard(standard);
	}
	
	public Collection<Exam> examByName(String exam_name)
	{
		return examRepository.getByName(exam_name);
	}
	
}