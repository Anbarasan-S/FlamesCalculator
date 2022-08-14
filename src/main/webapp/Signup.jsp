<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Flames Application</title>
<style>
</style>
<s:head/>
</head>
<body>
<s:actionerror/>
		<s:form id="form" action="signup" theme="xhtml">
			<s:textfield name="name"  label="Name" placeholder="John"></s:textfield>
			<s:textfield name="email"  label="Email" placeholder="johndoe@gmail.com" type="email"></s:textfield>
		    <s:password  name="password" label="Password" placeholder="Password" ></s:password>
			<s:password  name="re_type_password"  label="Re-Type Password" placeholder="Re-Type Password"></s:password>
			<s:submit   value="SIGN UP" style="margin-left:5rem; margin-top:3rem; text-align:center;" class="btn btn-primary"></s:submit>
		</s:form>
</body>
<script src="signup.js">
</script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
</html>