package com.SBcollege.in.collegemanagementsystem.service;

import java.util.List;

import com.SBcollege.in.collegemanagementsystem.entity.College;
import com.SBcollege.in.collegemanagementsystem.entity.Department;

public interface DepartmentService {
	Department createDepartment(Department d);
	Department viewDepartment(int id);
	String updateDepartment( Department d);
	String deleteDepartment(int id);
}
