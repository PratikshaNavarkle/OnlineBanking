package com.model;

public class AddressDetails 
{
	private long accNo;
	private String address;
	private String locality;
	private String landmark;
	private String city;
	private String state;
	private int pinCode;
	
	public AddressDetails(long accNo, String address, String locality, String landmark, String city, String state,
			int pinCode) {
		super();
		this.accNo = accNo;
		this.address = address;
		this.locality = locality;
		this.landmark = landmark;
		this.city = city;
		this.state = state;
		this.pinCode = pinCode;
	}

	public long getAccNo() {
		return accNo;
	}

	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
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

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	@Override
	public String toString() {
		return "AddressDetails [accNo=" + accNo + ", address=" + address + ", locality=" + locality + ", landmark="
				+ landmark + ", city=" + city + ", state=" + state + ", pinCode=" + pinCode + "]";
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
	
}
