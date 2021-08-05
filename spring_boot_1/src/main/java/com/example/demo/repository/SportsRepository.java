package com.example.demo.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Sports;
import com.example.demo.model.Teacher;
import com.example.demo.model.TeacherAttendence;

@Repository
public interface SportsRepository extends CrudRepository<Sports, String> 
{
	@Query("SELECT e from sports e where student_name=?1")
	Collection<Sports> Getbyname(String student_name);
	
	@Query("SELECT e from sports e where game=?1")
	Collection<Sports> Getbygame(String game);
}
