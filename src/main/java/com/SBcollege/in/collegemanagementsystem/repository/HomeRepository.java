package com.SBcollege.in.collegemanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.SBcollege.in.collegemanagementsystem.entity.College;
import com.SBcollege.in.collegemanagementsystem.entity.Student;

@Repository
public interface HomeRepository extends JpaRepository<Student, Integer>{
	
	/*
	 * @Query ("select s.id, count(s) from Student s group by s.college.clgId=?1")
	 * public long totalStudents( int id);
	 */

	
}
