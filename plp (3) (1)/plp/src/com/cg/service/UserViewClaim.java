package com.cg.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserViewClaim extends HttpServlet{
	
	RequestDispatcher rd=null;
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
	
	System.out.println("hello");
		
		
		rd=req.getRequestDispatcher("/ViewClaim.jsp");
		rd.forward(req, res);
		
		


}
	}
