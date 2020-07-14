package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.model.AddressDetails;
import com.service.AddressDetailsInterface;

public class AddressDetailsDao implements AddressDetailsInterface
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
	public int addAddress(AddressDetails a) 
	{
		int i=0;
		try
		{
			myConnection();
			//System.out.println("In add Address");
			ps=con.prepareStatement("insert into Residential_Details values(?,?,?,?,?,?,?)");
			ps.setLong(1, a.getAccNo());
			ps.setString(2, a.getAddress());
			ps.setString(3, a.getLocality());
			ps.setString(4, a.getLandmark());
			ps.setString(5, a.getCity());
			ps.setString(6, a.getState());
			ps.setInt(7, a.getPinCode());
			
			i=ps.executeUpdate();
			//System.out.println("1");
		}
		catch(Exception e)
		{
			System.out.println("In Insert address details\t"+e);
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
	public List<AddressDetails> getAllAddressDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteAddress(long accNo) {
		int i=0;
		try
		{
			myConnection();
			//System.out.println("1");
			ps=con.prepareStatement("delete from Residential_Details where accno=?");
			//System.out.println("2");
			ps.setLong(1, accNo);
			//System.out.println("3");
			i=ps.executeUpdate();
			//System.out.println("4");
		}
		catch(Exception e)
		{
			System.out.println("In address Delete\t"+e);
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
	public AddressDetails searchAddress(long accNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AddressDetails updateAddress(AddressDetails a) {
		// TODO Auto-generated method stub
		return null;
	}

}
