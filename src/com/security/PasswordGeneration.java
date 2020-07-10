package com.security;

import java.security.Security;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.Security;

public class PasswordGeneration 
{
	public String password()
	{
		//System.out.println("Ur new password is : ");
		String Capital_chars="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String Small_chars="abcdefghijklmnopqrstuvwxyz";
		String numbers="0123456789";
		String symbols="!@#$%^&*-/.";
		String values=Capital_chars+Small_chars+numbers+symbols;
		Random rndm_method=new Random();
		int len=6;
		char[] password=new char[len];
		for(int i=0;i<len;i++)
		{
			password[i]=values.charAt(rndm_method.nextInt(values.length()));

		}
		//System.out.println(password);
		String pass=String.valueOf(password);
		//System.out.println(pass);
		return pass;
	}
	
/*	public void encrypt()
	{
		byte[] input;
		byte[] keyBytes = "12345678".getBytes();
		byte[] ivBytes = "input123".getBytes();
		SecretKeySpec key = new SecretKeySpec(keyBytes, "DES");
		IvParameterSpec ivSpec = new IvParameterSpec(ivBytes);
		Cipher cipher;
		byte[] cipherText;
		int ctLength;
		
		try
		{
			Security.addProvider(new  org.bouncycastle.jce.provider.BouncyCastleProvider());
			input = "Pratiksha".getBytes();
			SecretKeySpec
		}
		catch(Exception e)
		{
			System.out.println("In encrypt\t"+e);
		}
	}
*/
	
	
}

