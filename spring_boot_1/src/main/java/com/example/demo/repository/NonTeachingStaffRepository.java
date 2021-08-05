package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.NonTeachingStaff;

@Repository
public interface NonTeachingStaffRepository extends CrudRepository<NonTeachingStaff, String> 
{
	
}