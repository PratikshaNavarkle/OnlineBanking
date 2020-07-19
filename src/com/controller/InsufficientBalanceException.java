package com.controller;

public class InsufficientBalanceException extends Exception 
{
	public String toString()
	{
		return "Account balance is less than withdraw amount";
	}
}
