package com.cg.onetomanyshowroom;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Client {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		
		//create a new department
		NewDepartment department = new NewDepartment();
		department.setId(10);
		department.setName("Finance");
		
		//create two instances of employees
		NewEmployee e1 = new NewEmployee();
		e1.setId(1001);
		e1.setName("Rajeev Sharma");
		e1.setSalary(5500);
		
		NewEmployee e2 = new NewEmployee();
		e2.setId(1002);
		e2.setName("Neeta Kumar");
		e2.setSalary(5000);
		
		//creating 2nd department
		NewDepartment department2 = new NewDepartment();
		department2.setId(20);
		department2.setName("Sales");
		
		//create two instances of employees
		NewEmployee e3 = new NewEmployee();
		e3.setId(1003);
		e3.setName("Priya Sharma");
		e3.setSalary(5200);
		
		NewEmployee e4 = new NewEmployee();
		e4.setId(1004);
		e4.setName("Raju Kumar");
		e4.setSalary(5500);
		
		//add both employees to department
		department.addEmployee(e1);
		department.addEmployee(e2);
		department2.addEmployee(e3);
		department2.addEmployee(e4);
		
		//save department and its employees using entity manager
		em.persist(department);
		em.persist(department2);
		
		System.out.println("Added department along with two employees to database.");
		
		em.getTransaction().commit();
		em.close();
		factory.close();
	}
}
