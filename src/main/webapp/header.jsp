<%@page import="com.Bean.User"%>
<%@page import="com.DAO.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Flames Application</title>
<link rel="stylesheet" href="header.css">
</head>
<body>
<%
	Cookie cookies[]=request.getCookies();
	boolean is_user_cookie=false;
	String email=null;
	String name=null;	
	
	if(cookies!=null&&cookies.length>0)
	for(Cookie cooki:cookies)
	{		
		if(cooki.getName().equals("user"))
		{
			email=cooki.getValue();
			is_user_cookie=true;
		}	
		if(cooki.getName().equals("name"))
		{
			name=cooki.getValue();
		}
	}

	if(!is_user_cookie)
	{
 		response.sendRedirect("login.jsp");
 		return;
	}
	UserDao user_dao=new UserDao();
	User user_=new User();
	user_.setEmail(email);
	if(!user_dao.UserExists(user_))
	{
		response.sendRedirect("login.jsp");
	}
%>

<header >	
<nav class="navbar navbar-expand-lg" style="background-color:#e3f2fd;">
  <div class="container-fluid">
    <a class="navbar-brand" href="#"><img src="./images/Romance-Silhouette.svg" style="height:4rem;"></img></a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="flames.jsp">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="logout" style="cursor:pointer;">Logout</a>
        </li>  
		<li class="nav-item" style="display: none" id="profile">
			<a class="nav-link" href="profile" style="cursor:pointer;" id="profile-a" href="/profile.jsp" style="display:inline-block;"><i class="fa fa-cog" aria-hidden="true" style="display: inline-block;"></i> </a>
		  </li>  
  </div>
  </div>
</nav>
</header>
<script>
	 if (document.cookie) {
    const values = document.cookie.split(";");
    for (let value of values) {
        let name = value.split("=");

        if (name[0].trim() === "name") {
            if (name[1])
			{
				document.getElementById("profile-a").innerHTML+=name[1];
				document.getElementById("profile").style.display="";
			}
        }
    }
}
</script>
</body>
</html>