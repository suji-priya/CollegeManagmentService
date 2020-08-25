package com.SBcollege.in.collegemanagementsystem.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SBcollege.in.collegemanagementsystem.entity.College;
import com.SBcollege.in.collegemanagementsystem.entity.Student;
import com.SBcollege.in.collegemanagementsystem.repository.CollegeRepository;
import com.SBcollege.in.collegemanagementsystem.service.CollegeService;

@RestController
@RequestMapping("/admin/college")
public class CollegeController {
	@Autowired
	CollegeService collegeService;
	@PostMapping("/create")
	public ResponseEntity<String> createCollege(@Valid @RequestBody College c, BindingResult result)
	{
		if(result.hasErrors())
		{
			
			return new ResponseEntity<String>("incorrect data "+result.getAllErrors(), HttpStatus.BAD_REQUEST);
		}
		
		String msg=collegeService.createCollegeData(c); 
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Object> viewCollege(@PathVariable int id)
	{
		College c=collegeService.viewCollegeData(id);
		if(c!=null)
		{
			int count=collegeService.totalStudents(id);
			System.out.println("**********   "+count);
			return new ResponseEntity<Object>(c, HttpStatus.OK);
		}
		return new ResponseEntity<Object>("College "+id +"  does not exist", HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Object> updateCollege(@Valid @RequestBody College c, BindingResult result)
	{
		if(result.hasErrors())
		{
			return new ResponseEntity<Object>("incorrect data"+result.getAllErrors(), HttpStatus.BAD_REQUEST);
		}
		String msg=collegeService.updateCollegeData(c);
		return new ResponseEntity<Object>(msg, HttpStatus.OK);
		
	}
	


}
