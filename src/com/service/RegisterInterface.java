package com.service;

import java.util.List;

import com.model.Regsiter;

public interface RegisterInterface 
{
	//insert
	public int addRegister(Regsiter r);
	
	//display
	public List<Regsiter> getAllRegister();
	
	//delete record
	public void deleteRegister(long accNo);
	
	//search
	public Regsiter searchRegister(long accNo);
	
	//update 
	public Regsiter updateRegsiter(Regsiter r); 
}
