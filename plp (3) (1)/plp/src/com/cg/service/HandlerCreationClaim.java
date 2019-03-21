package com.cg.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.cg.dao.HandlerUserDAO;

public class HandlerCreationClaim extends HttpServlet{
	

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		RequestDispatcher rd=null;
		
		rd=req.getRequestDispatcher("/HandlerClaimCreationUser.jsp");
		rd.forward(req, res);
		
		
		
	}

}

