<% String title = "Dashboard"; %>

<%@ include file = "./header.jsp" %>

<%@ page import = "webd4201sujaa.*" %>

<%

	
	Student aStudent = (Student)session.getAttribute("student");
	if (aStudent == null) { response.sendRedirect("./login.jsp"); }
	else {
	%>
		<%    
			
			String message = (String)session.getAttribute("message");
			
			if(message == null)
				message="";
	
		%>	
	
	
	<jsp:include page="./header.jsp">
		<jsp:param name="title" value="Student Dashboard" />
	</jsp:include>
		
		<div id="contentContainer">
			<h2>Welcome <%= aStudent.getFirstName() + ' ' + aStudent.getLastName() %></h2>
			<p>The current date and time is: <%= new java.util.Date() %></p>
			<p>You are successfully  logged in!</p>
			<p style="color: red;"><%= message %></p>
			
		</div>
	
		<jsp:include page="./footer.jsp">
			<jsp:param name="footerTitle" value="User Dashboard" />
		</jsp:include>
		<% } %>
</div>

</body>
</html>