<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="s" uri="/struts-tags" %>
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<title>Flames</title>
			<link rel="stylesheet" href="flames.css">
			<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
				integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
				crossorigin="anonymous">
			<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"
				integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm"
				crossorigin="anonymous" />

			<s:head />
		</head>

		<body>
			<%@ include file="header.jsp" %>
				<section>
					<div style="display: none; justify-content: center; align-items: center; margin-left: 2rem; margin-top: 2rem;"
						class="alert alert-success alert-dismissible fade show container" id="message" role="alert">
						<span id="display"></span>
						<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
					</div>
					<div style="position:relative;">
						<div class="love-tips">
							<h1 style="margin-bottom:1rem; display: inline-block;">Love Tips</h1>
							<button class="btn btn-secondary response-btn" style="margin-left: 1rem;"
								onclick="showFlamesForm(event)">FLAMES</button>
							<ul>
								<li class="list">
									Never take your partner for granted
								</li>
							</ul>
							<ul>
								<li class="list">
									Marry someone you not only love but truly like
								</li>
							</ul>
							<ul>
								<li class="list">
									Find someone who is different from you
								</li>
							</ul>
							<ul>
								<li class="list">
									Take note when your partner mentions something they want, and buy it as a present
									for them
								</li>
							</ul>
							<ul>
								<li class="list">
									After you get to the end of a day together, tell your partner the things you liked
									most about the day together
								</li>
							</ul>
							<ul>
								<li class="list">
									Come up from behind your partner while they're doing something and wrap your arms
									around them
								</li>
							</ul>
							<ul>
								<li class="list">
									Compliment your partner often
								</li>
							</ul>
							<ul>
								<li class="list">
									Bring back souvenirs for them when you come back from trips so they know you were
									thinking about them
								</li>
							</ul>
							<ul>
								<li class="list">
									When they're talking to you, really listen—put away any tech, make eye contact, and
									fully engage in the conversation
								</li>
							</ul>
						</div>
						<div class="card container flames-form"
							style="background-color:rgba(255, 0, 0, 0.473)!important;">
							<button id="close" style="text-align: end; display: none; "
								onclick="(event)=>{close(event)}"><i class="fa fa-window-close" aria-hidden="true"
									style="color:turquoise; font-size:2rem;"></i></button>
							<div class="form">
								<s:form action="flames" onsubmit="calculateHandler(event)">
									<s:label label="Your Name" />
									<s:textfield name="name" id="name" class="form-control"
										style="margin-bottom: 3rem;"></s:textfield>
									<s:label label="Your Crush Name" />
									<s:textfield name="crush_name" class="form-control" style="margin-bottom: 3rem;">
									</s:textfield>
									<s:submit value="Calculate" class="btn btn-secondary"></s:submit>
								</s:form>
							</div>
						</div>
					</div>
				</section>
				<s:if test="actionError!=null&&actionError.size>0">
					<script>
						let res = "";
						<s:iterator value="actionError">
							res+='<s:property />\n'
						</s:iterator>
						alert(res);
					</script>
				</s:if>

				<s:if test="actionMessages!=null&&actionMessages.size>0">
					<script>
						let actionMessages = "";
						<s:iterator value="actionMessages" >
							actionMessages += '<s:property />';
						</s:iterator>
						const name = document.getElementsByName("name")[0].value.fontcolor("blue");
						const crush_name = document.getElementsByName("crush_name")[0].value;
						document.getElementById("message").style.display = "inline-block";
						document.getElementById("display").innerHTML = `<p>The relationship between <span style="color:red;">${name}</span> and <span style="color:red;">${crush_name}</span> is ${actionMessages}</p>`;
					</script>
				</s:if>
				<script src="flames.js" type="text/javascript"></script>
				<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
					integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
					crossorigin="anonymous"></script>

		</body>

		</html>