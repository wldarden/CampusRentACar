<%@ include file = "Header.jsp" %>

<title>Cancel</title>
<div id="horizontalLinks">
<a href="Updateownprofile.jsp">Update Profile|</a>
<a href="Logout">Logout|</a>
</div>


<div id="main">
<h2>Welcome to Renter's Homepage</h2>
<form action="<%=request.getContextPath() %>/ViewReservedController?action=listCancel" method="post"> 
<input name="errMsg"  value="<c:out value='${errorMsgs.errorMsg}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 355px" disabled="disabled">
<table>
<tr>
<td style="width: 364px; height: 46px">Please enter the rental_id you want cancel:</td>
</tr>
<tr>
	<tr>
	<tr>
  	<td> Rental_id: </td>
 	<td> <input name="id" value="<c:out value='${RentalModel.rental_id}'/>">  </td>
 	<td> <input name = "rental_idError" value = "<c:out value = '${errorMsgs.getRentalIDerror()}'/>" type="text" style="background-color: white; color: red; border: none; width: 392px" disabled = "disabled" maxlength="60"></td>      	
</tr>

</table>
  <input type="submit" value="Submit">
	      
<br>
<br>
<a href="NewFile.jsp">|Back to welcome page|</a>
</div>

<div id="footer">
University of Texas at Arlington <br>
CSE 6329-001 Class Project, Fall 2018 <br>
Team 3 <br>
</div>
</body>
</html>