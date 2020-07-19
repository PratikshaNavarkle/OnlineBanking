package com.security;

public class EncryptionDecryption
{
	public static void main(String[] args)
	{
		String encrypted=encrypt("Pratiksha");
		System.out.println("Encrypted\t"+encrypted);
		String decrypted=decrypt("Vxgzoqyng");
		System.out.println("Decrypted\t"+decrypted);
	}

	public static String encrypt(String data)
	{
		try
		{
		String text=data;
		int key=6;
		int len=text.length();
		char[] n=new char[len];

		for(int i=0;i<text.length();i++)
		{
			char x=text.charAt(i);
			//System.out.println("Character "+x+" at "+i);
			n[i]=(char) (x+key);
		}
		String value=String.valueOf(n);
		return value;
		}
		catch(Exception e)
		{
			System.out.println("In Encrypt method\t"+e);
			return null;
		}
	}

	public static String decrypt(String data)
	{
		try
		{
			String text=data;
			int key=6;
			int len=text.length();
			char[] n=new char[len];

			for(int i=0;i<text.length();i++)
			{
				char x=text.charAt(i);
				//System.out.println("Character "+x+" at "+i);
				n[i]=(char) (x-key);
			}
			String value=String.valueOf(n);
			return value;
		}
		catch(Exception e)
		{
			System.out.println("In decrypt method\t"+e);
			return null;
		}
	}
}	
