package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.model.City;

public class CityDao 
{
	 public List<City> getCity()
	 {
		 List<City> listCity = new ArrayList<>();
       //  Database d=new Database();
        
        Connection con=null;
     	PreparedStatement ps;
     	Statement statement;
     	ResultSet rs;
	        try {
	        	 try {
	     			//d.myConnection();
	     		} 
	              catch (Exception e) {
	     			System.out.println(e);
	     		}
	            String sql = "SELECT * FROM City ORDER BY cityname";
	            statement = con.createStatement();
	            
	            ResultSet result = statement.executeQuery(sql);
	             
	            while (result.next()) {
	                int id = result.getInt("id");
	                String name = result.getString("cityname");
	                City c = new City(id, name);
	                     
	                listCity.add(c);
	            }          
	             
	        } catch (SQLException ex) 
	        {
	           System.out.println(ex);
	        }      
	         
	        return listCity;
	    }
	 }
	

