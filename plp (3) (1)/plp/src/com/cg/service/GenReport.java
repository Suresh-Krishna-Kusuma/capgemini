package com.cg.service;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class GenReport extends HttpServlet{
	
	RequestDispatcher rd=null;
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
	
	
		
		
		rd=req.getRequestDispatcher("/Report.jsp");
		rd.forward(req, res);
		
		
	}

}
