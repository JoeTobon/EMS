package com.collabera.jump.employee;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Positive;

@Entity
public class Employee extends Person implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public enum DEPARTMENT
	{
		HR, ACCOUNTING, SALES, NONE;
	}
	
	public enum JOB
	{
		HRRep, ACCOUNTANT, SALEREP, PROGRAMMER, NONE;
	}
		
	@Id
	private int empID;
	private float salary;
	private String email;

	@OneToOne(cascade=CascadeType.ALL)
	private Address workAddress;
	
	@Positive
	@Digits(integer=9, fraction=0, message="Has to be 9 digits")
	private BigInteger ssn;
	private boolean isManager;
	private JOB jobTitle;
	private DEPARTMENT department;	
	
	public Address getWorkAddress() {
		return workAddress;
	}

	public void setWorkAddress(Address workAddress) {
		this.workAddress = workAddress;
	}

	public JOB getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(JOB jobTitle) {
		this.jobTitle = jobTitle;
	}

	public int getEmpID() 
	{
		return empID;
	}
	
	public void setEmpID(int id) 
	{
		this.empID = id;
	}

	public float getSalary() 
	{
		return salary;
	}
	
	public void setSalary(float salary) 
	{
		this.salary = salary;
	}

	public String getEmail() 
	{
		return email;
	}
	
	public void setEmail(String email) 
	{
		this.email = email;
	}

	public BigInteger getSsn() 
	{
		return ssn;
	}
	
	public void setSsn(BigInteger ssn) 
	{
		this.ssn = ssn;
	}

	public boolean isManager() 
	{
		return isManager;
	}

	public void setManager(boolean isManager)
	{
		this.isManager = isManager;
	}
	
	public JOB getJob() 
	{
		return this.jobTitle;
	}
	
	public void setJob(JOB jobTitle) 
	{
		this.jobTitle = jobTitle;
	}
	
	public DEPARTMENT getDepartment() 
	{
		return this.department;
	}
	
	public void setDepartment(DEPARTMENT department) 
	{
		this.department = department;
	}
	
	public String toString()
    {
        return "========================================================================================\n"
                + "\t\t\t\t\t" + this.getName() + "\n"
                + "========================================================================================\n"
           + "| ID:         |" + this.getEmpID() + "        || Address:|" + this.getAddress() + "    ||                |"
           + "\n| DOB:        |" + this.getBirthDay() + "    || Phone:  |" + this.getPhoneNum() + "    ||                |"
           + "\n| Email:      |" + this.getEmail() + "        || Gender: |" + this.getGender() + "    ||                |"
           + "\n| Manager:    |no one        || Title:  |" + this.getJob() + "           || Salary: " + this.getSalary() + "            |"
           + "\n=========================================================================================\n";
    }

//	public int compareTo(Object o) 
//	{
//		if(o instanceof Employee)
//		{
//			return this.getName().compareTo(((Employee) o).getName());
//		}
//		else
//		{
//			//throw exception
//			return 2;
//		}
//	}
	
	
//	public boolean equals(Object o)
//	{
//		if(o instanceof Employee)
//		{
//			Employee emp = (Employee) o;
//			
//			if(this.getSsn() == emp.getSsn())
//			{
//				return true;
//			}
//			else
//			{
//				return false;
//			}
//		}
//		else
//		{
//			return false;
//		}
//	}
}