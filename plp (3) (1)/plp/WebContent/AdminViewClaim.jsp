<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="AdminViewClaim">

ADMIN VIEW CLAIM
<table border="1">
<tr style="background-color:green">
<th><b>username</b></th>
<th><b>Claim Number</b></th>
<th><b>Claim Type</b></th>
<th><b>Policy Number</b></th>
</tr>
<%
try{
 ClaimBean cbean=new ClaimBean();
 Conn c1=new Conn();
 ResultSet rs=null;
 int seq=0;
 Connection c=c1.getCon();
 HttpSession session1=request.getSession(false); 
 String s=(String) session1.getAttribute("username");
 String sql="select * from viewclaim";
 Statement stmt=c.createStatement();
 rs=stmt.executeQuery(sql);
 while(rs.next())
 {%><tr>
    <td><%=rs.getString(1)%></td>
	<td><%=rs.getString(2)%></td>
	<td><%=rs.getString(3)%></td>
	<td><%=rs.getString(4)%></td>
	</tr>
<% }
}
catch(Exception e)
{
	e.printStackTrace();
}

%>




</table>
</form>
</center>
</body>
</html>