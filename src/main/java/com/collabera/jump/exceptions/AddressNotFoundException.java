package com.collabera.jump.exceptions;

public class AddressNotFoundException extends RuntimeException
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AddressNotFoundException() 
	{
		super("Address not found!");
	}
	
	public AddressNotFoundException(String message) 
	{
		super(message);
	}
}
