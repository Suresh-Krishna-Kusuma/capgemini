<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
 

<div >
<h1 align="center"style="color:black"> Welcome Insured </h1>
 
 <form action="claimcreation">
 <table border="1" align="center">
<tr><td><select name="domain" id="domain" required>
			<option value="domain">-Claim Type-
			<option value="hotel">HOTEL
			<option value="shop">SHOP
			<option value="pg">PG
			</select></td>
 <td><input type="submit" class="btn" value="Claim Creation" ></td></tr><br>
 

<br><br>
</form>
</table>


<form action="viewclaim">
<input type="submit" class="btn" value="View Claim" >
</form>

 

 


 
 </center>
</body>
</html>