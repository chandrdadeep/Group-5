package com.cg.onetomanyshowroom;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity //representing data that can be persisted to the database
@Table(name = "DEPT_MASTER")
public class NewDepartment {

	@Id
	private int model;
	private String name;

	@OneToMany(mappedBy="department",cascade=CascadeType.ALL)//mappedBy attribute is used in bidirectional association to link with other side of entity. 
	private Set<NewEmployee> employees = new HashSet<>();		//Initialization required to avoid NullPointerException

	public int getModel() {
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

	public Set<NewEmployee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<NewEmployee> employees) {
		this.employees = employees;
	}
	
	//the method below will add employee to department 
	//also serves the purpose to avoid cyclic references. 
	public void addEmployee(NewEmployee employee) {
		employee.setDepartment(this);			//this will avoid nested cascade
		this.getEmployees().add(employee);
	}

}
