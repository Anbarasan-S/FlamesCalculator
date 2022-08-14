package com.Action;

import com.Bean.User;
import com.DAO.UserDao;
import com.opensymphony.xwork2.ActionSupport;

public class Verify extends ActionSupport
{
	private String email;
	private int code;
	
	public String getEmail() {
		return email;
	}

	public int getCode() {
		return code;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String execute()
	{
		UserDao user_dao=new UserDao();
		User user=new User();
		user.setEmail(email);
		user.setCode(code);
		if(user_dao.verifyUser(user))
		{
			addActionMessage("User verified successfully!!");
			return SUCCESS;
		}
		addActionError("Sorry we couldn't verify your account check whether the account exists or the verification code is correct!!");
		return ERROR;
	}
}
