package webd4201sujaa;
import java.io.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;
/**
 * @author AMAL SUJA BIJU
 * @date March 12 2023
 */
/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/Logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(true);
        
        //retrieve the session (or start)   
        session.removeAttribute("student"); 
        
        //remove the object stored at login
        //give an informational message
        session.setAttribute("message", "You have successfully logged out");      
        
        // redirect to login.jsp
        response.sendRedirect("./login.jsp");  
    } 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	 public void doPost(HttpServletRequest request, HttpServletResponse response) 
	            throws ServletException, IOException {
	        
	        HttpSession session = request.getSession(true); //retrieve the session (or start)       
	        
	        session.removeAttribute("student"); //remove the object stored at login
	        
	        session.setAttribute("message","You have successfully logged out"); //give an informational message
	        
	        response.sendRedirect("./login.jsp");  //redirect to login.jsp
	    }
}
