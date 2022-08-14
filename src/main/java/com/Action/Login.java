package com.Action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.Bean.User;
import com.DAO.UserDao;
import com.opensymphony.xwork2.ActionSupport;

public class Login extends ActionSupport 
{
	
	private String password,email;
	
	public void setPassword(String password) 
	{
		this.password = password;
	}

	public String getPassword() 
	{
		return password;
	}


	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getEmail() 
	{
		return email;
	}
	
	public String execute()
	{
		UserDao user_dao=new UserDao();
		User user=new User();
		user.setEmail(getEmail());
		user.setPassword(getPassword());
		if(!user_dao.UserExists(user))
		{
			addActionError("No such user found!!");
			return ERROR;
		}
		String name[]=new String[1];
		if(!user_dao.isAuthenticated(user,name))
		{
			addActionError("Invalid Credentials!!");
			return ERROR;
		}
		HttpServletResponse res=ServletActionContext.getResponse();
		Cookie cookie=new Cookie("user",email);
		cookie.setMaxAge(86400);
//	    cookie.setPath(";HttpOnly;");
	    cookie.setSecure(true);
	    
	    Cookie cookie2=new Cookie("name",name[0]);
	    cookie2.setMaxAge(86400);
	    
	    res.addCookie(cookie2);
		res.addCookie(cookie);
		return SUCCESS;
	}	
}
