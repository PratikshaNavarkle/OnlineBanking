package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.model.AccountDetails;
import com.service.AccountDetailsInterface;

public class AccountDetailsDao implements AccountDetailsInterface 
{
	Connection con;
	PreparedStatement ps;
	Statement statement;
	ResultSet rs;

	public void myConnection() throws Exception
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

	
	@Override
	public int addAccount(AccountDetails acc) {
		int i=0;
		try
		{
			myConnection();
			//System.out.println("In add Account");
			ps=con.prepareStatement("insert into Account_Details values(?,?,?,?)");
			ps.setLong(1, acc.getAccNo());
			ps.setString(2, acc.getAccType());
			ps.setString(3, acc.getPassword());
			ps.setString(4, acc.getEmail());
			
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
	public List<AccountDetails> getAllAccountDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteAccount(long accNo) {
		int i=0;
		try
		{
			myConnection();
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
		String email=null;
		try
		{
			myConnection();
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
		try
		{
			myConnection();
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
	public AccountDetails updateAccount(AccountDetails acc) {
		// TODO Auto-generated method stub
		return null;
	}
}
