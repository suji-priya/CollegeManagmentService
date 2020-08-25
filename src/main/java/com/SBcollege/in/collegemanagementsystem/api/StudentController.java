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
import com.SBcollege.in.collegemanagementsystem.entity.Department;
import com.SBcollege.in.collegemanagementsystem.entity.Student;
import com.SBcollege.in.collegemanagementsystem.service.HomeService;

@RestController
@RequestMapping("/admin/students")
public class StudentController {
	@Autowired
	HomeService homeService;
	
	@PostMapping("/create")
	public ResponseEntity<String> createStudent(@Valid @RequestBody Student s, BindingResult result)
	{
		if(result.hasErrors())
		{
			
			return new ResponseEntity<String>("incorrect data "+result.getAllErrors(), HttpStatus.BAD_REQUEST);
		}
		
		 int i=101;  
			/*
			 * if(s.getCollege().getClgName().equals("cjc")) { s.getCollege().setClgId(i);
			 * 
			 * }
			 * 
			 * else if(!s.getCollege().getClgName().equals("cjc")) {
			 * s.getCollege().setClgId(i+1); }
			 */
		  
		  if(s.getDepartment().getDeptCode().equals("ME"))
		  {
			  s.getDepartment().setId(1);
		  }
		  else if(s.getDepartment().getDeptCode().equals("CO"))
		  {
			  s.getDepartment().setId(2);
		  }
		  else if(s.getDepartment().getDeptCode().equals("EE"))
		  {
			  s.getDepartment().setId(3);
		  }
		  else if(s.getDepartment().getDeptCode().equals("IT"))
		  {
			  s.getDepartment().setId(4);
		  }
		 
		String msg=homeService.createStudent(s);
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<Object> getAllStudents()
	{
		List<Student> slist=homeService.allStudents();
		return new ResponseEntity<Object>(slist, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Object> viewStudent(@PathVariable int id)
	{
		Student s=homeService.viewStudent(id);
		if(s!=null)
		{
			return new ResponseEntity<Object>(s, HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Student "+id +"  does not exist", HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateStudent(@Valid @RequestBody Student s,@PathVariable int id, BindingResult result)
	{
		if(result.hasErrors())
		{
			return new ResponseEntity<Object>("incorrect data"+result.getAllErrors(), HttpStatus.BAD_REQUEST);
		}
		String msg=homeService.updateStudent(s,id);
		return new ResponseEntity<Object>(msg, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable int id)
	{
		if(id==0)
		{
			return new ResponseEntity<String>("Student "+id +"does not exist", HttpStatus.NOT_FOUND);
			
		}
		String msg=homeService.deleteStudent(id);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	 
	
}
