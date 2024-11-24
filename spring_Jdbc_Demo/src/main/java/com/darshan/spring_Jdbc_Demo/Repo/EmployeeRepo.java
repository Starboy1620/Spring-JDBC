package com.darshan.spring_Jdbc_Demo.Repo;

import java.util.List;

import com.darshan.spring_Jdbc_Demo.model.Employee;

public interface EmployeeRepo {

	public List<Employee> findAll();
	
	public int save(Employee employee);
	
}
