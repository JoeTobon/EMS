package com.collabera.jump.helpers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.collabera.jump.employee.Address;
import com.collabera.jump.employee.Employee;
import com.collabera.jump.repositories.EmployeeRepository;

@Service
public class EmployeeHelper 
{
	@Autowired
	private EmployeeRepository repository;
	
	public Iterable<Employee> getAllEmployees()
	{
		return repository.findAll();
	}
	
	public Employee getEmpById(int id)
	{
		return repository.findByEmpID(id);
	}
	
	public Iterable<Employee> getEmpByName(String name)
	{	
		return repository.findByName(name);
	}

	public Iterable<Employee> getEmpByStreet(String street)
	{		
		return repository.findByStreet(street);
	}
	
	public boolean createEmployee(Employee emp)
	{
		if(emp != null)
		{
			repository.save(emp);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean updateEmployee(Employee emp)
	{
		repository.save(emp);
		return true;
	}
	
	public boolean deleteEmployeeById(int id)
	{
		if(repository.findById(id) != null)
		{
			repository.deleteById(id);
			return true;
		}
		else
		{
			return false;
		}
	}
}
