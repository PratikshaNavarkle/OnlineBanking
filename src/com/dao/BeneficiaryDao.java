package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.model.BeneficiaryDetails;
import com.model.MyBank;
import com.model.Regsiter;

import DbConnection.DBConnection;

public class BeneficiaryDao {
	DBConnection d=new DBConnection();
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
	public int addBeneficiary(BeneficiaryDetails b)
	{
		//System.out.println("In Add Benficiary ");
		con=d.myConnection();
		int i=0;
		try 
		{
			
			ps=con.prepareStatement("insert into Beneficiary_Details values(?,?,?,?,?,?,?)");
			ps.setLong(1, b.getAccNo());
			ps.setLong(2, b.getbAccNo());
			ps.setString(3, b.getBname());
			ps.setString(4, b.getBemail());
			ps.setString(5, b.getBankname());
			ps.setString(6, b.getIfsc());
			ps.setString(7, b.getAcctype());
	
			i=ps.executeUpdate();
			if(i>0)
			{
				System.out.println("Beneficiary added");
			}
			
		}
		catch (Exception e) 
		{
			System.out.println("Inside Insert\t"+e);
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
	public MyBank getBenfBank(long accNo)
	{
		String bank,ifsc;
		MyBank mb=new MyBank();
		con=d.myConnection();
		//List<AccountDetails> lst=null;
		try
		{
			//System.out.println("Inside try");
			//myConnection();

			PreparedStatement ps = con.prepareStatement("select bankName,ifscCode from Beneficiary_Details where benfAccNo=?");
			ps.setLong(1, accNo);
			ResultSet rs = ps.executeQuery();

			//	System.out.println("After Crt");
			while (rs.next()) 
			{
				bank=rs.getString(1);
				ifsc=rs.getString(2);
				mb.setBankName(bank);
				mb.setIFSC(ifsc);
				//System.out.println("In RS");
			}
			//lst=new ArrayList<AccountDetails>();
			//lst.add(ad);
			//s.setAttribute("cart",lst);
			//response.sendRedirect("MyProfile.jsp");	
		}
		catch(Exception e)
		{
			System.out.println("In get benfAccount bank\t"+e);
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return mb;
	}
}
