package com.DBUtil;
import java.lang.Exception;
import java.sql.Connection;
import java.sql.DriverManager;
public class Connector 
{
	private static Connector Connector=null;
	private Connection con=null;
	private Connector() throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
	}
	
	public static Connector getInstance() 
	{
		try
		{
			if(Connector==null)
			{
				Connector=new Connector();
			}			
			return Connector;
		}
		catch(Exception ex)
		{
			System.out.println("Exception in getInstance db util "+ex.getMessage());
			return null;
		}
	}
	
	public Connection getConnection()
	{
		try
		{
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/JAVA","root","");
			return con;
		}
		catch(Exception ex)
		{
			System.out.println("Exception in getConnection db util "+ex.getMessage());
			return null;
		}
	}
}
