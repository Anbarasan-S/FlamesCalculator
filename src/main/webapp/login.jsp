<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Basic Struts 2 Application - Welcome</title>
  </head>
  <s:head/>
  <body>
  <s:actionmessage/>
  <s:actionerror/>
   <s:form action="login"> 
   	   <s:textfield name="email"  placeholder="Email"></s:textfield>
   		<s:password name="password" placeholder="Password"></s:password>
   		<s:submit value="SIGN IN"></s:submit>
   </s:form>
  </body>
</html>
