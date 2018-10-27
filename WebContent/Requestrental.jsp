<%@ include file = "Header.jsp" %>

<title>Register</title>
<div id="horizontalLinks">
<a href="Updateownprofile.jsp">Update Profile|</a>
<a href="Logout">Logout|</a>
</div>


<div id="main">
<h2>Welcome to Renter Homepage</h2>
<form action="<%=request.getContextPath() %>/ViewReservedController?action=Requestrental" method="post">
<input name="errMsg"  value="<c:out value='${errorMsgs.errorMsg}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 401px" disabled="disabled">
<table>
<tr>
<td>Age</td>
<td> <input name="age" value="<c:out value='${systemUser.age}'/>" > </td>
<td><input name = "ageError" value = "<c:out value = '${errorMsgs.getAgeerror()}'/>" type="text" style="background-color: white; color: red; border: none; width: 392px" disabled = "disabled" maxlength="60"></td>
</tr>
<tr>
<td>Rental type (Daily/Weekly)</td>
<td> <input name="rentalType" value="<c:out value='${systemUser.rentalType}'/>" > </td>
<td> <input name = "rentaltypeerror" value = "<c:out value = '${errorMsgs.getRentaltypeerror()}'/>" type="text" style="background-color: white; color: red; border: none; width: 392px" disabled = "disabled" maxlength="60"></td>
</tr>
<tr>
<td>Number of occupants</td>
<td> <input name="number" value="<c:out value='${systemUser.number}'/>" ><br> </td>
<td><input name = "occupantserror" value = "<c:out value = '${errorMsgs.getOccupantserror()}'/>" type="text" style="background-color: white; color: red; border: none; width: 392px" disabled = "disabled" maxlength="60"></td>
<tr>
<td>Start time (yyyy-mm-dd hh:mm:ss)</td>
<td><input name="startTime" value="<c:out value='${systemUser.startDate}'/>"></td>
</tr>
<tr>
<td>Return time (yyyy-mm-dd hh:mm:ss)</td>
<td> <input name="returnTime" value="<c:out value='${systemUser.duration}'/>" > </td>
<td><input name = "timeerror" value = "<c:out value = '${errorMsgs.getTimeerror()}'/>" type="text" style="background-color: white; color: red; border: none; width: 392px" disabled = "disabled" maxlength="60"></td>

</tr>

<tr>
<td>GPS:</td>
<td><select name="GPS"> 
	<option value="no">No</option>
	<option value="yes">Yes</option>
</select>  </td>
</tr>


<tr>
<td>On_star:</td>
<td><select name="onstar"> 
	<option value="no">No</option>
	<option value="yes">Yes</option>
</select>  </td>
</tr>



<tr>
<td>Sirius:</td>
<td><select name="sirius"> 
	<option value="no">No</option>
	<option value="yes">Yes</option>
</select>  </td>
</tr>
 <tr>
<td>Auto Club Membership:</td>
<td><select name="membership"> 
	<option value="no">No</option>
	<option value="yes">Yes</option>
</select>  </td>
</tr>
</table>
<input type="submit" value="Submit">

<br>
<a href="<%=request.getContextPath() %>/ViewReservedController?action=listReserved">Would you like to view all your reserved rentals? </a> <br>
<a href="Confirm.jsp">Would you like to confirm/pay for your reserved rentals? </a> <br>
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