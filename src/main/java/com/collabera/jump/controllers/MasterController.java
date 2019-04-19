package com.collabera.jump.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.collabera.jump.employee.Employee;
import com.collabera.jump.employee.Employee.DEPARTMENT;
import com.collabera.jump.employee.Employee.JOB;
import com.collabera.jump.employee.Person.GENDER;
import com.collabera.jump.exceptions.EmployeeNotFoundException;
import com.collabera.jump.helpers.EmployeeHelper;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path="/master")
public class MasterController 
{
	@Autowired
	EmployeeHelper empHelp;	
	
	@ApiResponses({@ApiResponse(code = 404, message = "Employee or address not found!")})
	@ApiOperation(value="Returns the gender of the employee with the specified ID")
	@GetMapping(path="/gender/{id}", produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<GENDER> getGender(@PathVariable(name="id", required=true) int id)
	{
		Employee emp = empHelp.getEmpById(id);
		
		if(empHelp.getEmpById(id) == null)
		{
			throw new EmployeeNotFoundException("Employee with id of " + id + " does not exist!");
		}
	
		return ResponseEntity.ok(emp.getGender());
	}
	
	@ApiResponses({@ApiResponse(code = 404, message = "Employee or address not found!")})
	@ApiOperation(value="Returns the department of the employee with the specified ID")
	@GetMapping(path="/department/{id}", produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<DEPARTMENT> getDepartment(@PathVariable(name="id", required=true) int id)
	{
		Employee emp = empHelp.getEmpById(id);
		
		if(empHelp.getEmpById(id) == null)
		{
			throw new EmployeeNotFoundException("Employee with id of " + id + " does not exist!");
		}
		
		return ResponseEntity.ok(emp.getDepartment());
	}
	
	@ApiResponses({@ApiResponse(code = 404, message = "Employee or address not found!")})
	@ApiOperation(value="Returns the job title of the employee with the specified ID")
	@GetMapping(path="/job/{id}", produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<JOB> getJob(@PathVariable(name="id", required=true) int id)
	{
		Employee emp = empHelp.getEmpById(id);
		
		if(empHelp.getEmpById(id) == null)
		{
			throw new EmployeeNotFoundException("Employee with id of " + id + " does not exist!");
		}
		
		return ResponseEntity.ok(emp.getJob());
	}
}
