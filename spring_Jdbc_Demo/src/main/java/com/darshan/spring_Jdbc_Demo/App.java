package com.darshan.spring_Jdbc_Demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.darshan.spring_Jdbc_Demo.Repo.EmployeeImplRepo;
import com.darshan.spring_Jdbc_Demo.Repo.EmployeeRepo;
import com.darshan.spring_Jdbc_Demo.model.Employee;

import config.AppConfig;

public class App {
	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		Employee empl = context.getBean(Employee.class);

		List<Employee> employeeList = new ArrayList<>();

		employeeList.add(new Employee(5, "Suraj Shelke", 40000.23, "Production Support"));
		employeeList.add(new Employee(6, "UdayJadhav", 35000.00, "Production Support"));
		employeeList.add(new Employee(7, "Rutuja Dekhmukh", 38000.456, "Java Developer"));
		employeeList.add(new Employee(8, "Vishwas Patel", 67000, "Java Developer"));
		employeeList.add(new Employee(9, "Makrand Kramit", 300000, "Delivery Manager"));
		employeeList.add(new Employee(10, "Niliket Deshmukh", 56000.342, "Production Support"));

		EmployeeRepo repo = context.getBean(EmployeeImplRepo.class);
		
		int rows=0;
		for(Employee el : employeeList) {
		  rows = repo.save(el);	
		}		

		System.out.println(rows + "   Inserted in Database.... ");

		employeeList =  repo.findAll();
			
		
		employeeList.forEach(employees->System.out.println(employees));
		
		
	}

}
