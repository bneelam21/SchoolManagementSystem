package com.example.demo.repository;

import java.sql.Time;
import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.StudentAttendance;

@Repository
public interface StudentAttendanceRepository extends CrudRepository<StudentAttendance, String>{
	
	@Query("UPDATE student_attendance set logout_time=?1 where student_id=?2 and entry_date=?3")
	@Transactional
	@Modifying
	int updateLogout(Time logout_time, String student_id, LocalDate localDate);

}