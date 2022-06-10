package com.cg.jpastart.One2Many;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity //representing data that can be persisted to the database
@Table(name = "DEPT_MASTER")
public class Department {

	@Id
	private int id;
	private String name;

	@OneToMany(mappedBy="department",cascade=CascadeType.ALL)//mappedBy attribute is used in bidirectional association to link with other side of entity. 
	private Set<Employee> employees = new HashSet<>();		//Initialization required to avoid NullPointerException

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	
	//the method below will add employee to department 
	//also serves the purpose to avoid cyclic references. 
	public void addEmployee(Employee employee) {
		employee.setDepartment(this);			//this will avoid nested cascade
		this.getEmployees().add(employee);
	}

}
