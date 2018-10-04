<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel = "stylesheet" type="text/css" href = "/company_management/style.css" /><title>Renter HomePage</title>
</head>
<body>
<div id="wrapper">
<div id="header">
<h1 id="h1Wrapper">Campus Rent A Car</h1>
We offer car rental services to UTA students and faculties. Store Hours: M-F 8AM-8PM, Sa 8AM-5PM, Su Noon-5PM.
<hr><br><br>


<div id="main">
<h2>Welcome to Renter's Homepage</h2>
<br>
<p>Please enter the rental_id you want cancel:<br>


<tr>
	<td>
	<form action="/company_management/ViewReservedController?action=listCancel" method="post">
	<table style="width: 300px; ">
	<tr>
	<tr>
  	<td> Rental_id: </td>
 	<td> <input name="id" value="<c:out value='${RentalModel.rental_id}'/>">  </td>
  	</tr>

</table>
  <input type="submit" value="Submit">
	</form>      
</td>
</tr>
</table>









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