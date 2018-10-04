<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel = "stylesheet" type="text/css" href = "/company_management/style.css" />
<title>Manager HomePage</title>
</head>
<body>
<div id="wrapper">
<div id="header">
<h1 id="h1Wrapper">Campus Rent A Car</h1>
We offer car rental services to UTA students and faculties. Store Hours: M-F 8AM-8PM, Sa 8AM-5PM, Su Noon-5PM.
<hr><br><br>
</div>
<div id="horizontalLinks">

<a href="EditMyProfile.jsp">Edit My Profile</a>
<a href="Logout">Logout</a>
</div>

<div id="main">
<h2>Welcome to Manager HomePage</h2>
<br>
<p><a href="http://localhost:8080/company_management/ShowAllSystemUsersProfile.jsp">View calendar </a> <br>
You could delete a reservation from <a href="http://localhost:8080/company_management/ShowAllSystemUsersProfile.jsp">here </a> <br>
You could view all available vehicles from <a href="http://localhost:8080/company_management/ShowAllSystemUsersProfile.jsp">here </a><br>
You could add a new vehicle from <a href="http://localhost:8080/company_management/NewCar.jsp">here </a> <br>
You could view rental details from <a href="http://localhost:8080/company_management/ShowAllSystemUsersProfile.jsp">here </a><br>


</p>
</div>

<div id="footer">
University of Texas at Arlington <br>
CSE 6329-001 Class Project, Fall 2018 <br>
Team 3 <br>
</div>
</div>
</body>
</html>