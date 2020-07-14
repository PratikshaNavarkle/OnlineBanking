package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.model.PersonalDetails;
import com.model.Regsiter;
import com.service.PersonalDetailsInterface;

public class PersonalDetailsDao implements PersonalDetailsInterface
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
	public int addPersonal(PersonalDetails p) 
	{
		int i=0;
		try
		{
			myConnection();
			//System.out.println("In add Personal");
			ps=con.prepareStatement("insert into Personal_Details values(?,?,?,?,?,?,?,?)");
			ps.setLong(1, p.getAccNo());
			ps.setString(2, p.getFirstName());
			ps.setString(3, p.getMiddleName());
			ps.setString(4, p.getLastName());
			ps.setString(5, p.getEmail());
			ps.setDate(6, (Date) p.getDob());
			ps.setString(7, p.getGender());
			ps.setLong(8, p.getContact());

			i=ps.executeUpdate();
			//System.out.println("1");
		}
		catch(Exception e)
		{
			System.out.println("In Insert personal details\t"+e);
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
	public List<PersonalDetails> getAllPersonalDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deletePersonal(long accNo) 
	{
		int i=0;
		try
		{
			myConnection();
			//System.out.println("1");
			ps=con.prepareStatement("delete from Personal_Details where accno=?");
			//System.out.println("2");
			ps.setLong(1, accNo);
			//System.out.println("3");
			
			i=ps.executeUpdate();
			
			//System.out.println("Value of i\t"+i);
			//System.out.println("4");
			
		}
		catch(Exception e)
		{
			System.out.println("In personal Delete\t"+e);
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
	public PersonalDetails searchPersonal(long accNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonalDetails updatePersonal(PersonalDetails p) {
		// TODO Auto-generated method stub
		return null;
	}

}
