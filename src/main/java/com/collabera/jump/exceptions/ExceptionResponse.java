package com.collabera.jump.exceptions;

import java.util.Date;

public class ExceptionResponse
{
	private String message;
	
	private String details;
	
	private Date timeStamp;
	
	public ExceptionResponse()
	{
		this.timeStamp = new Date();
	}
	
	public ExceptionResponse(String message, String details)
	{
		this.timeStamp = new Date();
		this.message = message;
		this.details = details;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}
}
