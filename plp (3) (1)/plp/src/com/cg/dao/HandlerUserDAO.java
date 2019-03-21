package com.cg.dao;

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

public class HandlerUserDAO  extends HttpServlet{
	
	RequestDispatcher rd=null;
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
	
		HttpSession session2=req.getSession(false);
		String s1=(String) session2.getAttribute("username1");
		try{
			
		 Conn c1=new Conn();
		 ResultSet rs=null;
		int seq=0;
		 Connection c=c1.getCon();
		 
		 
		 String sql="select rolecode from userrole where username='"+s1+"'";
		 Statement stmt=c.createStatement();
		 rs=stmt.executeQuery(sql);
		 String str=null;
		while(rs.next())
		{
			str=rs.getString(1);
		}
		if(str.equals("insured"))
		{
			rd=req.getRequestDispatcher("/AgentViewClaim.jsp");
			rd.forward(req, res);
		}
		
		
		
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}

}
}
