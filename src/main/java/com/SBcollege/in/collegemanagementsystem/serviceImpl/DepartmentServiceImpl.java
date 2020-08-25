package com.SBcollege.in.collegemanagementsystem.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SBcollege.in.collegemanagementsystem.entity.College;
import com.SBcollege.in.collegemanagementsystem.entity.Department;
import com.SBcollege.in.collegemanagementsystem.repository.DepartmentRepository;
import com.SBcollege.in.collegemanagementsystem.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	DepartmentRepository departmentRepository;

	@Override
	public Department createDepartment(Department d) {
		System.out.println("hello department service");
		return departmentRepository.save(d);
	}

	@Override
	public Department viewDepartment(int id) {
		Optional<Department> dept=departmentRepository.findById(id);
		if(dept.isPresent())
		{
			return dept.get();
		}
	
		return null;
	}

	@Override
	public String updateDepartment(Department d) {
		Optional<Department> dept=departmentRepository.findById(d.getId());
		if(dept.isPresent())
		{
			 departmentRepository.save(d);
			 return "updated successfully";
		}
	
		return "departent "+d.getId()+" does not exist";
	}

	@Override
	public String deleteDepartment(int id) {
		Optional<Department> dept=departmentRepository.findById(id);
		if(dept.isPresent())
		{
			Department d=dept.get(); 
			departmentRepository.delete(d);
			 return "deleted successfully";
		}
	
		return "departent "+ id +" does not exist";
	}
	

}
