package com.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.model.Register;

public class Database 
{

	Connection con;
	PreparedStatement ps;
	Statement statement;
	ResultSet rs;
	public void myConnection() throws Exception
	{
		Class.forName("oracle.jdbc.OracleDriver");
		//step2 connection to DB
		con=DriverManager.getConnection("jdbc:oracle:thin:@Pratiksha:1521:XE","SYSTEM","Pr@tiksha");
	}

	public int insertData(Register r)
	{
		int i=0;
		try{
			myConnection();
			String query="insert into Register values(?,?,?,?,?,?,?,?,?,CURRENT_TIMESTAMP,?,?)";
			ps=con.prepareStatement(query);
			ps.setString(1, r.getFirstName());
			ps.setString(2, r.getMiddleName());
			ps.setString(3, r.getLastName());
			ps.setString(4, r.getAddress());
			ps.setInt(5, r.getPin());
			ps.setString(6, r.getCity());
			ps.setString(7, r.getState());
			ps.setString(8, r.getGender());
			ps.setLong(11, r.getContact());
			ps.setString(12, r.getAccType());
			
			i=ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return i;
	}
}
