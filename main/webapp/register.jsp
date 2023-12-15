<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>


</head>

<%
String Id = (String)session.getAttribute("ID");
String firstName = (String)session.getAttribute("FirstName");
String lastName = (String)session.getAttribute("LastName");
String programCode = (String)session.getAttribute("ProgramCode");
String programDescription = (String)session.getAttribute("ProgramDescription");
String email = (String)session.getAttribute("Email");

if (Id == null)
	Id = "";

if (firstName == null)
	firstName = "";

if (lastName == null)
	lastName = "";

if (programCode == null)
	programCode = "";

if (programDescription == null)
	programDescription = "";

if (email == null)
	email = "";

%>


<% String title = "Register"; %>
<%@ include file = "./header.jsp" %>
<%
	Student aStudent = (Student)session.getAttribute("student");
	String errors = (String)session.getAttribute("errors");

	if(!(aStudent == null))
	{
		session.setAttribute("message", "Please log off to register as another Student.");
		response.sendRedirect("./dashboard.jsp");
	} else {
		session.setAttribute("message", "");	
		session.setAttribute("errors", "");
}	


%>
<body>
<div class="container">

<h1><%= message %></h1>

<div class="row">

    <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">

		<form role="form" name="Input" method="post" action="./Register">

			<h2>Student Registration</h2>

			

			<hr class="colorgraph">

			<!-- Student ID -->
			<div class="row">

				<div class="col-xs-12 col-sm-15 col-md-15">

					<div class="form-group">

						<input type="text" name="ID" value = "<%= Id %>" class="form-control input-lg" placeholder="Student ID" tabindex="1">

					</div>

				</div>

			</div>
			
			<!-- First Name and Last Name -->
			<div class="row">
			
				<div class="col-xs-12 col-sm-6 col-md-6">
			
					<div class="form-group">
            
                        <input type="text" name="FirstName" value="<%= firstName %>" class="form-control input-lg" placeholder="First Name" tabindex="2">
			
					</div>
			
				</div>
			
				<div class="col-xs-12 col-sm-6 col-md-6">
			
					<div class="form-group">
			
						<input type="text" name="LastName" value="<%= lastName %>" id="last_name" class="form-control input-lg" placeholder="Last Name" tabindex="3">
			
					</div>
			
				</div>
			
			</div>

			<!-- Program Code and Program Description -->
			<div class="row">
			
				<div class="col-xs-12 col-sm-6 col-md-6">
			
					<div class="form-group">
            
                        <input type="text" name="ProgramCode" value="<%= programCode %>" class="form-control input-lg" placeholder="Program Code" tabindex="4">
			
					</div>
			
				</div>
			
				<div class="col-xs-12 col-sm-6 col-md-6">
			
					<div class="form-group">
			
						<input type="text" name="ProgramDescription"  value="<%= programDescription %>" id="last_name" class="form-control input-lg" placeholder="Program Description" tabindex="5">
			
					</div>
			
				</div>
			
			</div>

			
			
			<div>
				<div class="form-group">
				
					<input type="email" name="Email" id="email" class="form-control input-lg" placeholder="Email Address" tabindex="6">
				
				</div>
			</div>
			
			<div class="row">
			
				<div class="col-xs-12 col-sm-6 col-md-6">
			
					<div class="form-group">
			
						<input type="password" name="Password" id="password" class="form-control input-lg" placeholder="Password" tabindex="7">
			
					</div>
			
				</div>
			
				<div class="col-xs-12 col-sm-6 col-md-6">
			
					<div class="form-group">
			
						<input type="password" name="ConfirmPassword" id="password_confirmation" class="form-control input-lg" placeholder="Confirm Password" tabindex="8">
			
					</div>
			
				</div>
			
			</div>
			
			<hr class="colorgraph">
			
			<div class="row">
			
				<div class="col-xs-12 col-md-6"><input type="submit" value="Register" class="btn btn-primary btn-block btn-lg" tabindex="9"></div>
			
				<div class="col-xs-12 col-md-6"><a href="./login.jsp" class="btn btn-success btn-block btn-lg" tabindex="10">Go Back to Login Page</a></div>
			
			</div>
		
		</form>
	
	</div>

</div>
<script type="text/javascript">

function validateField(type, id) {
    var value = document.forms["Input"][id].value;
    if (value == "") {
        var fieldName = id.charAt(0).toUpperCase() + id.slice(1);
        alert("Please enter your " + fieldName + ".");
        return false;
    }
    return true;
}

//Overall validation function
function validateForm() {
    if (!validateField("Id", "ID")) {
        return false;
    }
    if (!validateField("FirstName", "FirstName")) {
        return false;
    }
    if (!validateField("LastName", "LastName")) {
        return false;
    }
    if (!validateField("ProgramCode", "ProgramCode")) {
        return false;
    }
    if (!validateField("ProgramDescription", "ProgramDescription")) {
        return false;
    }
    if (!validateField("Email", "Email")) {
        return false;
    }
    if (!validateField("Password", "Password")) {
        return false;
    }
    if (!validateField("ConfirmPassword", "ConfirmPassword")) {
        return false;
    }
    return true;
}
function validateInput(type, id) {
    var input = document.forms["Input"][id].value;
    if (input == "") {
        alert("Please enter your " + type + ".");
        return false;
    }
    return true;
}

function validateConfirmPassword() {
    var confirmPassword = document.forms["Input"]["ConfirmPassword"].value;
    var password = document.forms["Input"]["Password"].value;
    if (confirmPassword == "") {
        alert("Please confirm your password.");
        return false;
    }
    if (confirmPassword != password) {
        alert("Your passwords do not match.");
        return false;
    }
    return true;
}

function validateForm() {
    var fieldsToValidate = {
        "Student ID": "ID",
        "First Name": "FirstName",
        "Last Name": "LastName",
        "Program Code": "ProgramCode",
        "Program Description": "ProgramDescription",
        "Email": "Email",
        "Password": "Password"
    };
    for (var type in fieldsToValidate) {
        var id = fieldsToValidate[type];
        if (!validateInput(type, id)) {
            return false;
        }
    }
    if (!validateConfirmPassword()) {
        return false;
    }
    return true;
}



</script>

</body>
</html>