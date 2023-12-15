<!-- 
Created By: AMAL SUJA BIJU
Date : March 09 2023 -->


<html>
<head>
    <title>Log In </title>
    <style>
    body{
        font-family: Arial;
    }
    </style>
</head>
<%@ page import = "webd4201sujaa.*" %>
<%   String errorMessage = (String)session.getAttribute("login"); 
	String login = (String)session.getAttribute("errors");
	
	if(errorMessage == null)
	{
		errorMessage="";
	}
	
	String Login =(String)session.getAttribute("id");
	String password=(String)session.getAttribute("password");
	if(login == null)
		login = "";
	
%>

<%@ include file = "./header.jsp" %>
<body>
	<h1 style="text-align:center;"><span style="color: red;">WEBD4201  </span></h1>
	<hr/>
	<table style="width: 80%;margin-left:auto; margin-right:auto;"><tr><td>
	<img src = "images/itimages1.png">
	<img src = "images/itimages2.png">
	<img src = "images/itimages3.png">
	<img src = "images/itimages4.png">
	<img src = "images/itimages5.png">
	<img src = "images/itimages6.png">
	<img src = "images/itimages7.png">
	<img src = "images/itimages8.png">
	<img src = "images/itimages9.png">
	<img src = "images/itimages10.png">
    </td></tr></table>
    <hr/>
    
	<div style="text-align: center;">
	<h2>Please log in</h2>
	<p>Enter your login information below.<br>
	   If you are not a customer, please return to the
	   <a href="index.html">Durham college</a> home page.</p>
	<p>
	   If you want to become a Durham college student, please <a href="register.jsp">register</a>.</p>
	<form method="post" action="./Login" >
		<table border="0" style="background-color: lightgoldenrodyellow;margin-left:auto; margin-right:auto;" cellpadding="10" >
		<tr><td colspan="2" align="center"><%= errorMessage %></td></tr>
		<tr>
			<td><strong>Login Id</strong></td>
			<td><input type="text" name="Login" value="<%= login %>" size="20"><br/></td>
			
			<tr>
	        <td><strong>Password</strong></td>
			<td><input type="password" name="Password"  size="20"><br/></td>
			         
					
			</tr>
		</tr>
		</table>
		<table style="margin-left:auto; margin-right:auto;" border="0" cellspacing="25" >
		<tr>
			<td><input type="submit" value = "Log In"></td><br/>
			
			<td><input type="reset" value = "Clear"></td>
		</tr>
		</table>
	</form>
	Please wait after pressing <strong>Log in</strong>
	while we retrieve your records from our database.<br>
	<em>(This may take a few moments)</em>
	</div>
	
	
</body>
</html>


<%@ include file = "./footer.jsp" %>