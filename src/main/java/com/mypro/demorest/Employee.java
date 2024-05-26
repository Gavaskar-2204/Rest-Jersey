package com.mypro.demorest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee {

	
	private int employeeId ;
	private String employeeName;
	private int age;
	public int getEmployeeId() {
		return employeeId;
	}
	
	public Employee() {
		super();
		
	}

	public Employee(int employeeId, String employeeName, int age) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.age = age;
	}


	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", age=" + age + "]";
	}
	
}
