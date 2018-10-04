<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel = "stylesheet" type="text/css" href = "/company_management/style.css" />
<title>Login</title>
</head>
<body>
<div id="wrapper">
<div id="header">
<h1 id="h1Wrapper">Welcome to Campus Rent A Car</h1>
We offer car rental services to UTA students and faculties.
<hr><br><br>
</div>
<div id="horizontalLinks">
<a href="Register.jsp">Register</a>
<a href="Index.jsp">Login</a>
</div>

<div id="main">
<form name="Login" action="Login" method="post" >

<h2>Enter Your User Name and Password.</h2>
<table>

<tr>
<td> User Name (*): </td> 
<td> <input name="user_name" value="<c:out value='${UserModel.user_name}'/>" > </td>
</tr>
<tr>	
<td> Password (*): </td>
<td> <input name="password" value="<c:out value='${UserModel.password}'/>" > </td>
</tr>
 <tr>
 <td colspan="2">(*) Mandatory field</td>
 </tr>
</table>
<!-- <p><input name="action" value="verifySystemUser" type="hidden">
<input name="submit" type="submit" value="verifySystemUser"></p> -->
<p><input name="action" value="verifySystemUser" type="hidden">
<input name="submit" type="submit" value="submit"></p>
</form>

<p><a href="http://localhost:8080/company_management/Register.jsp">New user first time login?</a></p>
</div>
<div id="footer">
University of Texas at Arlington <br>
CSE 6329-001 Class Project, Fall 2018 <br>
Team 3 <br>
</div>
</div>
</body>
</html>