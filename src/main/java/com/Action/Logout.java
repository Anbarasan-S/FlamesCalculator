package com.Action;

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;

public class Logout 
{
	public String execute()
	{
	  Cookie cookies[]=ServletActionContext.getRequest().getCookies();
	  for(Cookie cookie:cookies)
	  {
		  String name=cookie.getName();
		  if(name.equals("user")||name.equals("name"))
		  {
			  cookie.setMaxAge(0);
			  ServletActionContext.getResponse().addCookie(cookie);
		  }
	  }
		return "success";
	}
}
