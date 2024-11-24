package com.darshan.spring_Jdbc_Demo.Repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.darshan.spring_Jdbc_Demo.model.Employee;

public class EmployeeImplRepo implements EmployeeRepo {

	private JdbcTemplate template;

	public JdbcTemplate getTemplate() {
		return template;
	}

	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public List<Employee> findAll() {

		String sql = "select * from employee";

//		RowMapper<Employee> mapper = new RowMapper() {
//
//			Employee emp = new Employee();
//			@Override
//			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
//
//				emp.setEmployeeId(rs.getInt("eid"));
//				emp.setEmployeeName(rs.getString("ename"));
//				emp.setEmployeeSalary(rs.getDouble("esalary"));
//				emp.setEmployeeDesignation(rs.getString("edesignation"));
//
//				return emp;
//			}
//
//		};
		

		RowMapper<Employee> mapper = (rs,rowNum) -> {
				Employee emp = new Employee();
				emp.setEmployeeId(rs.getInt("eid"));
				emp.setEmployeeName(rs.getString("ename"));
				emp.setEmployeeSalary(rs.getDouble("esalary"));
				emp.setEmployeeDesignation(rs.getString("edesignation"));

				return emp;  

		};   // Lambda Expression of RowMapper 
		
		

	return template.query(sql,mapper);

	}

	@Override
	public int save(Employee employee) {

		String sql = "insert into employee(eid,ename,esalary,edesignation) values(?,?,?,?)";

		return template.update(sql, employee.getEmployeeId(), employee.getEmployeeName(), employee.getEmployeeSalary(),
				employee.getEmployeeDesignation());
	}

}
