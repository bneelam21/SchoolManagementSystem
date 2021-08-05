package com.example.demo.service;
import java.util.Collection;
import org.springframework.stereotype.Service;
import com.example.demo.model.Sports;
import com.example.demo.repository.SportsRepository;

@Service
public class Sportsservice 
{
	private SportsRepository sportsrepository;
	
	public Sportsservice(SportsRepository sportsrepository)
	{
		this.sportsrepository = sportsrepository;
	}
	
	//Service method to enroll the student into sports
	public void enrollStudent(Sports sports) 
	{
		sportsrepository.save(sports);
	}
	
	//Service method to retrieve the details of player by name
	public Collection<Sports> getbyname(String student_name) 
	{
		return sportsrepository.Getbyname(student_name);
	}
	
	//Service method to retrieve the details of player by game
	public Collection<Sports> getbyGame(String game) 
	{
		return sportsrepository.Getbygame(game);
	}
}
