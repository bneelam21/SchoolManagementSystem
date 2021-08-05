package com.example.demo.controller;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Exam;
import com.example.demo.service.ExamService;

@RestController
@RequestMapping("exam/admin")
public class ExamController {
	private ExamService examService;
	
	public ExamController(ExamService examService)
	{
		this.examService = examService;
	}
	
	@PostMapping(path="exam/add", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> conductExam(@RequestBody Exam exam) 
	{
		try
		{
			//int i = 1/0;
			examService.conductExam(exam);
			return ResponseEntity.ok("Exam conducted");
		}
		catch(RuntimeException re)
		{
			System.out.print(re);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("by zero error occured");
		}
	}

	
	@GetMapping(path="exam/getbydate")
	public Collection<Exam> getByDate(@RequestParam String exam_date)
	{
		return examService.examByDate(exam_date);
	}
	
	@GetMapping(path="exam/getbystandard",consumes=MediaType.APPLICATION_JSON_VALUE)
	public Collection<Exam> getByStandard(@RequestParam String standard)
	{
		return examService.examByStandard(standard);
	}
	
	@GetMapping(path="exam/getbyexamname")
	public Collection<Exam> getByName(@RequestParam String exam_name)
	{
		return examService.examByName(exam_name);
	}

}