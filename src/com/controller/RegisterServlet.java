package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.RegisterDao;
import com.model.AccountDetails;
import com.model.AddressDetails;
import com.model.DocumentDetails;
import com.model.PersonalDetails;
import com.model.Regsiter;
import com.security.EncryptionDecryption;
import com.security.PasswordGeneration;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session= request.getSession();
		PrintWriter pw=response.getWriter();
		int i=0;

		//read data from user
		String firstName=request.getParameter("firstName");
		String middleName=request.getParameter("middleName");
		String lastName=request.getParameter("lastName");
		String email=request.getParameter("email");
		
		String gender=request.getParameter("gender");
		String dob=request.getParameter("datepicker");
		String contactNo=request.getParameter("contact");
		String address=request.getParameter("address");
		String locality=request.getParameter("locality");
		String landmark=request.getParameter("landmark");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		String pinCode = request.getParameter("pin");
		String accountType=request.getParameter("accType");
		String panNo= request.getParameter("panNo");
		String adhar=request.getParameter("aadharNo");

		//request.setAttribute("selectedCity", city);

		//listcity(request, response);

		//convert into respective data type
		int postalCode = Integer.parseInt(pinCode);
		long contact= Long.parseLong(contactNo);
		//long panNo= Long.parseLong(pan);
		long adhaarNo= Long.parseLong(adhar);

		//string to date conversion
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date=null;
		try {
			date = formatter.parse(dob);
		} 
		catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("Util date\t"+date);
		//util date to sql date
		java.sql.Date sDate = new java.sql.Date(date.getTime());
		DateFormat df = new SimpleDateFormat("dd/MM/YYYY - hh:mm:ss");
		//System.out.println("SQL date\t"+sDate);


		//system generated password
		String password=null;
		PasswordGeneration pg= new PasswordGeneration();
		String pass=pg.password();
		//System.out.println("System generated password\t"+pass);
		request.setAttribute("password", pass);
		EncryptionDecryption ed=new EncryptionDecryption();
		//password encryption
		try
		{
			SecretKey key = ed.generateKey("AES");
			Cipher chipher;
			chipher = Cipher.getInstance("AES");
			
			byte[] encryptedData = ed.encrypt(pass, key, chipher);
			password = new String(encryptedData);
			//System.out.println("Encrypted password\t"+password);
			String decrypted = ed.decrypt(encryptedData, key, chipher);
			//System.out.println("Decrypted\t"+decrypted);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		PersonalDetails p =  new PersonalDetails(firstName, middleName, lastName, email, gender, sDate, contact);
		AddressDetails a = new AddressDetails(address, locality, landmark, city, state, postalCode);
		AccountDetails acc = new AccountDetails(accountType, email, password);
		DocumentDetails d= new DocumentDetails(panNo, adhaarNo);

		Regsiter r=new Regsiter(p, a, acc, d);
		RegisterDao rd=new RegisterDao();
		try
		{
			i=rd.addRegister(r);
			if(i>0)
			{
				System.out.println("Registration Successful...!!");
				request.setAttribute("email", email);
				RequestDispatcher rs=request.getRequestDispatcher("EmailServlet");
				//System.out.println("After RS");
				rs.forward(request, response);
				//System.out.println("After forward");
				
			}
			else
			{
				System.out.println("Registration Failed");
			}
		}
		catch(Exception e)
		{
			System.out.println("In register Servlet\t"+e);
		}

	}

}
