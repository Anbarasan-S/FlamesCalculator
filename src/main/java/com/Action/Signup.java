package com.Action;

import java.util.Random;

import com.Bean.User;
import com.DAO.UserDao;
import com.Email.EmailServer;
import com.opensymphony.xwork2.ActionSupport;

public class Signup extends ActionSupport
{
	
	public Signup()
	{
		setVal();
	}
	private String name,email,password,re_type_password;
	private Integer age;
	private String val;
	
	public String getVal()
	{
		return this.val;
	}
	
	public void setVal()
	{
		this.val="afs";
	}
	
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRe_type_password() {
		return re_type_password;
	}

	public void setRe_type_password(String re_type_password) {
		this.re_type_password = re_type_password;
	}

	public boolean err=false;
	
	    public void validate() 
	    {
	        if(!getPassword().equals(getRe_type_password()))
			{
					addFieldError("re_type_password","The password not match with the actual password");
			}
	    }
	    
	public String execute() 
	{
		
		UserDao user_dao=new UserDao();
		User user=new User();
		user.setEmail(email);
		user.setName(name);
		user.setPassword(password);
		if(user_dao.UserExists(user))
		{
			addActionError("User already exists");
			return ERROR;
		}
		if(!user_dao.addUser(user))
		{
			addActionError("Sorry we couldn't sign up");
			return ERROR;
		}
		
		addActionMessage("Enter the verification code sent to your email");
		return SUCCESS;
	}
}
