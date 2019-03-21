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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script>

</script>
<body>
<form action="genreport">
<%

try{String s[]=new String[5]; %>
	<%PrintWriter out1=response.getWriter();%>
	<% Conn c1=new Conn();%>
	<% ResultSet rs=null;%>
	<% Connection c=c1.getCon();%>
	<%String ctype=null; %>
	<% String sql="select question from questions where claimtype='"+request.getParameter("domain")+"'";%>
	<% Statement stmt=c.createStatement();%>
	<%rs=stmt.executeQuery(sql); %>
	<h1 align="center"><u>Answer Some 	Questions Related To The Claim</u></h1>
	<table border="1" algin="center">
	<% while(rs.next()) {%>
	                    
	<tr>
		<td><%=rs.getString(1) %></td>
		<td><input type="radio" name="<%=rs.getString(1) %>" id="<%=rs.getString(1) %>" value="yes">YES</td>
		<td><input type="radio" name="<%=rs.getString(1) %>" id="<%=rs.getString(1) %>" value="no">NO</td></tr>
		
		<% }%>
	</table>
		
			<input type="submit" name="report" value="generate report">
	<% }

		
	catch(Exception e)
	{
		System.out.println(e);
	}%>
	</form>
	
	
     
   
    
      
           
     

  

</body>
</html>