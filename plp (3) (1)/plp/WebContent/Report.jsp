<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@page import= "java.io.*"%>
<%@page import= "java.sql.*"%>
<%@page import= "java.sql.ResultSet"%>
<%@page import= "java.sql.PreparedStatement"%>

<%@page import= "javax.servlet.*"%>
<%@page import= "javax.servlet.http.HttpServlet"%>
<%@page import= "javax.servlet.http.HttpServletRequest"%>
<%@page import= "javax.servlet.http.HttpServletResponse"%>
<%@page import= "com.cg.controller.Conn" %>
<%@page import= "com.cg.service.Ques" %>
<%@page import= "com.cg.dao.Quesdispatch" %>
<%@page import="java.util.*"%>
<%@ page import="com.cg.bean.ClaimBean" %>
<%@ page import="com.cg.service.GenReport" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
try{ClaimBean cbean=new ClaimBean();
String s[]=new String[5];

s[0]=request.getParameter("Were you present when the accident happened?");
s[1]=request.getParameter("Was the incident reported to police?");
s[2]=request.getParameter("Did you already know something about the problem");
s[3]=request.getParameter("Were the fire alarms working?");
s[4]=request.getParameter("Any casualties");
 Conn c1=new Conn();
 ResultSet rs=null;
 ResultSet rs1=null;
 ResultSet rs2=null;
 ResultSet rs3=null;
int seq=0;
 Connection c=c1.getCon();
String ctype=null; 
String sql3="select claimnum.nextval from dual";
String sql2="select claimnum.currval from dual";
Statement stmt3=c.createStatement();
Statement stmt2=c.createStatement();

rs2=stmt2.executeQuery(sql2);
while(rs2.next()) {
	seq=rs2.getInt(1);
}
System.out.println(seq);
 String sql="select * from claim where claimnumber="+(seq-1);
 Statement stmt=c.createStatement();
 rs=stmt.executeQuery(sql);%>
 <table border="1" align="center">
<%while(rs.next()) {%>
 
 <tr>
		<td>ClaimReason</td>
		<td><%=rs.getString(2) %></td></tr>
		<tr>
		<td>AccidentLocation</td>
		<td><%=rs.getString(3) %></td></tr>
		<tr>
		<td>AccidentCity</td>
		<td><%=rs.getString(4) %></td></tr>
		<tr>
		<td>AccidentState</td>
		<td><%=rs.getString(5) %></td></tr>
		<tr>
		<td>AccidentZip</td>
		<td><%=rs.getString(6) %></td></tr>
		<tr>
		<td>ClaimType</td>
		<td><%=rs.getString(7)
		%>	<%String claimType=rs.getString(7); %></td></tr>
	
		
		
		<% }%>
	
		
			
 
	 
<% 


int i=0;
String sql1="select question from questions where claimtype='shop'";
Statement stmt1=c.createStatement();
rs1=stmt1.executeQuery(sql1);
while(rs1.next()&&i<5) {%>
	
	
	<tr>
		<td><%=rs1.getString(1) %></td>
		<td><%=s[i] %></td></tr>
		
		
		
		
		
		
<% i++;}%>
</table>
<%}
catch(Exception e)
{
	System.out.println(e);}
%>
</body>
</html>