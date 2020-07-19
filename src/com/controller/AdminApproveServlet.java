package com.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
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
import com.dao.AccountHistoryDao;
import com.dao.PersonalDetailsDao;
import com.dao.RegisterDao;
import com.model.AccountHistory;
import com.model.MyBank;
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
		String bodyMessage="Hii...You created new Account in our ABC Bank\n Your Login Credentials are:\n UserID="+accNo+"\n Password= "+decrypted+"\n REMEMBER,given password is one time password and it will expire once it is used.\n Use above credentials to login and please change passsword once you login.";
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
		} 
		catch (MessagingException e) 
		{
			System.out.println("Email\t"+e);
		}
		
		RegisterDao rd=new RegisterDao();
		int i=rd.deleteRegister(accNo);
		if(i>0)
		{
			System.out.println("Deleted from Register");
			try
			{
				//insert into Transaction table
				PersonalDetailsDao pd=new PersonalDetailsDao();
				String fName=pd.searchPersonal(accNo);
				String lName=pd.searchName(accNo);
				AccountDetailsDao accd=new AccountDetailsDao();
				double accBal=accd.getAccountBalance(accNo);
				MyBank m=new MyBank();
				AccountHistory ah=new AccountHistory(accNo, accNo, fName + lName, m, "Credited", accBal, accBal, accBal, "Successful");
				AccountHistoryDao ahd=new AccountHistoryDao();
				i=ahd.addHistory(ah);
				if(i>0)
				{
					System.out.println("History inserted first time");
					List<AccountHistory> lst=null;
					lst = new LinkedList<AccountHistory>();
					lst=ahd.getAllHistory(accNo);
					session.setAttribute("history", lst);
				}
				else
				{
					System.out.println("History insertion failed first time");
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			response.sendRedirect("AdminHome.jsp");
		}
		else
		{
			System.out.println("Deletion of Register failed");
		}

	}

}
