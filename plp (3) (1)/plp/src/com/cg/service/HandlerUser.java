package com.cg.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.dao.HandlerUserDAO;

public class HandlerUser  extends HttpServlet{
	
	RequestDispatcher rd=null;
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
	
	String uname=req.getParameter("username1");
	HttpSession session2=req.getSession();
	session2.setAttribute("username1",uname);
		HandlerUserDAO obj=new  HandlerUserDAO();
		obj.doGet(req, res);
		
		
		
	}

}