package com.Dao;

import java.util.Date;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

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

	

}
