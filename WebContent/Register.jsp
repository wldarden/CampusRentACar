<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel = "stylesheet" type="text/css" href = "/company_management/style.css" />
<title>Register</title>
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
<h2>Register and Create Your Profile</h2>
<form name="Register" action="Register" method="post" >

<table>
<tr>
<td> User Name (*): </td> 
<td> <input name="userName" value="<c:out value='${user.userName}'/>" > </td>
<td> <input name="userNameerror" value="<c:out value='${RerrorMsgs.User_name_error}'/>" type="text" style ="background-color: white; color: red; border: none; width: 300px" disabled="disabled" maxlength="60"> </td>
</tr>
<tr>	
<td> Password (*): </td>
<td><input name="password" value="<c:out value='${user.password}'/>" > </td>
<td> <input name="passworderror" value="<c:out value='${RerrorMsgs.passwordError}'/>" type="text" style ="background-color: white; color: red; border: none; width: 300px" disabled="disabled" maxlength="60"> </td>
</tr>
<tr>	
<td> Role (*): </td>
<td><select name="role"> 
	<option value=""></option>
	<option value="user">user</option>
	<option value="admin">admin</option>
	<option value="manager">manager</option>
</select>  </td>
<td> <input name="roleerror" value="<c:out value='${RerrorMsgs.RoleError}'/>" type="text" style ="background-color: white; color: red; border: none; width: 300px" disabled="disabled" maxlength="60"> </td>
</tr>

<tr>	
<td>Name (*):</td> 
<td><input name="name" value="<c:out value='${user.name}'/>" ></td>
<td> <input name="nameerror" value="<c:out value='${RerrorMsgs.NameError}'/>" type="text" style ="background-color: white; color: red; border: none; width: 300px" disabled="disabled" maxlength="60"> </td>
</tr>
<tr>	
<td>Phone (*):</td> 
<td><input name="phone" value="<c:out value='${user.phone}'/>" ></td>
<td> <input name="phoneerror" value="<c:out value='${RerrorMsgs.phoneError}'/>" type="text" style ="background-color: white; color: red; border: none; width: 300px" disabled="disabled" maxlength="60"> </td>
</tr>

<tr>
<td>email (*):</td> 
<td><input name="email" value="<c:out value='${user.email}'/>" ></td>
<td> <input name="emailerror" value="<c:out value='${RerrorMsgs.emailError}'/>" type="text" style ="background-color: white; color: red; border: none; width: 300px" disabled="disabled" maxlength="60"> </td>
</tr>

<tr>	
<td>Address (*):</td>
<td><input name="address" value="<c:out value='${user.address}'/>" > </td> 
<td> <input name="addresserror" value="<c:out value='${RerrorMsgs.AddressError}'/>" type="text" style ="background-color: white; color: red; border: none; width: 300px" disabled="disabled" maxlength="60"> </td>
</tr>
<tr> 	
<td>Date of Birth (*):</td>
<td><input name="dateOfBirth" value="<c:out value='${user.Date_of_birth}'/>" > </td> 
<td> <input name="Doberror" value="<c:out value='${RerrorMsgs.DobError}'/>" type="text" style ="background-color: white; color: red; border: none; width: 300px" disabled="disabled" maxlength="60"> </td>
</tr>
<tr>	
<td>UTA ID (*):</td>
<td><input name="UTAID" value="<c:out value='${user.uta_id}'/>" > </td> 
<td> <input name="IDerror" value="<c:out value='${RerrorMsgs.IDError}'/>" type="text" style ="background-color: white; color: red; border: none; width: 300px" disabled="disabled" maxlength="60"> </td>
</tr>
<tr> 	
<td>Auto Club Membership:</td>
<td><select name="membership"> 
	<option value="no">No</option>
	<option value="yes">Yes</option>
	
</select>  </td></tr>
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