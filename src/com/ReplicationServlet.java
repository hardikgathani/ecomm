package com;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbo.DataService;


public class ReplicationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ReplicationServlet() {
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String insertReplication = "insert into bhojal(id) values(8);";
		
		try
		{
			DataService.runQuery(insertReplication);
		} 
		catch (SQLException e) 
		{
		
			e.printStackTrace();
		}
	
	}

}
