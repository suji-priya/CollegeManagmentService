package com.SBcollege.in.collegemanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.SBcollege.in.collegemanagementsystem.entity.College;

@Repository
public interface CollegeRepository extends JpaRepository<College, Integer>{
	
   @Query ("select count(s.id) from Student s where s.college.clgId=:clgId")
	public int totalStudents(@Param("clgId")int clgId);

}
