package com.controller;

import java.io.IOException;
import java.util.Properties;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
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
import javax.servlet.http.HttpSession;

import com.dao.AccountDetailsDao;
import com.dao.PersonalDetailsDao;
import com.dao.RegisterDao;
import com.model.PersonalDetails;
import com.security.EncryptionDecryption;
import com.security.PasswordGeneration;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminApproveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminApproveServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session=request.getSession();
		String accNum=request.getParameter("accNo");
		long accNo=Long.parseLong(accNum);
		String p=null;
		String em=null;
		
		
		//get email and password from database
		AccountDetailsDao ad=new AccountDetailsDao();
		try
		{
			em=ad.searchEmail(accNo);
			p=ad.searchPassword(accNo);
			//System.out.println("Email\t"+em);
			//System.out.println("Password \t"+p);
		}
		catch(Exception e)
		{
			System.out.println("In Admin Approve");
		}
		
		//decrypt password
		String decrypted=null;
		EncryptionDecryption ed=new EncryptionDecryption();
		try
		{
			decrypted=ed.decrypt(p);
			//System.out.println("Decrypted in Approve\t"+decrypted);
		}
		catch(Exception e)
		{
			System.out.println("In admin Approve Encryption");
		}
		
		/*decrypted = (String) request.getAttribute("password");
		System.out.println("1 2 3 password\t"+decrypted);
		
		String pass=(String) request.getAttribute("password");
		System.out.println("get Password\t"+pass);
		*/
		PasswordGeneration pg=new PasswordGeneration();
		String ReceiverAddress=em;   //"rushikeshsupekar7984@gmail.com";
		//System.out.println("3");
		System.out.println("Add="+ReceiverAddress);
		final String username = "pratiksha.21820071@viit.ac.in";
		final String password = "abc12345";
		//System.out.println("3");
		String bodyMessage="Hii...You created new Account in our Bank\n Your password is : "+decrypted+"\n Use your registred mail ID and above password to login. You can chnage your password after login, go to Account Setting ";
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true"); 
		//prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
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
			message.setSubject("New Account request approved");
			message.setText(bodyMessage);
			//System.out.println("6");
			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) 
		{
			System.out.println("Email\t"+e);
		}
	/*	RegisterDao rd=new RegisterDao();
		int i=rd.deleteRegister(accNo);
		if(i>0)
		{
			System.out.println("Deleted from Register");
			response.sendRedirect("AdminHome.jsp");
		}
		else
		{
			System.out.println("Deletion of Register failed");
		}
		*/
		response.sendRedirect("AdminHome.jsp");
	}

}
