package com.controller;

public class LowBalanceException extends Exception 
{
	public String toString()
	{
		return "Balance is less than 500";
	}
}
