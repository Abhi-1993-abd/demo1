package com.comcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
	Connection conn;
	
	public void getDbconnection(String url,String username,String password) throws SQLException {
		try {
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		conn=DriverManager.getConnection("url","username","password");
	}catch(Exception e) {
		
	}
	}
	public void getDbconnection() throws SQLException {
		try {
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		conn=DriverManager.getConnection("url","username","password");
	}catch(Exception e) {
		
	}
	}
	
	public void closeDbconnection() {
		try {
			conn.close();
		}
		catch(Exception e) {
			
		}
	}
	
	public ResultSet executeConnSelectQuery(String query) throws SQLException {
		ResultSet result=null;
		try {
		Statement stat = conn.createStatement();
		 result = stat.executeQuery(query);
		}catch(Exception e) {}
		return result;
		
	}
	
	public int exceuteNonSelectQuery(String query) {
		
		int result=0;
		try {
			Statement stat = conn.createStatement();
			 result = stat.executeUpdate(query);
			}catch(Exception e) {}
			return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
