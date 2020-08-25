package com.SBcollege.in.collegemanagementsystem.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cascade;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Student {
	@Id
	//@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	@OneToOne(cascade = CascadeType.ALL)
	private Address stuAddress;
	@JsonFormat( pattern="dd-MM-yyyy")
	//@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date birthDate;
	private String gender;
	private String mbno;
	private String email;
	@ManyToOne(cascade = CascadeType.MERGE)
	
	private Department department;
	@ManyToOne(cascade = CascadeType.PERSIST)
	//@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	@JoinColumn(updatable = false,name = "clgId")
	private College college;
	private boolean isAccept;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
		
		System.out.println("student id="+id);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMbno() {
		return mbno;
	}
	public void setMbno(String mbno) {
		this.mbno = mbno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
		
	}
	public Address getStuAddress() {
		return stuAddress;
	}
	public void setStuAddress(Address stuAddress) {
		this.stuAddress = stuAddress;
	}
	public College getCollege() {
		return college;
	}
	public void setCollege(College college) {
		this.college = college;
	}
	public boolean isAccept() {
		return isAccept;
	}
	public void setAccept(boolean isAccept) {
		this.isAccept = isAccept;
	}
	
	

}
