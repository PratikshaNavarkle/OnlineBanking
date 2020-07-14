package com.controller;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AccountDetailsDao;
import com.security.PasswordGeneration;

/**
 * Servlet implementation class EmailApproveServlet
 */
@WebServlet("/EmailApproveServlet")
public class EmailRejectServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmailRejectServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String email=(String) request.getAttribute("emailID");
		//System.out.println("in email servelt");
		//String email=(String) request.getAttribute("email");
		//System.out.println("1");
		String pass=(String) request.getAttribute("password");
		//System.out.println("2");
		PasswordGeneration pg=new PasswordGeneration();
		String ReceiverAddress=email;    //"rushikeshsupekar7984@gmail.com";
		//System.out.println("3");
		System.out.println("Add="+ReceiverAddress);
		final String username = "pratiksha.21820071@viit.ac.in";
		final String password = "abc12345";
		//System.out.println("3");
		String bodyMessage="Hii...Your account has been rejected for not providing valid information. Please fill in with proper details";
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true"); 
		prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		//System.out.println("4");
		Session ss = Session.getInstance(prop,new javax.mail.Authenticator()
		{
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() 
			{
				return new javax.mail.PasswordAuthentication(username, password);

			}
		});

		try {
			//System.out.println("5");
			Message message = new MimeMessage(ss);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(ReceiverAddress));
			message.setSubject("New Account request rejected");
			message.setText(bodyMessage);
			//System.out.println("6");
			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) 
		{
			System.out.println("Email\t"+e);
		}
		response.sendRedirect("AdminHome.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
