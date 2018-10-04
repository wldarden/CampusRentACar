<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel = "stylesheet" type="text/css" href = "/company_management/style.css" />
<title>Add a new vehicle into the system</title>
</head>
<body>
<div id="wrapper">
<div id="header">
<h1 id="h1Wrapper">Welcome to Campus Rent A Car</h1>
We offer car rental services to UTA students and faculties. Store Hours: M-F 8AM-8PM, Sa 8AM-5PM, Su Noon-5PM.
<hr>
</div>


<div id="horizontalLinks">
<a href="Index.jsp">Login</a>
</div>

<div id="main">
<h2>input the information of the new vehicle</h2>
<form name="AddNewCar" action="AddNewCar" method="post" >

<table>
<tr>
<td> Car ID (*): </td> 
<td> <input name="Car_id" value="<c:out value='${car.userName}'/>" > </td>
<td> <input name="userNameerror" value="<c:out value='${RerrorMsgs.User_name_error}'/>" type="text" style ="background-color: white; color: red; border: none; width: 300px" disabled="disabled" maxlength="60"> </td>
</tr>
<tr>	
<td> Car Name (*): </td>
<td><input name="Car_name" value="<c:out value='${car.password}'/>" > </td>
<td> <input name="passworderror" value="<c:out value='${RerrorMsgs.passwordError}'/>" type="text" style ="background-color: white; color: red; border: none; width: 300px" disabled="disabled" maxlength="60"> </td>
</tr>


<tr>	
<td>Capacity (*):</td> 
<td><input name="Capacity" value="<c:out value='${car.name}'/>" ></td>
<td> <input name="nameerror" value="<c:out value='${RerrorMsgs.NameError}'/>" type="text" style ="background-color: white; color: red; border: none; width: 300px" disabled="disabled" maxlength="60"> </td>
</tr>
<tr>	
<td>weekday_rate (*):</td> 
<td><input name="weekday_rate" value="<c:out value='${car.phone}'/>" ></td>
<td> <input name="phoneerror" value="<c:out value='${RerrorMsgs.phoneError}'/>" type="text" style ="background-color: white; color: red; border: none; width: 300px" disabled="disabled" maxlength="60"> </td>
</tr>

<tr>	
<td>weekend_rate (*):</td> 
<td><input name="weekend_rate" value="<c:out value='${car.phone}'/>" ></td>
<td> <input name="or" value="<c:out value='${RerrorMsgs.phoneError}'/>" type="text" style ="background-color: white; color: red; border: none; width: 300px" disabled="disabled" maxlength="60"> </td>
</tr>


<tr>
<td>gps_rate (*):</td> 
<td><input name="gps" value="<c:out value='${car.email}'/>" ></td>
<td> <input name="emailerror" value="<c:out value='${RerrorMsgs.emailError}'/>" type="text" style ="background-color: white; color: red; border: none; width: 300px" disabled="disabled" maxlength="60"> </td>
</tr>

<tr>	
<td>on_star_rate (*):</td>
<td><input name="on_star" value="<c:out value='${car.address}'/>" > </td> 
<td> <input name="addresserror" value="<c:out value='${RerrorMsgs.AddressError}'/>" type="text" style ="background-color: white; color: red; border: none; width: 300px" disabled="disabled" maxlength="60"> </td>
</tr>
<tr> 	
<td>sirius_xm_rate (*):</td>
<td><input name="sirius_xm" value="<c:out value='${car.Date_of_birth}'/>" > </td> 
<td> <input name="Doberror" value="<c:out value='${RerrorMsgs.DobError}'/>" type="text" style ="background-color: white; color: red; border: none; width: 300px" disabled="disabled" maxlength="60"> </td>
</tr>

 <tr>
 <td colspan="2">(*) Mandatory field</td>
 </tr>
</table>
<!-- <p> <input name="action" value="insertSystemUser" type="hidden"> 
<input name="submit" type="submit" value="insertSystemUser"> </p> -->
 <p> <input name="action" value="insertSystemUser" type="hidden"> 
<input name="submit" type="submit" value="Submit"> </p> 
</form>
</div>

<br><br><br>
<div id="footer">
University of Texas at Arlington <br>
CSE 6329-001 Class Project, Fall 2018 <br>
Team 3 <br>
</div>
</div>
</body>
</html>