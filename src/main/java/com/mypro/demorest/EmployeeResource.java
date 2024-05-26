package com.mypro.demorest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/employee")
public class EmployeeResource {

	EmployeeRepository repository = new EmployeeRepository();

	@GET
//	@Produces(MediaType.APPLICATION_XML)
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/one")
	public Employee getEmployee() {
		System.out.println(">> getEmployee called ");
		Employee employee = new Employee();
		employee.setEmployeeId(1);
		employee.setEmployeeName("anumalla Gavaskar");
		employee.setAge(23);
		return employee;

	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
//	@Produces(MediaType.APPLICATION_XML)
	@Path("/all")
	public List<Employee> getAllEmployees() {
		System.out.println(">> getAllEmployees called ");
		return repository.getEmployees();

	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
//	@Produces(MediaType.APPLICATION_XML)
	@Path("/{id}")
	public Employee getEmployeeByID(@PathParam("id") int id) {
		System.out.println(">> getEmployeeByID called " + id);
		return repository.getEmployeeByID(id);

	}

	@POST
	@Path("/createEmp")
	@Consumes(MediaType.APPLICATION_XML)
//	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Employee creatEmployee(Employee employee) {

		System.out.println(">> employee  " + employee);
		repository.createEmployee(employee);

		return employee;
	}

	@PUT
	@Path("/updateEmp")
	@Consumes(MediaType.APPLICATION_XML)
	public Employee updatEmployee(Employee employee) {
		Employee emp = new Employee();
		if (repository.getEmployeeByID(employee.getEmployeeId()) == null) {
			emp = repository.createEmployee(employee);
		} else {

			emp = repository.updateEmployee(employee);
		}

		return emp;

	}

}
