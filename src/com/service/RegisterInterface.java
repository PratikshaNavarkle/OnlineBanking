package com.service;

import java.util.List;

import com.model.Regsiter;

public interface RegisterInterface 
{
	//insert
	public long addRegister(Regsiter r);
	
	//display
	public List<Regsiter> getAllRegister();
	
	//delete record
	public int deleteRegister(long accNo);
	
	//search
	public int searchRegister(long accNo);
	
	//update 
	public Regsiter updateRegsiter(Regsiter r); 
}
