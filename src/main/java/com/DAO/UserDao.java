package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

import com.Bean.User;
import com.DBUtil.Connector;
import com.Email.EmailServer;

public class UserDao 
{
	private Connector db=Connector.getInstance();
	private Connection con=db.getConnection();
	private ResultSet rs=null;
	private PreparedStatement ps=null;
	public boolean UserExists(User user)
	{
		try
		{
			String email=user.getEmail();
			 ps=con.prepareStatement("SELECT* FROM User WHERE email=?");
			ps.setString(1, email);
			rs=ps.executeQuery();
			if(rs.next())
			{
				return true;
			}
			return false;
		}
		catch(Exception ex)
		{
			System.out.println("Exception in UserExists of UserDao "+ex.getMessage());
			return true;
		}
	}
	
	public boolean addUser(User user)
	{
		try
		{
			String name=user.getName(),email=user.getEmail(),password=user.getPassword();
			con.setAutoCommit(false);
			Random rand=new Random();
			int verification_code=rand.nextInt((100000-10000)+1)+10000;
			ps=con.prepareStatement("INSERT INTO User(name,email,password,code) VALUES(?,?,?,?)");
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3,password);
			ps.setInt(4, verification_code);
			ps.execute();
			EmailServer email_server=new EmailServer();
			if(!email_server.sendEmail(email,"Your verification code for the flamesapplication","Verification code: "+verification_code))
			{
				return false;
			}
			con.commit();
			con.setAutoCommit(true);
			return true;
		}
		catch(Exception ex)
		{
			System.out.println("Exception in addUser of user dao "+ex.getMessage());
			return false;
		}
	}
	
	public boolean verifyUser(User user)
	{
		try
		{
			String email=user.getEmail();
			String query="SELECT* FROM User where email=?";
			ps=con.prepareStatement(query);			
			ps.setString(1, email);
			rs=ps.executeQuery();
			if(!rs.next())
			{
				return false;
			}
			if(rs.getBoolean("verified"))
			{
				return true;
			}
			if(user.getCode()==rs.getInt("code"))
			{
				query="UPDATE User set verified=true";
				ps=con.prepareStatement(query);
				ps.executeUpdate();
				return true;
			}
			return false;
		}
		catch(Exception ex)
		{
			System.out.println("Exception in verify user of UserDao "+ex);
			return false;
		}
	}
	
	public boolean isAuthenticated(User user,String name[])
	{
		String email=user.getEmail();
		String password=user.getPassword();
		try
		{
			String query="SELECT * FROM User where email=?";
			ps=con.prepareStatement(query);
			ps.setString(1, email);
			rs=ps.executeQuery();
			rs.next();
			if(rs.getString("password").equals(password))
			{
				name[0]=rs.getString("name");
				return true;
			}
			return false;
		}
	catch(Exception ex)
		{
			System.out.println("Exception in isAuthenticated "+ex.getMessage());
			return false;
		}
	}
}

