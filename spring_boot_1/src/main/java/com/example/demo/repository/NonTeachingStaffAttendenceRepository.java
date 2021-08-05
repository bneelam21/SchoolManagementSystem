package com.example.demo.repository;

import java.sql.Time;
import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.NonTeachingStaffAttendence;



@Repository
public interface NonTeachingStaffAttendenceRepository extends CrudRepository<NonTeachingStaffAttendence, String> {

		@Query("update staff_attendence set logout_time=?1 where employee_id=?2 and entry_date=?3")
		@Transactional
		@Modifying
		int updateLogoutTime(Time logout_ime,String employee_id,LocalDate entry_date);
	
}