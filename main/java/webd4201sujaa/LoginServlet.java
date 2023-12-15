package webd4201sujaa;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static Student aStudent;
	/**
	 * The information entered by user is authenticated in post mode
	 */
       
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException
	    {
		   	  
		 
	        try
	        { 
	            // connect to database
	            Connection c = DatabaseConnect.initialize();
	            Student.initialize(c);
	            User.initialize(c);
	            HttpSession session = request.getSession(true);
	            StringBuffer errorBuffer = new StringBuffer();
	            
	            String login = new String();
	            long possibleId = 0;
	            
	            String password = new String();
	            
	            try 
	            {   // retrieve data from DB
	            	login = request.getParameter("username"); // name of the text input box on the form
	                password = request.getParameter("password");// name of password input box on form
	                possibleId = Long.parseLong(login);
	                aStudent = new Student();	                
	                String strongPassword = aStudent.encryptPassword(password);
	   
	                Student aStudent = StudentDA.authenticate(possibleId, strongPassword); //attempt to find the Customer
	                // if the Customer was found and retrieved from the db
					//put the found Customer onto the session
	                session.setAttribute("student", aStudent);
					//empty out any errors if there were some
	                session.setAttribute("errors", "");
	                
	                // redirect the user to a dashboard
	                response.sendRedirect("./dashboard.jsp");                 
	                
	                
	            } catch( NumberFormatException nfe)
	            {
	                
	                errorBuffer.append("<strong>Student ID must only contain numeric characters, you entered: " + login +".<br/>");
	                errorBuffer.append("Please try again.</strong>");
	                session.setAttribute("login", "");
	                
	                session.setAttribute("errors", errorBuffer.toString());
	                response.sendRedirect("./login.jsp");
	            
	           
	           
	            }catch( NotFoundException nfe)
	            {
	                
	                //sending errors to the page through the session
	                errorBuffer.append("<strong>Your sign in information is not valid.<br/>");
	                errorBuffer.append("Please try again.</strong>");
	                try{
	                    Student.retrieve(possibleId);
	                    session.setAttribute("login", login);
	                }catch(NotFoundException nfe2)
	                {
	                  session.setAttribute("login", "");
	                }
	                session.setAttribute("errors", errorBuffer.toString());
	                response.sendRedirect("./login.jsp");
	           
	           
	            }             
        	} catch (Exception e) //not connected
	        {
	            System.out.println(e);
	            String line1="<h2>A network error has occurred!</h2>";
	            String line2="<p>Please notify your system " +
	                                                    "administrator and check log. "+e.toString()+"</p>";
	            formatErrorPage(line1, line2,response);
	        }
    }
	    
	    /**
	     * 
	     * Call the doPost method when data is obtained from the login.jsp 
	     * form.  
	     * 
	     * @param request HTTP request
	     * @param response HTTP response
	     * @throws ServletException if there was general servlet error encountered
	     * @throws IOException if there was an InputOutput error encountered
	     */
	    public void doGet(HttpServletRequest request,
	                            HttpServletResponse response)
	                                    throws ServletException, IOException {
	        doPost(request, response);
	    }

	    /**
	     * 
	     * Print out messages in a specific format.
	     * 
	     * @param first takes a string args
	     * @param second takes a string args
	     * @param response HTTP response
	     * @throws IOException if a general InputOuput was encountered
	     */
	    public void formatErrorPage( String first, String second,
	            HttpServletResponse response) throws IOException
	    {
	        PrintWriter output = response.getWriter();
	        response.setContentType( "text/html" );
	        output.println(first);
	        output.println(second);
	        output.close();;
	    }

}