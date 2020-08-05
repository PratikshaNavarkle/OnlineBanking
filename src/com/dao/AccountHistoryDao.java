package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.model.AccountDetails;
import com.model.AccountHistory;
import com.model.MyBank;
import com.service.AccountHistoryInterface;

import DbConnection.DBConnection;

public class AccountHistoryDao implements AccountHistoryInterface
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
	private static java.sql.Timestamp getCurrentTimeStamp()
	{
		java.util.Date today= new java.util.Date();
		
		
		return new java.sql.Timestamp(today.getTime());
		
	}
	
	public int addHistory(AccountHistory a) {
		int i=0;
		con=db.myConnection();
		try
		{
			//myConnection();
			//System.out.println("In add Personal");
			ps=con.prepareStatement("insert into Account_Statements values(?,?,?,?,?,?,?,?,?,?,?)");
			//System.out.println("before");
			ps.setLong(1, a.getAccNo());
			ps.setLong(2, a.getRecipientAccNo());
			ps.setString(3, a.getReceipientName());
			ps.setString(4, a.getMb().getBankName());
			ps.setString(5, a.getMb().getIFSC());
			ps.setString(6, a.getTrType());
			//System.out.println("before");
			ps.setTimestamp(7, getCurrentTimeStamp());
			ps.setDouble(8, a.getTrAmount());
			//System.out.println("before");
			ps.setDouble(9, a.getAccBalBefore());
			ps.setDouble(10, a.getAccBalAfter());
			ps.setString(11, a.getTrStatus());
			
			System.out.println(getCurrentTimeStamp());
			i=ps.executeUpdate();
			//System.out.println("1");
		}
		catch(Exception e)
		{
			System.out.println("In Insert History details\t"+e);
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

	public List<AccountHistory> getAllHistory(long acNo) 
	{
		con=db.myConnection();
		List<AccountHistory> lst=null;
		try
		{
			//System.out.println("Inside try");
			//myConnection();
			PreparedStatement ps = con.prepareStatement("select * from Account_Statements where accno=?");
			ps.setLong(1, acNo);
			ResultSet rs = ps.executeQuery();
			AccountHistory a=null;
			
			//	System.out.println("After Crt");
			while (rs.next()) 
			{
				a=new AccountHistory(acNo, 0, null, null, null, 0, 0, 0, null);
				MyBank mb=new MyBank();
				//System.out.println("Inside RS");
				a.setAccNo(rs.getLong(1));
				a.setRecipientAccNo(rs.getLong(2));
				a.setReceipientName(rs.getString(3));
				a.setMb(mb);
				a.setTrType(rs.getString(5));
				rs.getTimestamp(7);
				a.setTrAmount(rs.getDouble(8));
				a.setAccBalBefore(rs.getDouble(9));
				a.setAccBalAfter(rs.getDouble(10));
				a.setTrStatus(rs.getString(11));
				
				//System.out.println("In RS");
			}
			lst=new LinkedList<AccountHistory>();
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
	
	
	
}
