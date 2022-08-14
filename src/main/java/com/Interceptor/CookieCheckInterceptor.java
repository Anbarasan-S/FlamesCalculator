package com.Interceptor;

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;

import com.Action.Login;
import com.Bean.User;
import com.DAO.UserDao;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class CookieCheckInterceptor implements Interceptor
{
	public void init() {}
	public void destroy() {}
	public String intercept(ActionInvocation ai) throws Exception
	{
		Cookie cookies[]=ServletActionContext.getRequest().getCookies();

		for(Cookie cookie:cookies)
		{
			//If cookie with user present
			if(cookie.getName()=="user")
			{
				UserDao user_dao=new UserDao();
				User user_=new User();
				user_.setEmail(cookie.getValue());
				if(!user_dao.UserExists(user_))
				{
					if(ai.getAction().getClass().equals(Login.class))
					{
						return ai.invoke();
					}
					return "input";  
				}
				return ai.invoke();
			}
		}
		
		//If cookie with user not present
			if(ai.getAction().getClass().equals(Login.class))
			{
				return ai.invoke();
			}
			
			return "input";
	}
}
