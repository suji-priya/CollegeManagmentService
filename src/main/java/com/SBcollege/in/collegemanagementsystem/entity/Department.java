package com.SBcollege.in.collegemanagementsystem.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Department {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String deptCode;
	private String deptName;
	/*
	 * @OneToMany(cascade = CascadeType.MERGE,mappedBy = "department") private
	 * Set<Student> student=new HashSet<>(); public Set<Student> getStudent() {
	 * return student; } public void setStudent(Set<Student> student) { this.student
	 * = student; }
	 */
	
	public String getDeptCode() {
		
		return deptCode;
	}

	/*
	 * public Department(int id, String deptCode, String deptName) { super();
	 * this.id = id; this.deptCode = deptCode; this.deptName = deptName; }
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
		/*
		 * if(deptCode.equals("ME")) { setId(1); } else if(deptCode.equals("CO")) {
		 * setId(2); } else if(deptCode.equals("EE")) { setId(3); } else
		 * if(deptCode.equals("IT")) { setId(4); } else { setId(0); }
		 */
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	
	
	

}
