package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBTransaction {

	
	
	private String url;
	private String user;
	private String pass;
	private String tableName;
	Connection con = null;
	
	
	
	
	public DBTransaction(String url, String user, String pass, String tableName) {
		super();
		this.url = url;
		this.user = user;
		this.pass = pass;
		this.tableName = tableName;
	}
	
	

	public String getUrl() {
		return url;
	}



	public void setUrl(String url) {
		this.url = url;
	}



	public String getUser() {
		return user;
	}



	public void setUser(String user) {
		this.user = user;
	}



	public String getPass() {
		return pass;
	}



	public void setPass(String pass) {
		this.pass = pass;
	}



	public String getTableName() {
		return tableName;
	}



	public void setTableName(String tableName) {
		this.tableName = tableName;
	}



	public Connection getConnection()
	{
		try {
			closeConnection();
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url,user,pass);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public void closeConnection()
	{
		
		try {
			if(con!=null &&con.isClosed()==false)
			{
				con.close();
				con = null;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

