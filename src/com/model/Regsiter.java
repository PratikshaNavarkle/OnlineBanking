package com.model;

public class Regsiter 
{
	private PersonalDetails p;
	private AddressDetails a;
	private AccountDetails acc;
	private DocumentDetails d;
	
	public Regsiter(PersonalDetails p, AddressDetails a, AccountDetails acc, DocumentDetails d) {
		super();
		this.p = p;
		this.a = a;
		this.acc = acc;
		this.d = d;
	}

	public PersonalDetails getP() {
		return p;
	}

	public void setP(PersonalDetails p) {
		this.p = p;
	}

	public AddressDetails getA() {
		return a;
	}

	public void setA(AddressDetails a) {
		this.a = a;
	}

	public AccountDetails getAcc() {
		return acc;
	}

	public void setAcc(AccountDetails acc) {
		this.acc = acc;
	}

	public DocumentDetails getD() {
		return d;
	}

	public void setD(DocumentDetails d) {
		this.d = d;
	}
	
}
