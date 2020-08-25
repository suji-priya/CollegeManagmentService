package com.SBcollege.in.collegemanagementsystem.service;

import java.util.List;

import com.SBcollege.in.collegemanagementsystem.entity.Department;
import com.SBcollege.in.collegemanagementsystem.entity.Student;

public interface HomeService {
	
	//String createDepartment(List<Department> d);
	String createStudent(Student s);
	Student viewStudent(int id);
	List<Student> allStudents();
	String updateStudent( Student s, int id);
	String deleteStudent(int id);
	

}
