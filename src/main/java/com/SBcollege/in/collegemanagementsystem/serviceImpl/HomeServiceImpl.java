package com.SBcollege.in.collegemanagementsystem.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SBcollege.in.collegemanagementsystem.entity.College;
import com.SBcollege.in.collegemanagementsystem.entity.Department;
import com.SBcollege.in.collegemanagementsystem.entity.Student;
import com.SBcollege.in.collegemanagementsystem.repository.CollegeRepository;
import com.SBcollege.in.collegemanagementsystem.repository.HomeRepository;
import com.SBcollege.in.collegemanagementsystem.service.HomeService;

@Service
public class HomeServiceImpl implements HomeService {

	@Autowired
	HomeRepository homeRepository;
	@Autowired
	CollegeRepository collegeRepository;

	// @Transactional
	@Override
	public String createStudent(Student s) {

		
		homeRepository.save(s);
		return "Student " + s.getId() + " registered successfully";
	}

	@Override
	public Student viewStudent(int id) {
		Optional<Student> stu = homeRepository.findById(id);
		if (stu.isPresent()) {
			return stu.get();
		}
		return null;
	}

	@Override
	public List<Student> allStudents() {

		return homeRepository.findAll();
	}

	@Override
	public String updateStudent(Student s, int id) {
		Optional<Student> stu = homeRepository.findById(id);
		if (stu.isPresent()) {

			homeRepository.save(s);
			return "Student " + s.getId() + " updated successfully";
		}
		return "Student " + id + " does not exist";
	}

	@Override
	public String deleteStudent(int id) {
		Optional<Student> stu = homeRepository.findById(id);
		if (stu.isPresent()) {
			homeRepository.deleteById(id);
			return "Student " + id + " deleted successfully";
		}
		return "Student " + id + " does not exist";
	}

}
