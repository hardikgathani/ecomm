package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbo.DataService;


public class RegisterUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fName = request.getParameter("fName");
		String lName = request.getParameter("lName"); 
		String username = request.getParameter("userName");
		String password = request.getParameter("password");
		String email = request.getParameter("userEmail");
		
		PrintWriter out = response.getWriter();
		//RequestDispatcher rd = request.getRequestDispatcher("/web/jsp/success.jsp");
		
		String registerUserQuery = "insert into user (username,password,firstname,lastname,user_type_id,email) values ('"+username+"','"+password+"','"+fName+"','"+lName+"','1','"+email+"')";
		
		//DataService ds = new DataService();
		try 
		{
			DataService.runQuery(registerUserQuery);
			//request.setAttribute("message","you have been successfully registered");
			//rd.forward(request, response);
			out.println("You have been successfully registered.");
			out.flush();
			return;
		}
		catch (SQLException e) 
		{
		
			e.printStackTrace();
		}
	}

}
