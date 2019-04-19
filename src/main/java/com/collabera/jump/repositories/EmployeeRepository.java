package com.collabera.jump.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import com.collabera.jump.employee.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>, QueryByExampleExecutor<Employee>
{
	public Employee findByEmpID(int id);
	
	@Query("SELECT e FROM Employee e WHERE e.address.street = :street")
	public Iterable<Employee> findByStreet(String street);
	
	public Iterable<Employee> findByName(String name);
}
