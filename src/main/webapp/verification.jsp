<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<s:head/>
<head>
<meta charset="UTF-8">
<title>Flames</title>
<link rel="stylesheet" href="verify.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
	
    <s:actionmessage/>
	<div class="card" style="width: 25rem; height:25rem; margin-left:50rem; margin-top:20rem;">
  <div class="card-body">
    <h5 class="card-title" style="padding-left:7rem;">Verification</h5>
    <h5 style="padding-left:2rem;color:red;" id="err_msg"></h5>
<s:form class="container" action="verification">
<s:actionerror/>
  <div  class="form-group" style="margin-top:5rem;">
		<s:textfield class="form-control" placeholder="Email" value="%{email}" name="email"> </s:textfield>
		</div>
     <div  class="form-group" style="margin-top:5rem;">
		<s:textfield class="form-control" placeholder="Verification code" name="code"></s:textfield>
		</div>
		<s:submit class="btn btn-primary" style="margin-top:2rem;" onsubmit="validateCode(event)"></s:submit>
	</s:form>
	
  </div>
</div>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script src="verify.js"> </script>
</body>
</html>