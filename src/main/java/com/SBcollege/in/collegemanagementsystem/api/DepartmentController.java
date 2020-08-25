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
import com.SBcollege.in.collegemanagementsystem.service.DepartmentService;

@RestController
@RequestMapping("/admin/department")
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentService;
	
	@PostMapping("/create")
	public ResponseEntity<Object> createDepartment(@Valid @RequestBody Department d ,BindingResult result)
	{
		System.out.println("hello department controller");
		if(result.hasErrors())
		{
			
			return new ResponseEntity<Object>("incorrect data "+ result.getAllErrors(), HttpStatus.BAD_REQUEST);
		}
		
		Department dept=departmentService.createDepartment(d);
		return new ResponseEntity<Object>(dept, HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Object> viewDepartment(@PathVariable int id)
	{
		Department d=departmentService.viewDepartment(id);
		if(d!=null)
		{
			return new ResponseEntity<Object>(d, HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Department "+id +"  does not exist", HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Object> updateDepartment(@Valid @RequestBody Department d)
	{
		if(d==null)
		{
			return new ResponseEntity<Object>("incorrect data", HttpStatus.BAD_REQUEST);
		}
		String msg=departmentService.updateDepartment(d);
		return new ResponseEntity<Object>(msg, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteDepartment(@PathVariable int id)
	{
		if(id==0)
		{
			return new ResponseEntity<String>("Department "+id +"does not exist", HttpStatus.NOT_FOUND);
			
		}
		String msg=departmentService.deleteDepartment(id);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	

}
