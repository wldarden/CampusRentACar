<%@ include file = "Header.jsp" %>

<title>Register</title>
<div id="horizontalLinks">
<a href="/CampusRentACar/AdminController?action=showAllSystemUsersProfile">All System Users Profile</a>
<a href="/CampusRentACar/AdminRevokeRenter.jsp">Revoke</a>

<!-- <a href="/CampusRentACar/EditProfile.jsp">Edit My Profile</a> -->
<a href="/CampusRentACar/SystemUserController?action=editOwnProfile">Edit My Profile</a>
<a href="/CampusRentACar/Logout.jsp">Logout</a>
</div>

<div id="main">
 
<h2>Edit your profile</h2>
<form name="AdminController" action="/CampusRentACar/AdminController?action=validateEditting" method="post" >
<input class="error" name="errMsg" value="<c:out value='${errorMsgs.errorMsg}'/>" disabled="disabled"> 

 
<table>
<c:forEach items="${profile}" var="item">

<tr>	
<td> Password (*): </td>
<td><input name="password" value="<c:out value='${item.password}'/>" > 
<td><input class="error" name="passwordError" value="<c:out value='${errorMsgs.passwordError}'/>"  disabled="disabled"> </td>
</tr>
<tr>	
<td>Name (*):</td> 
<td><input name="name" value="<c:out value='${item.name}'/>" >
<td><input class="error" name="nameError" value="<c:out value='${errorMsgs.nameError}'/>"  disabled="disabled"> </td>
</tr>
<tr>	
<td>Phone (*):</td> 
<td><input name="phone" value="<c:out value='${item.phone}'/>" >
<td><input class="error" name="phoneError" value="<c:out value='${errorMsgs.phoneError}'/>"  disabled="disabled"> </td>
</tr>
<tr>
<td>Email (*):</td> 
<td><input name="email" value="<c:out value='${item.email}'/>" >
<td><input class="error" name="emailError" value="<c:out value='${errorMsgs.emailError}'/>"  disabled="disabled"> </td>
</tr>
<tr>	
<td>Address (*):</td>
<td><input name="address" value="<c:out value='${item.address}'/>" >
<td><input class="error" name="addressError" value="<c:out value='${errorMsgs.addressError}'/>"  disabled="disabled"> </td>
</tr>
<tr> 	
<td>Date of Birth (*):</td>
<td><input name="dob" value="<c:out value='${item.dob}'/>" >
<td><input class="error" name="dobError" value="<c:out value='${errorMsgs.dobError}'/>"  disabled="disabled"> </td> 
</tr>
<tr>	
<td>UTA ID (*):</td>
<td><input name="uta_id" value="<c:out value='${item.uta_id}'/>" >
<td><input class="error" name="uta_idError" value="<c:out value='${errorMsgs.uta_idError}'/>"  disabled="disabled"> </td>
</tr>
<tr> 	
<td>Auto Club Membership:</td>
<td><select name="auto_club_member"> 
	<option value="no">No</option>
	<option value="yes">Yes</option>
	
</select>  </td></tr>
 <tr>
 <td colspan="2">(*) Mandatory field</td>
 </tr>
 </c:forEach>
</table>
<!-- <p> <input name="action" value="insertSystemUser" type="hidden"> 
<input name="submit" type="submit" value="insertSystemUser"> </p> -->
 <p> <input name="action" value="validateEditting" type="hidden"> 
<input name="submit" type="submit" value="Submit"> </p> 
</form>
</div>

<br><br><br>
<%@ include file = "Footer.jsp" %>