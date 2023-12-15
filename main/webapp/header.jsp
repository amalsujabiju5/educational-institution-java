<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN""http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">

<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

	<head>

		<link rel="stylesheet" href="./css/everything.css" type="text/css" />

		<%@ page import = "java.util.*" %>
		<%@ page import = "webd4201sujaa.*"%>

		<%    
			// Student aStudent = (Student)session.getAttribute("student");
			String message = (String)session.getAttribute("message");
			
			if(message == null)
				message="";
		%>		

		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

		

	</head>

	<body>

	<nav class="navbar navbar-default">
	        <div class="container-fluid">
	          <div class="navbar-header">
	            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
	              <span class="sr-only">Toggle navigation</span>
	              <span class="icon-bar"></span>
	              <span class="icon-bar"></span>
	              <span class="icon-bar"></span>
	            </button>
	            <a class="navbar-brand">Durham College</a>
	          </div>
	          <div id="navbar" class="navbar-collapse collapse">
	            <ul class="nav navbar-nav">
	              <li><a href="./index.jsp">Home</a></li>
	              <li><a href="./register.jsp">Register</a></li>
	              <li><a href="./login.jsp">Log In</a></li>

	            </ul>
	          </div>
	        </div>
	      </nav>

	     