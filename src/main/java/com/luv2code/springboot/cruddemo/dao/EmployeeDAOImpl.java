package com.luv2code.springboot.cruddemo.dao;

//Basic imports
import java.util.List;

// Project specific dependency imports
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Employee;

import jakarta.persistence.*;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

	// Define a field for entity manager 
	private EntityManager entityManager;
	
	// Constructor injection 
	@Autowired
	public EmployeeDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<Employee> findAll() {
		System.out.println("Inside employeeDAO implementation: ");
		// Create query 
		TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);
		
		// Execute query and get the list of Employee
		List<Employee> employees= theQuery.getResultList();
		
		return employees;
	}

}
