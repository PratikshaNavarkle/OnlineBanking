package com.service;

import java.util.List;

import com.model.AddressDetails;
import com.model.PersonalDetails;
import com.model.Regsiter;

public interface AddressDetailsInterface 
{
	//insert
	public int addAddress(AddressDetails a);

	//display
	public List<AddressDetails> getAllAddressDetails();

	//delete record
	public int deleteAddress(long accNo);

	//search
	public AddressDetails searchAddress(long accNo);

	//update 
	public AddressDetails updateAddress(AddressDetails a); 

}
