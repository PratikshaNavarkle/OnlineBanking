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
import com.model.AddressDetails;
import com.model.DocumentDetails;
import com.model.PersonalDetails;
import com.model.Regsiter;
import com.service.RegisterInterface;

import DbConnection.DBConnection;

public class RegisterDao implements RegisterInterface
{
	
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
	@Override
	public long addRegister(Regsiter r)
	{
		int i=0;
		Long accNo=100000000000L;
		con=d.myConnection();
		try 
		{
			//myConnection();
			//System.out.println("Before sequence");
			
			String sql="select accNo.nextval from Register";
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
			r.getP().setAccNo(accNo);
			//System.out.println("Account number is set to\t"+r.getP().getAccNo());
			//System.out.println("After sequence");
			ps=con.prepareStatement("insert into Register values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
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
			ps.setDouble(16, r.getAcc().getAccBal());
			ps.setString(17, r.getAcc().getPassword());
			ps.setLong(18, r.getD().getAdhaarNo());
			ps.setString(19, r.getD().getPanNo());
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
		finally
		{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return accNo;
	}

	@Override
	public List<Regsiter> getAllRegister() 
	{

		return null;
	}

	@Override
	public int deleteRegister(long accNo) 
	{
		int i=0;
		con=d.myConnection();
		try
		{
		//	myConnection();
			//System.out.println("1");
			ps=con.prepareStatement("delete from Register where accno=?");
			//System.out.println("2");
			ps.setLong(1, accNo);
			//System.out.println("3");
			
			i=ps.executeUpdate();
			
			//System.out.println("Value of i\t"+i);
			//System.out.println("4");
			
		}
		catch(Exception e)
		{
			System.out.println("In Register Delete\t"+e);
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
	public int searchRegister(long accNo) 
	{
		con=d.myConnection();	
		int i=0;
		try
		{
			String sql="select * from Register where accNo=?";
			ps=con.prepareStatement(sql);
			ps.setLong(1, accNo);
			rs=ps.executeQuery();
			List<PersonalDetails> alist=new ArrayList<PersonalDetails>();
			PersonalDetails p=new PersonalDetails(0, null, null, null, null, null, null, 0);
			AddressDetails a=new AddressDetails(0, null, null, null, null, null, 0);
			AccountDetails acc=new AccountDetails(0, null, 0, null, null);
			DocumentDetails d= new DocumentDetails(0, null, 0);
			if(rs.next())
			{
				
				p.setAccNo(rs.getLong(1));
				p.setFirstName(rs.getString(2));
				p.setMiddleName(rs.getString(3));
				p.setLastName(rs.getString(4));
				p.setEmail(rs.getString(5));
				p.setGender(rs.getString(6));
				p.setDob(rs.getDate(7));
				p.setContact(rs.getLong(8));
				a.setAccNo(rs.getLong(1));
				a.setAddress(rs.getString(9));
				a.setLocality(rs.getString(10));
				a.setLandmark(rs.getString(11));
				a.setCity(rs.getString(12));
				a.setState(rs.getString(13));
				a.setPinCode(rs.getInt(14));
				acc.setAccNo(rs.getLong(1));
				acc.setAccType(rs.getString(15));
				acc.setAccBal(rs.getInt(16));
				acc.setEmail(rs.getString(5));
				acc.setPassword(rs.getString(17));
				d.setAccNo(rs.getLong(1));
				d.setAdhaarNo(rs.getLong(18));
				d.setPanNo(rs.getString(19));
				
				PersonalDetailsDao pd=new PersonalDetailsDao();
				pd.addPersonal(p);
				System.out.println("Peronal added From Register");
				i=1;
			}

			alist.add(p);
		}
		catch(Exception e)
		{
			System.out.println("In Search Register\t"+e);
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
	public Regsiter updateRegsiter(Regsiter r) 
	{

		return null;
	}

}
