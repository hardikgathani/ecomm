package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbo.DataService;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    	System.out.println("inside constructor");
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		RequestDispatcher rd = request.getRequestDispatcher("/web/jsp/index.jsp");
		PrintWriter out = response.getWriter();
		
		String loginQuery = "select password from user where username='"+username+"'";
		boolean empty=true;
		try 
		{
			ResultSet rs = DataService.getResultSet(loginQuery);
			System.out.println("before rs");
			
			while(rs.next())
			{
				empty=false;
				String fetchedPassword = rs.getString("password");
				if(fetchedPassword.equals(password))
				{
					System.out.println("successful Login");
					request.setAttribute("message","you have been successfully registered");
					rd.forward(request, response);
				}
				else
				{
					//System.out.println("Incorrect Password");
					out.println("Incorrect Password");
				}
			}
			if(empty)
			{
				//System.out.println("Invalid Username");
				out.println("Invalid Username");
			}
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
