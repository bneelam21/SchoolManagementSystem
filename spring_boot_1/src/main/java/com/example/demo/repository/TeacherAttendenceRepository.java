package com.example.demo.repository;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.TeacherAttendence;

@Repository
public interface TeacherAttendenceRepository  extends CrudRepository<TeacherAttendence, String> 
{
	@Query("update employee_attendence set logouttime=?1 where employee_id=?2 and entry_date=?3")
	@Transactional
	@Modifying
	int upadateLogoutTime(Time logoutTime,String employee_id,LocalDate entry_date);
	
	@Query("SELECT e from employee_attendence e where entry_date=?1")
	Collection<TeacherAttendence> Getbydate(String date);
}
