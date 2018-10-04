<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel = "stylesheet" type="text/css" href = "/style.css" />
<title>Renter HomePage</title>
</head>
<body>
<div id="wrapper">
<div id="header">
<h1 id="h1Wrapper">Rent a car</h1>
We offer car rental services to UTA students and faculties. Store Hours: M-F 8AM-8PM, Sa 8AM-5PM, Su Noon-5PM.
<hr><br><br>
</div>
<div id="horizontalLinks">

<a href="Updateownprofile.jsp">Update Profile|</a>
<a href="Requestrental.jsp">Request rental|</a>
<a href="Logout">Logout|</a>
</div>

<div id="main">
<h2>Welcome to Renter Homepage</h2>
<tr>
<td>Age</td>
<td> <input name="age" value="<c:out value='${systemUser.age}'/>" > </td><br>

<td>Rental type (Daily/Weekly)</td>
<td> <input name="rentalType" value="<c:out value='${systemUser.rentalType}'/>" > </td><br>



<td>Number of occupants</td>
<td> <input name="number" value="<c:out value='${systemUser.number}'/>" > </td><br>

<td>Start Date (mm-dd-yyyy)</td>
<td> <input name="startDate" value="<c:out value='${systemUser.startDate}'/>" > </td><br>

<td>Time(20:06)</td>
<td> <input name="time" value="<c:out value='${systemUser.time}'/>" > </td><br>

<td>Duration</td>
<td> <input name="duration" value="<c:out value='${systemUser.duration}'/>" > </td><br>

<tr>
<td>GPS:</td>
<td><select name="GPS"> 
	<option value="no">No</option>
	<option value="yes">Yes</option>
</select>  </td></tr><br>


<tr>
<td>On_star:</td>
<td><select name="onstar"> 
	<option value="no">No</option>
	<option value="yes">Yes</option>
</select>  </td></tr><br>


<tr>
<td>Sirius:</td>
<td><select name="sirius"> 
	<option value="no">No</option>
	<option value="yes">Yes</option>
</select>  </td></tr><br>
 <tr>
<td>Auto Club Membership:</td>
<td><select name="membership"> 
	<option value="no">No</option>
	<option value="yes">Yes</option>
</select>  </td></tr>
 <tr>


<td><input type="submit" value="Submit"></td>
<br>
<br>
<a href="/company_management/ViewReservedController?action=listReserved">Would you like to view all your reserved rentals? </a> <br>
<a href="http://localhost:8080/CampusRentACar/ShowAllSystemUsersProfile.jsp">Would you like to confirm/pay for your reserved rentals? </a> <br>
<a href="Cancel.jsp">Would you like to cancel your reserved rentals? </a> <br>

<br>
<br>

<a href="NewFile.jsp">|Back to welcome page|</a>

</div>

<div id="footer">
University of Texas at Arlington <br>
CSE 6329-001 Class Project, Fall 2018 <br>
Team 3 <br>
</div>
</div>
</body>
</html>