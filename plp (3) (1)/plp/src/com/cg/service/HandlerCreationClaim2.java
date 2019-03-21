package com.cg.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.dao.Conn;

public class HandlerCreationClaim2 extends HttpServlet{
	
	RequestDispatcher rd=null;
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
	
		
	
		String uname=req.getParameter("username1");
	
		
		try{
			
		 Conn c1=new Conn();
		 ResultSet rs=null;
		int seq=0;
		 Connection c=c1.getCon();
		 
		 
		 String sql="select rolecode from userrole where username='"+uname+"'";
		 Statement stmt=c.createStatement();
		 int i=stmt.executeUpdate(sql);
		 System.out.println(i);
		 rs=stmt.executeQuery(sql);
		 String str=null;
		 if(i==1) {
		while(rs.next())
		{
			str=rs.getString(1);
			System.out.println(str);
		}
		if(str.equals("insured"))
		{
			rd=req.getRequestDispatcher("/Claimcreation2.jsp");
			rd.forward(req, res);
		}
		
		if(str.equals("admin")||str.equals("agent"))
		{
			rd=req.getRequestDispatcher("/InvalidClaimCreationName.jsp");
			rd.forward(req, res);
		}}
		 else
		 {
			 rd=req.getRequestDispatcher("/InvalidClaimCreationName.jsp");
				rd.forward(req, res);
		 }
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}

}
}
