package com.model;

import java.util.Date;

public class Register 
{
	private String firstName;
	private String middleName;
	private String lastName;
	private String address;
	private int pin;
	private String city;
	private String state;
	private String email;
	private String gender;
	//private Date dob;
	private long contact;
	private String accType;
	
	public Register(String firstName, String middleName, String lastName, String address, int pin, String city,
			String state, String email, String gender, long contact, String accType) 
	{
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.address = address;
		this.pin = pin;
		this.city = city;
		this.state = state;
		this.email = email;
		this.gender = gender;
		//this.dob = dob;
		this.contact = contact;
		this.accType = accType;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	/*public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	*/
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}

}
