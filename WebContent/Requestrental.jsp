<%@ include file = "Header.jsp" %>

<title>Renter HomePage</title>

<div id="horizontalLinks">

<a href="Updateownprofile.jsp">Update Profile|</a>
<a href="Requestrental.jsp">Request rental|</a>
<a href="Logout.jsp">Logout|</a>
</div>

<div id="main">
<h2>Welcome to Renter Homepage</h2>
<tr>
<td>Age</td>
<td> <input name="age" value="<value='${systemUser.age}'/>" > </td><br>

<td>Rental type (Daily/Weekly)</td>
<td> <input name="rentalType" value="<value='${systemUser.rentalType}'/>" > </td><br>



<td>Number of occupants</td>
<td> <input name="number" value="<value='${systemUser.number}'/>" > </td><br>

<td>Start Date (mm-dd-yyyy)</td>
<td> <input name="startDate" value="<value='${systemUser.startDate}'/>" > </td><br>

<td>Time(20:06)</td>
<td> <input name="time" value="<value='${systemUser.time}'/>" > </td><br>

<td>Duration</td>
<td> <input name="duration" value="<value='${systemUser.duration}'/>" > </td><br>

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
<a href="http://localhost:8080/CampusRentACar/ShowAllSystemUsersProfile.jsp">Would you like to view all your reserved rentals? </a> <br>
<a href="http://localhost:8080/CampusRentACar/ShowAllSystemUsersProfile.jsp">Would you like to confirm/pay for your reserved rentals? </a> <br>
<a href="http://localhost:8080/CampusRentACar/ShowAllSystemUsersProfile.jsp">Would you like to cancel your reserved rentals? </a> <br>

<br>
<br>

<a href="NewFile.jsp">|Back to welcome page|</a>

</div>

<%@ include file = "Footer.jsp" %>