package com.cg.service;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.bean.ClaimBean;
import com.cg.controller.Conn;
import com.cg.dao.ClaimDao;
public class Ques extends HttpServlet{

	ClaimBean cbean=new ClaimBean();
	PreparedStatement pst=null;
	ResultSet rs=null;
	RequestDispatcher rd=null;
	ClaimDao obj=new ClaimDao();
	Connection c=null;
	Conn c1=new Conn();
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
	
		cbean.setCreason(req.getParameter("claim reason"));
		String ctype=req.getParameter("domain");
		cbean.setAlocation(req.getParameter("accident location"));
		cbean.setAcity(req.getParameter("accident city"));
		cbean.setAstate(req.getParameter("accident state"));
		int zip=Integer.parseInt(req.getParameter("accident zip"));
		cbean.setZip(zip);
		cbean.setCtype(req.getParameter("domain"));
		ClaimDao obj1=new ClaimDao();
		try {
		c=c1.getCon();
		HttpSession session1=req.getSession(false); 
		Statement stmt=c.createStatement();
	 	String s=(String) session1.getAttribute("username");
	 	String sql3="select claimnum.nextval from dual";
	 	ResultSet rs2=stmt.executeQuery(sql3);
	 	int seq=0;
	
		while(rs2.next()) {
			seq=rs2.getInt(1);
		}
		String sql4="select policynum.nextval from dual";
	 	ResultSet rs3=stmt.executeQuery(sql4);
	 	int seq1=0;
	
		while(rs3.next()) {
			seq1=rs3.getInt(1);
		}
		
		
		String sql="insert into claim values ("+(seq-1)+",?,?,?,?,?,?,"+(seq1-1)+")";
		String sql2="insert into viewclaim values('"+s+"',"+(seq-1)+",'"+cbean.getCtype()+"',"+(seq1-1)+")";
	
		stmt.executeQuery(sql2);
		pst=c.prepareStatement(sql);
		pst.setString(1,cbean.getCreason());
		pst.setString(2,cbean.getAlocation());
		pst.setString(3,cbean.getAcity());
		pst.setString(4,cbean.getAstate());
		pst.setInt(5,zip);
		pst.setString(6,cbean.getCtype());
		pst.executeQuery();
		obj1.doGet(req, res);
		
	 	System.out.println(session1.getAttribute("username"));
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
