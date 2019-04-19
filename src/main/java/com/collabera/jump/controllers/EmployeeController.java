package com.collabera.jump.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.collabera.jump.employee.Employee;
import com.collabera.jump.exceptions.EmployeeNotFoundException;
import com.collabera.jump.helpers.EmployeeHelper;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path="/employee")
public class EmployeeController 
{	
	@Autowired
	EmployeeHelper empHelp;
	
	@ApiResponses({@ApiResponse(code = 404, message = "Employee not found!")})
	@ApiOperation(value="Returns employee with specified ID")
	@CrossOrigin(origins="*")
	@GetMapping(path="/{id}", produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Employee> getEmployee(@PathVariable(name="id", required=true) int id)
	{
		if(empHelp.getEmpById(id) == null)
		{
			throw new EmployeeNotFoundException("Employee with id of " + id + " does not exist!");
		}
		else
		{
			return ResponseEntity.ok(empHelp.getEmpById(id));
		}
	}
	
	@ApiOperation(value="Returns all employees")
	@CrossOrigin(origins="*")
	@GetMapping(produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Iterable<Employee>> getAllEmployees()
	{
		return ResponseEntity.ok(empHelp.getAllEmployees());
	}
	
	@ApiOperation(value="Returns all employees with the specified name")
	@CrossOrigin(origins="*")
	@GetMapping(path = "/name/{name}" , produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Iterable<Employee>> getEmployeesByName(@PathVariable(name="name", required=true) String name)
	{
		return ResponseEntity.ok(empHelp.getEmpByName(name));
	}
	
	@ApiOperation(value="Returns all employees with the specified street")
	@CrossOrigin(origins="*")
	@GetMapping(path = "/street/{street}", produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Iterable<Employee>> getEmployeesByStreet(@PathVariable(name="street", required=true) String street)
	{
		return ResponseEntity.ok(empHelp.getEmpByStreet(street));
	}
	
	@ApiOperation(value="Creates employee from the request body")
	@CrossOrigin(origins="*")
	@PostMapping(produces={MediaType.APPLICATION_JSON_VALUE}, consumes={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Boolean> createEmployee(@RequestBody @Valid Employee employee)
	{
		return ResponseEntity.ok(empHelp.createEmployee(employee));
	}
	
	@ApiResponses({@ApiResponse(code = 404, message = "Employee not found!")})
	@ApiOperation(value="Updates employee, with specified ID, from the request body")
	@CrossOrigin(origins="*")
	@PutMapping(path="/{id}", produces={MediaType.APPLICATION_JSON_VALUE}, consumes={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Boolean> updateEmployee(@PathVariable(name="id", required=true) int id, @RequestBody Employee employee)
	{
		if(empHelp.getEmpById(employee.getEmpID()) == null)
		{
			throw new EmployeeNotFoundException("Employee does not exist!");
		}
		else
		{
			return ResponseEntity.ok(empHelp.updateEmployee(employee));
		}
	}
	
	@ApiResponses({@ApiResponse(code = 404, message = "Employee not found!")})
	@ApiOperation(value="Deletes employee with specified ID")
	@CrossOrigin(origins="*")
	@DeleteMapping(path="/{id}", produces={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Boolean> deleteEmployeeById(@PathVariable(name="id", required=true)int id)
	{
		if(empHelp.getEmpById(id) == null)
		{
			throw new EmployeeNotFoundException("Employee with id of " + id + " does not exist!");
		}
		else
		{
			return ResponseEntity.ok(empHelp.deleteEmployeeById(id));
		}
	}
	
}
