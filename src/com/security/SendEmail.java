package com.security;

import java.net.PasswordAuthentication;
import java.util.Properties;
import java.net.Authenticator;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

public class SendEmail 
{
	public static void main(String[] args)
	{
		
		PasswordGeneration pg=new PasswordGeneration();
		String ReceiverAddress= "rushikeshsupekar7984@gmail.com";
		System.out.println("Add="+ReceiverAddress);
		final String username = "pratiksha.21820071@viit.ac.in";
		final String password = "abc12345";
		String bodyMessage="Hii...You created new Account in our Bank\n Your password is : "+pg.password();
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true"); 

		Session ss = Session.getInstance(prop,new javax.mail.Authenticator()
		{
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() 
			{
				return new javax.mail.PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(ss);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(ReceiverAddress));
			message.setSubject("New Account request approved");
			message.setText(bodyMessage);

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) 
		{
			System.out.println("Email\t"+e);
		}
	}
}
