package com.mypro.demorest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {

	MyDBUtils dbUtils = new MyDBUtils();

	List<Employee> employees;

	public EmployeeRepository() {
		super();
//		employees=new ArrayList<Employee>();
//		
//		Employee employee=new Employee();
//		employee.setEmployeeId(1);
//		employee.setEmployeeName("anumalla Gavaskar");
//		employee.setAge(23);
//		Employee employee1=new Employee();
//		employee1.setEmployeeId(2);
//		employee1.setEmployeeName("Shekar kalumala");
//		employee1.setAge(26);
//		
//		employees.add(employee);
//		employees.add(employee1);
//	
	}

	public List<Employee> getEmployees() {

		List<Employee> employees = new ArrayList<Employee>();
		Connection connection = dbUtils.getConnection();
		String sql = "SELECT * FROM EMPLOYEE";
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Employee emp = new Employee();
				emp.setEmployeeId(rs.getInt(1));
				emp.setEmployeeName(rs.getString(2));
				emp.setAge(rs.getInt(3));
				employees.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return employees;
	}

	public Employee getEmployeeByID(int id) {

//		for (Employee employee : employees) {
//			if (employee.getEmployeeId()==id) {
//				return employee;
//			}
//		}
//		return null;
		Employee emp=new Employee();
		Connection connection = dbUtils.getConnection();
		String sql = "SELECT * FROM EMPLOYEE WHERE EMPLOYEE_ID="+id;
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			if(rs.next()) {
		
				emp.setEmployeeId(rs.getInt(1));
				emp.setEmployeeName(rs.getString(2));
				emp.setAge(rs.getInt(3));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return emp;
//		return employees.stream().filter(employee -> employee.getEmployeeId() == id).findFirst().orElse(null);

		
		
	}

	public Employee createEmployee(Employee employee) {
		// TODO Auto-generated method stub

		Connection connection = dbUtils.getConnection();
		String sql = "INSERT INTO  EMPLOYEE VALUES(?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, employee.getEmployeeId());
			stmt.setString(2, employee.getEmployeeName());
			stmt.setInt(3, employee.getAge());
			
			int re= stmt.executeUpdate();

			if(re>0) {
				System.out.println("Record inserted succesfully");
			}else {
				System.out.println("Record not inserted ");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return employee;

	}

	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Connection connection = dbUtils.getConnection();
		String sql = "UPDATE  EMPLOYEE  SET EMPLOYEE_NAME=?,AGE=? WHERE EMPLOYEE_ID=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, employee.getEmployeeName());
			stmt.setInt(2, employee.getAge());
			stmt.setInt(3, employee.getEmployeeId());
			
			int re= stmt.executeUpdate();

			if(re>0) {
				System.out.println("Record Updated succesfully");
			}else {
				System.out.println("Record not  updated ");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return employee;
	}

}
