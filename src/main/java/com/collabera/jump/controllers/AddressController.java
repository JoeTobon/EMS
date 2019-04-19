package com.collabera.jump.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.collabera.jump.employee.Address;
import com.collabera.jump.employee.Employee;
import com.collabera.jump.exceptions.AddressNotFoundException;
import com.collabera.jump.exceptions.EmployeeNotFoundException;
import com.collabera.jump.helpers.AddressHelper;
import com.collabera.jump.helpers.EmployeeHelper;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path="/address")
public class AddressController 
{
	@Autowired
	EmployeeHelper empHelp;	
	
	@Autowired
	AddressHelper addHelp;	
	
	@ApiResponses({@ApiResponse(code = 404, message = "Employee or address not found!")})
	@ApiOperation(value="Returns address, from employee, with specified employee ID")
	@GetMapping(path="/employee/{id}", produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Address> getAddressByEmp(@PathVariable(name="id", required=true) int id)
	{
		Employee emp = empHelp.getEmpById(id);
		
		if(empHelp.getEmpById(id) == null)
		{
			throw new EmployeeNotFoundException("Employee with id of " + id + " does not exist!");
		}
		
		if(emp.getAddress() == null)
		{
			throw new AddressNotFoundException("Address does not exist for employee with id of: " + id);
		}
		else
		{
			return ResponseEntity.ok(emp.getAddress());
		}
	}
	
	@ApiResponses({@ApiResponse(code = 404, message = "Employee or address not found!")})
	@ApiOperation(value="Returns address with specified address ID")
	@GetMapping(path="/{id}", produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Address> getAddressById(@PathVariable(name="id", required=true) int id)
	{
		Address add = addHelp.getById(id);
		
		if(add == null)
		{
			throw new AddressNotFoundException("Address does not exist for employee with id of: " + id);
		}
		else
		{
			return ResponseEntity.ok(add);
		}
	}
	
	@ApiResponses({@ApiResponse(code = 404, message = "Employee not found!")})
	@ApiOperation(value="Creates address, for employee with specified employee ID, from request body")
	@PostMapping(path="/{id}", produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Boolean> createAddress(@PathVariable(name="id", required=true) int id, @RequestBody @Valid Address address)
	{
		Employee emp = empHelp.getEmpById(id);
		
		if(empHelp.getEmpById(id) == null)
		{
			throw new EmployeeNotFoundException("Employee with id of " + id + " does not exist!");
		}
		
		emp.setAddress(address);
		return ResponseEntity.ok(empHelp.createEmployee(emp));
	}
	
	@ApiResponses({@ApiResponse(code = 404, message = "Employee not found!")})
	@ApiOperation(value="Updates address, for employee with specified employee ID, from request body")
	@PutMapping(path="/{id}", produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Boolean> updateAddress(@PathVariable(name="id", required=true) int id, @RequestBody Address address)
	{
		Employee emp = empHelp.getEmpById(id);
		
		if(empHelp.getEmpById(id) == null)
		{
			throw new EmployeeNotFoundException("Employee with id of " + id + " does not exist!");
		}
		
		emp.setAddress(address);
		return ResponseEntity.ok(empHelp.updateEmployee(emp));
	}
}
