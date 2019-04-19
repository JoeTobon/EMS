package com.collabera.jump.employee;

import java.io.Serializable;
import java.math.BigInteger;
import java.text.SimpleDateFormat;

import javax.persistence.CascadeType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@MappedSuperclass
public abstract class Person implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static enum GENDER
	{
		MALE, FEMALE, OTHER;
	}
	
	@Size(max=100, message="Name is too long!")
	private String name;
	
	private String birthDay;
	
	@Positive
	@Digits(integer=10, fraction=0, message="Phone number needs to be 10")
	private BigInteger phoneNum;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Address address;
	private GENDER gender;
	
	public String getBirthDay() {
		return this.birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public BigInteger getPhoneNum() 
	{
		return phoneNum;
	}

	public void setPhoneNum(BigInteger phoneNum) 
	{
		this.phoneNum = phoneNum;
	}

	public Address getAddress() 
	{
		return address;
	}

	public void setAddress(Address add) 
	{
		this.address = add;
	}

	public GENDER getGender() 
	{
		return gender;
	}

	public void setGender(GENDER gender) 
	{
		this.gender = gender;
	}
	
	public String toString()
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d,''yy");
		return  name + "\n\t[Date of Birth - " + dateFormat.format(birthDay) + ", Phone = " + phoneNum + ", Address = " + address
				+ ", Gender = " + gender + "]";
	}
}

