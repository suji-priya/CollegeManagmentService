package com.SBcollege.in.collegemanagementsystem.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SBcollege.in.collegemanagementsystem.entity.College;
import com.SBcollege.in.collegemanagementsystem.repository.CollegeRepository;
import com.SBcollege.in.collegemanagementsystem.repository.HomeRepository;
import com.SBcollege.in.collegemanagementsystem.service.CollegeService;

@Service
public class CollegeServiceImpl implements CollegeService{

	@Autowired
	CollegeRepository collegeRepository;
	@Autowired
	HomeRepository hr;
	@Override
	public String createCollegeData(College c) {
		collegeRepository.save(c);		
		return "College Data added successfully";
	}

	@Override
	public College viewCollegeData(int id) {
		Optional<College> clg=collegeRepository.findById(id);
		if(clg.isPresent())
		{
			return clg.get();
		}
		return null;
	}

	@Override
	public String updateCollegeData(College c) {
		
		Optional<College> clg=collegeRepository.findById(c.getClgId());
		if(clg.isPresent())
		{
			collegeRepository.save(c);
			return "updated successfully";
		}
		return "college "+c.getClgId()+" does not present";
		
		
	}

	@Override
	public int totalStudents(int clgId) {
		return collegeRepository.totalStudents(clgId);
		
	}

}
