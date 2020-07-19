package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.AccountDetails;
import com.security.EncryptionDecryption;
import com.service.AccountDetailsInterface;

import DbConnection.DBConnection;

public class AccountDetailsDao implements AccountDetailsInterface
{
	DBConnection db=new DBConnection();
	Connection con;
	PreparedStatement ps;
	Statement statement;
	ResultSet rs;

/*	public void myConnection() throws Exception
	{
		final String driver="oracle.jdbc.OracleDriver";
		final String username="SYSTEM";
		final String password="Pr@tiksha";
		final String url="jdbc:oracle:thin:@Pratiksha:1521:XE";
		//Step1- load driver..
		Class.forName(driver);
		//Step2-Connection to DB
		con=DriverManager.getConnection(url,username,password);
		//System.out.println("Connection :"+con);
	}
*/

	@Override
	public int addAccount(AccountDetails acc) {
		int i=0;
		con=db.myConnection();
		try
		{
		//	myConnection();
			//System.out.println("In add Account");
			ps=con.prepareStatement("insert into Account_Details values(?,?,?,?,?)");
			ps.setLong(1, acc.getAccNo());
			ps.setString(2, acc.getAccType());
			ps.setDouble(3, acc.getAccBal());
			ps.setString(4, acc.getPassword());
			ps.setString(5, acc.getEmail());

			i=ps.executeUpdate();
			//System.out.println("1");
		}
		catch(Exception e)
		{
			System.out.println("In Insert account details\t"+e);
		}
		finally
		{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return i;
	}

	@Override
	public int deleteAccount(long accNo) {
		int i=0;
		con=db.myConnection();
		try
		{
			//myConnection();
			//	System.out.println("1");
			ps=con.prepareStatement("delete from Account_Details where accno=?");
			//	System.out.println("2");
			ps.setLong(1, accNo);
			//	System.out.println("3");
			i=ps.executeUpdate();
			//	System.out.println("4");
		}
		catch(Exception e)
		{
			System.out.println("In Account Delete\t"+e);
		}
		finally
		{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return i;
	}

	@Override
	public String searchEmail(long accNo) 
	{
		con=db.myConnection();
		String email=null;
		try
		{
			//myConnection();
			ps=con.prepareStatement("select email from Account_Details where accno=?");
			ps.setLong(1, accNo);
			ResultSet rs=ps.executeQuery();

			if(rs.next())
			{
				email=rs.getString(1);
			}
		}
		catch(Exception e)
		{
			System.out.println("In Account Serach Email method\t"+e);
		}
		finally
		{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return email;
	}

	@Override
	public String searchPassword(long accNo) {
		String password=null;
		con=db.myConnection();
		try
		{
			//myConnection();
			ps=con.prepareStatement("select password from Account_Details where accno=?");
			ps.setLong(1, accNo);
			ResultSet rs=ps.executeQuery();

			if(rs.next())
			{
				password=rs.getString(1);
			}
		}
		catch(Exception e)
		{
			System.out.println("In Account Serach Email method\t"+e);
		}
		finally
		{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return password;
	}

	@Override
	public int updateAccountBalance(long accNo,double bal) 
	{
		con=db.myConnection();
		int i=0;
		try
		{
			//myConnection();
			ps=con.prepareStatement("UPDATE Account_Details SET accbal=? WHERE accno=?");
			ps.setLong(2, accNo);
			ps.setDouble(1, bal);
			i=ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println("In Update balance\t"+e);
		}
		return i;
	}


	@Override
	public double getAccountBalance(long accNo)
	{
		double balance=0;
		con=db.myConnection();
		//List<AccountDetails> lst=null;
		try
		{
			//System.out.println("Inside try");
			//myConnection();

			PreparedStatement ps = con.prepareStatement("select accBal from Account_Details where accno=?");
			ps.setLong(1, accNo);
			ResultSet rs = ps.executeQuery();

			//	System.out.println("After Crt");
			while (rs.next()) 
			{
				balance=rs.getDouble(1);
				//System.out.println("In RS");
			}
			//lst=new ArrayList<AccountDetails>();
			//lst.add(ad);
			//s.setAttribute("cart",lst);
			//response.sendRedirect("MyProfile.jsp");	
		}
		catch(Exception e)
		{
			System.out.println("In get Account balance\t"+e);
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return balance;
	}


	@Override
	public List<AccountDetails> getAllAccounts(long acNo) 
	{
		con=db.myConnection();
		List<AccountDetails> lst=null;
		try
		{
			//System.out.println("Inside try");

			//myConnection();
			PreparedStatement ps = con.prepareStatement("select * from Account_Details where accno=?");
			ps.setLong(1, acNo);
			ResultSet rs = ps.executeQuery();
			AccountDetails a=null;
			//	System.out.println("After Crt");
			while (rs.next()) 
			{
				a=new AccountDetails(0, null, 0, null, null);
				//System.out.println("Inside RS");
				a.setAccNo(rs.getLong(1));
				a.setAccType(rs.getString(2));
				a.setAccBal(rs.getDouble(3));
				a.setPassword(rs.getString(4));
				a.setEmail(rs.getString(5));
				//System.out.println("In RS");
			}
			lst=new ArrayList<AccountDetails>();
			lst.add(a);

			//s.setAttribute("cart",lst);
			//response.sendRedirect("MyProfile.jsp");

		}
		catch(Exception e)
		{
			System.out.println("In Profile Servlet\t"+e);
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return lst;
	}

	public void updatePassword(long accNo,String password)
	{
		int i;
		con=db.myConnection();
		String newPass=null;
		EncryptionDecryption en=new EncryptionDecryption();
		newPass=en.encrypt(password);
		System.out.println("Encrypted New password :"+newPass);
		try
		{
		//	myConnection();
			ps=con.prepareStatement("select * from Account_Details where accno=?");
			ps.setLong(1, accNo);
			ResultSet rs=ps.executeQuery();		
			if(rs.next())
			{
				System.out.println("In Database of Ano :"+accNo);
				ps=con.prepareStatement("update Account_Details set password=? where accno=?");
				ps.setString(1,newPass);
				ps.setLong(2,accNo);
				i=ps.executeUpdate();
				if(i>0)
				{
					System.out.println("password Updated");
				}	
			}
			else
			{
				System.out.println("In update password method Account not found");
			}
		}
		catch(Exception e)
		{
			System.out.println("In update password method\t"+e);
		}
	}

	public String searchAccount(long accNo,String email) 
	{
		con=db.myConnection();
		String em=null;
		String password=null;
		try
		{
			//myConnection();
			ps=con.prepareStatement("select * from Account_Details where accno=?");
			ps.setLong(1, accNo);
			ResultSet rs=ps.executeQuery();

			if(rs.next())
			{
				em=rs.getString(5);
				System.out.println("Database:"+em+"\nEntered"+email);
				if(em.equals(email))
				{
					password=rs.getString(4);
					System.out.println("In Account Serach Email method Account found Email Found\t");

				}
				else
				{
					System.out.println("invalid Email");
				}
			}
			else
			{
				System.out.println("In Account Serach Account method Account not found");
			}
		}
		catch(Exception e)
		{
			System.out.println("In Account Serach Email method\t"+e);
		}
		finally
		{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return password;
	}
	
}
