package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.model.DocumentDetails;
import com.service.DocumentDetailsInterface;

public class DocumentDetailsDao implements DocumentDetailsInterface
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
	public int addDocument(DocumentDetails d)
	{
		int i=0;
		try
		{
			myConnection();
		//	System.out.println("In add Document");
			ps=con.prepareStatement("insert into Documents_Details values(?,?,?)");
			ps.setLong(1, d.getAccNo());
			ps.setString(2, d.getPanNo());
			ps.setLong(3, d.getAdhaarNo());
			
			i=ps.executeUpdate();
		//	System.out.println("1");
		}
		catch(Exception e)
		{
			System.out.println("In Insert Document details\t"+e);
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
	public List<DocumentDetails> getAllDocumentDetails() 
	{
		return null;
	}

	@Override
	public int deleteDocument(long accNo)
	{
		int i=0;
		try
		{
			myConnection();
		//	System.out.println("1");
			ps=con.prepareStatement("delete from Documents_Details where accno=?");
		//	System.out.println("2");
			ps.setLong(1, accNo);
		//	System.out.println("3");
			i=ps.executeUpdate();
		//	System.out.println("4");
		}
		catch(Exception e)
		{
			System.out.println("In document Delete\t"+e);
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
	public DocumentDetails searchDocument(long accNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocumentDetails updateDocument(DocumentDetails d) {
		// TODO Auto-generated method stub
		return null;
	}

}
