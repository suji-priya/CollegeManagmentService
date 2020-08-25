package com.SBcollege.in.collegemanagementsystem.service;

import java.util.List;

import com.SBcollege.in.collegemanagementsystem.entity.College;
import com.SBcollege.in.collegemanagementsystem.entity.Student;

public interface CollegeService {
	String createCollegeData(College c);
	College viewCollegeData(int id);
	String updateCollegeData( College c);
		//String deleteCollegeData(int id);
	int totalStudents(int clgId);

}
