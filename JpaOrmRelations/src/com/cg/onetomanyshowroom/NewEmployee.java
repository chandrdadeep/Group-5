package com.cg.onetomanyshowroom;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity//representing data that can be persisted to the database
@Table(name="EMP_MASTER")
public class NewEmployee implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	private int model;
	
	private String name;
	private double salary;
	
	@ManyToOne
	@JoinColumn(name="dept_no")
	private NewDepartment department;

	public int getId() {  //return the list
		return model;
	}

	public void setId(int model) {
		this.model = model;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public NewDepartment getDepartment() {
		return department;
	}

	public void setDepartment(NewDepartment department) {
		this.department = department;
	}
	
	
	
	
	
	
}
