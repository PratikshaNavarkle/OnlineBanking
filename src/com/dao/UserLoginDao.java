package com.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.model.DummyDetails;
import com.security.*;
import com.service.DummyDetailsInterface;

import DbConnection.DBConnection;


public class UserLoginDao implements DummyDetailsInterface
{
	DBConnection db=new DBConnection();
	Connection con;
	PreparedStatement ps;
	Statement statement;
	ResultSet rs;
	public UserLoginDao() {
		// TODO Auto-generated constructor stub
	}

/*	public void newConnection() throws Exception
	{
		final String driver="oracle.jdbc.Ora
		con-db.cleDriver";
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
	public long searchEmail(String email,String password)
	{ 
		con=db.myConnection();
		String p,p1;
		Long acc=0L;
		try
		{
		//	newConnection();
			EncryptionDecryption en=new EncryptionDecryption();

			//save data
			PreparedStatement ps=con.prepareStatement("select * from Register where email=?");
			ps.setString(1,email);
			ResultSet rs=ps.executeQuery();
			if(!rs.next())
			{
				System.out.println("No such user exists...");
			}
			else
			{
				do
				{
					//System.out.println("In Do While pass="+password);
					p=rs.getString(16);
					//System.out.println("Encrypted : "+p);
					p1=en.decrypt(p);
					//System.out.println("Decrypted : "+p1);
					if(password.equals(p1))
					{
						acc=rs.getLong(1);
						System.out.println("valid user");
						break;
					}
					else
					{
						System.out.println("invalid password");
					}	
				}while(rs.next());
			}

		}
		catch(Exception e)
		{
			System.out.println("error"+e);
		}
		return acc;
	}

	@Override
	public int addDummy(DummyDetails d) 
	{
		con=db.myConnection();
		int i=0;
		try
		{
			//newConnection();
			//System.out.println("In add Personal");
			ps=con.prepareStatement("insert into User_Validation values(?,?)");
			ps.setLong(1, d.getAccNo());
			ps.setString(2, d.getPassword());

			i=ps.executeUpdate();
			//System.out.println("1");
		}
		catch(Exception e)
		{
			System.out.println("In Insert Dummy details\t"+e);
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

	public String searchPassword(long accNo)
	{
		con=db.myConnection();
		String password=null;
		try
		{
			//newConnection();

			ps=con.prepareStatement("select password from User_Validation where id=?");
			ps.setLong(1, accNo);
			ResultSet rs=ps.executeQuery();

			if(rs.next())
			{
				password=rs.getString(1);
			}
		}
		catch(Exception e)
		{
			System.out.println("In dummy Dao\t"+e);
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
}
