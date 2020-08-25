package com.SBcollege.in.collegemanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SBcollege.in.collegemanagementsystem.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
