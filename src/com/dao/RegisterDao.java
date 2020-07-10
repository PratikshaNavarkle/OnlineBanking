package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import com.model.Regsiter;
import com.service.RegisterInterface;

import DbConnection.DBConnection;

public class RegisterDao implements RegisterInterface
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
	public int addRegister(Regsiter r)
	{
		int i=0;
		//DBConnection d=new DBConnection();
		//d.myConnection();
		try 
		{
			myConnection();
			//System.out.println("Before sequence");
			Long accNo=0L;
			//String sql="select accNo.nextval from Register";
			//System.out.println("first");
			ps=con.prepareStatement("select accNo.nextval from Register");
			//System.out.println("2");
			rs=ps.executeQuery();
			//System.out.println("3");
			if(rs.next())
			{
				//System.out.println("4");
				accNo=rs.getLong(1);
				//System.out.println("5");
			}
			
			//System.out.println("After sequence");
			ps=con.prepareStatement("insert into Register values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			//System.out.println("Enter cust id, first name and last name");
			//System.out.println("1");
			ps.setLong(1, accNo);
			ps.setString(2, r.getP().getFirstName());
			ps.setString(3, r.getP().getMiddleName());
			ps.setString(4, r.getP().getLastName());
			ps.setString(5, r.getP().getEmail());
			ps.setString(6, r.getP().getGender());
			ps.setDate(7, (Date) r.getP().getDob());
			ps.setLong(8,r.getP().getContact());
			ps.setString(9, r.getA().getAddress());
			ps.setString(10, r.getA().getLocality());
			ps.setString(11, r.getA().getLandmark());
			ps.setString(12, r.getA().getCity());
			ps.setString(13, r.getA().getState());
			ps.setInt(14, r.getA().getPinCode());
			ps.setString(15, r.getAcc().getAccType());
			ps.setString(16, r.getAcc().getPassword());
			ps.setLong(17, r.getD().getAdhaarNo());
			ps.setString(18, r.getD().getPanNo());
			//System.out.println("2");
			i=ps.executeUpdate();
			//System.out.println("After execute");
			try
			{
				con.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			if(i>0)
			{
				System.out.println("Record inserted....");
			}
		}
		catch (Exception e) 
		{
			System.out.println("Inside Insert\t"+e);
		}
		

		return i;
	}

	@Override
	public List<Regsiter> getAllRegister() 
	{
		
		return null;
	}

	@Override
	public void deleteRegister(long accNo) 
	{
		
		
	}

	@Override
	public Regsiter searchRegister(long accNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Regsiter updateRegsiter(Regsiter r) 
	{
		
		return null;
	}

}
