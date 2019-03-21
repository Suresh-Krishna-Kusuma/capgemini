package com.cg.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserClaim  extends HttpServlet{
	
	RequestDispatcher rd=null;
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
	
	System.out.println("hiii");
		
		
		rd=req.getRequestDispatcher("/Claimcreation2.jsp");
		rd.forward(req, res);
		
		


}
	}
