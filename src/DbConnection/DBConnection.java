package DbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection 
{
	final String driver="oracle.jdbc.OracleDriver";
	final String username="SYSTEM";
	final String password="Pr@tiksha";
	final String url="jdbc:oracle:thin:@Pratiksha:1521:XE";
	
	private static Connection con;
	
	public Connection myConnection()
	{
		try {
			//Step1- load driver..
			Class.forName(driver);
			//Step2-Connection to DB
			con=DriverManager.getConnection(url,username,password);
			//System.out.println("Connection :"+con);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}
