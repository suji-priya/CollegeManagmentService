package com.SBcollege.in.collegemanagementsystem.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Immutable;

//@Immutable
@Entity
public class College {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int clgId;
	private String clgName;
	private String city;
	private String state;
	private int pincode;
	/*
	 * @OneToMany(cascade = CascadeType.MERGE, mappedBy = "college") private
	 * Set<Student> stu = new HashSet<>();
	 * 
	 * public Set<Student> getStu() { return stu; }
	 * 
	 * public void setStu(Set<Student> stu) { this.stu = stu; }
	 */

	
	public int getClgId() {
		return clgId;
	}

	public void setClgId(int clgId) {
		this.clgId = clgId;
		System.out.println("clg id="+clgId);
		
		}

	public String getClgName() {
		return clgName;
	}

	public void setClgName(String clgName) {
		this.clgName = clgName;
			 
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	

}
