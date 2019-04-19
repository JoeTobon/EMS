package com.collabera.jump.helpers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collabera.jump.employee.Address;
import com.collabera.jump.repositories.AddressRepository;

@Service
public class AddressHelper 
{
	@Autowired
	private AddressRepository repository;
	
	public Address getById(int id)
	{
		return repository.findAddressById(id);
	}
}
