package com.controller;

public class NegativeAmountException extends Exception 
{
	public String toString()
	{
		return "Amount is less than zero";
	}
}
