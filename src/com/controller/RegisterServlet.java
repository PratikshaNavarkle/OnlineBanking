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

import com.dao.AccountDetailsDao;
import com.dao.AddressDetailsDao;
import com.dao.DocumentDetailsDao;
import com.dao.PersonalDetailsDao;
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session= request.getSession();
		PrintWriter pw=response.getWriter();
		long i=0;

		//read data from user
		String firstName=request.getParameter("firstName");
		String middleName=request.getParameter("middleName");
		String lastName=request.getParameter("lastName");
		String email=request.getParameter("email");
		//request.setAttribute("ID", email);
		session.setAttribute("ID", email);
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
		String encryptedData=null;
		//password encryption
		try
		{
			encryptedData=ed.encrypt(pass);
			String decryptedData=ed.decrypt(encryptedData);
			System.out.println("encrypted\t"+encryptedData);
			System.out.println("decrypted\t"+decryptedData);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		PersonalDetails p =  new PersonalDetails(0,firstName, middleName, lastName, email, gender, sDate, contact);
		AddressDetails a = new AddressDetails(0, address, locality, landmark, city, state, postalCode);
		
		AccountDetails acc = new AccountDetails(0, accountType, email, encryptedData);
		DocumentDetails d= new DocumentDetails(0, panNo, adhaarNo);

		Regsiter r=new Regsiter(p, a, acc, d);
		RegisterDao rd=new RegisterDao();
		try
		{
			i=rd.addRegister(r);
			if(i>0)
			{
				int result=0;
				System.out.println("Registration Successful...!!");
				
				PersonalDetails p1=new PersonalDetails(i, firstName, middleName, lastName, email, gender, sDate, contact);
				PersonalDetailsDao pd=new PersonalDetailsDao();
				result=pd.addPersonal(p1);
				if(result>0)
				{
					//System.out.println("Personal Details added");
				}
				else
				{
					System.out.println("Personal Details failed");
				}
				
				AddressDetails a1 = new AddressDetails(i, address, locality, landmark, city, state, postalCode);
				AddressDetailsDao ad=new AddressDetailsDao();
				result=ad.addAddress(a1);
				if(result>0)
				{
					//System.out.println("Address Details added");
				}
				else
				{
					System.out.println("Address Details failed");
				}
				
				AccountDetails acc1	 = new AccountDetails(i, accountType, email, encryptedData);
				AccountDetailsDao add=new AccountDetailsDao();
				result=add.addAccount(acc1);
				if(result>0)
				{
					//System.out.println("Account Details added");
				}
				else
				{
					System.out.println("Account Details failed");
				}
				
				DocumentDetails d1= new DocumentDetails(i, panNo, adhaarNo);
				DocumentDetailsDao dd=new DocumentDetailsDao();
				result=dd.addDocument(d1);
				if(result>0)
				{
					//System.out.println("Document Details added");
				}
				else
				{
					System.out.println("Document Details failed");
				}
				
				//request.setAttribute("email", email);
				//RequestDispatcher rs=request.getRequestDispatcher("EmailServlet");
				//System.out.println("After RS");
				//rs.forward(request, response);
				//System.out.println("After forward");
				response.sendRedirect("Home.jsp");
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
