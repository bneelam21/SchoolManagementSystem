package com.example.demo.controller;
import java.util.Collection;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Sports;
import com.example.demo.model.Student;
import com.example.demo.model.TeacherAttendence;
import com.example.demo.service.Sportsservice;

@RestController
@RequestMapping("school/sports")
public class Sportscontroller 
{
	private Sportsservice sportsservice;
	
	public Sportscontroller(Sportsservice sportsservice)
	{
		this.sportsservice = sportsservice;				
	}
	
	//Controller method to enroll the entry of the student in sports
	@PostMapping(path="student/enroll", consumes=MediaType.APPLICATION_JSON_VALUE)
	public String EnrollStudent(@RequestBody Sports sports)
	{
		sportsservice.enrollStudent(sports);
		return "Insertion Successful";
	}
	
	//Controller method to retrieve the details by Name
	@GetMapping(path = "selectby/name")
	public Collection<Sports> RetrieveByDate(@RequestParam String student_name)
	{
		return sportsservice.getbyname(student_name);
	}
	
	//Controller method to retrieve the details by Game
	@GetMapping(path = "selectby/game")
	public Collection<Sports> RetrieveByGame(@RequestParam String game)
	{
		return sportsservice.getbyGame(game);
	}
	
	
}
