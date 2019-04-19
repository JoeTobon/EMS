package com.collabera.jump.employee;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public final class Address implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	
	private String street;
	private String city;
	private String state;
	private int zip;
	
	public Address()
	{
		
	}	

	public Address(String street,String city,String state, int zip)
	{
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	
	public int getId() 
	{
		return id;
	}
	
	public String getStreet()
	{
		return street;
	}
	
	public void setStreet(String street)
	{
		this.street = street;
	}
	
	public String getCity()
	{
		return city;
	}
	
	public void setCity(String city)
	{
		this.city = city;
	}
	
	public String getState()
	{
		return state;
	}
	
	public void setState(String state)
	{
		this.state = state;
	}
	public int getZipCode()
	{
		return zip;
	}
	
	public void setZipCode(int zipCode)
	{
		this.zip = zipCode;
	}

	public String toString()
	{
		return street + ", " + city + ", " + state + ", " + zip;
	}
}

