package com.security;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class EncryptionDecryption 
{
	private static final String UNICODE_FORMAT = "UTF-8";
	
	
	public static void main(String[] args)
	{
		PasswordGeneration p=new PasswordGeneration();
		String password = "Pratiksha";//p.password();
		//System.out.println(password);
		try
		{
			SecretKey key = generateKey("AES");
			Cipher chipher;
			chipher = Cipher.getInstance("AES");
			
			byte[] encryptedData = encrypt(password, key, chipher);
			String encryptedString = new String(encryptedData);
			System.out.println("Encrypted\t"+encryptedString);
			
			String decrypted = decrypt(encryptedData, key, chipher);
			System.out.println("Decrypted\t"+decrypted);
		}
		catch(Exception e)
		{
			System.out.println("In Encrypt Main\t"+e);
		}
	}
	
	public static SecretKey generateKey(String encryptionType)
	{
		try
		{
			KeyGenerator keyGenerator = KeyGenerator.getInstance(encryptionType);
			SecretKey myKey = keyGenerator.generateKey();
			return myKey;
 		}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
	}
	
	public static byte[] encrypt(String dataToEncrypt, SecretKey myKey, Cipher cipher)
	{
		try
		{
			byte[] password = dataToEncrypt.getBytes(UNICODE_FORMAT);
			cipher.init(Cipher.ENCRYPT_MODE, myKey);
			byte[] textEncrypted =  cipher.doFinal(password);
			return textEncrypted;
		}
		catch(Exception e)
		{
			System.out.println("In Encrypt\t"+e);
			return null;
		}
	}
	
	
	public static String decrypt(byte[] dataToDecrypt, SecretKey myKey, Cipher cipher)
	{
		try
		{
			cipher.init(Cipher.DECRYPT_MODE, myKey);
			byte[] textDecrypted = cipher.doFinal(dataToDecrypt);
			String result =  new String(textDecrypted);
			return result;
		}
		catch(Exception e)
		{
			System.out.println("In Decrypt\t"+e);
			return null;
		}
		
	}

}
