package com.service;

import java.util.List;

import com.model.PersonalDetails;
import com.model.Regsiter;

public interface PersonalDetailsInterface 
{
	//insert
	public int addPersonal(PersonalDetails p);

	//display
	public List<PersonalDetails> getAllPersonalDetails();

	//delete record
	public int deletePersonal(long accNo);

	//search
	public PersonalDetails searchPersonal(long accNo);

	//update 
	public PersonalDetails updatePersonal(PersonalDetails p); 
}
