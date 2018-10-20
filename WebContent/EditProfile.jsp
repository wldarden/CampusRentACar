<%@ include file = "Header.jsp" %>

<title>Register</title>
<div id="horizontalLinks">
<a href="/CampusRentACar/SystemUserController?action=showAllSystemUsersProfile">All System Users Profile</a>
<a href="/CampusRentACar/AdminRevokeRenter.jsp">Revoke</a>

<!-- <a href="/CampusRentACar/EditProfile.jsp">Edit My Profile</a> -->
<a href="/CampusRentACar/SystemUserController?action=editOwnProfile">Edit My Profile</a>
<a href="/CampusRentACar/Logout.jsp">Logout</a>
</div>

<div id="main">
 
<h2>Edit your profile</h2>
<form name="Edit" action="/CampusRentACar/SystemUserController?action=validateEditting" method="post" >

 
<table>
<c:forEach items="${profile}" var="item">


<tr>
<td> User Name (*): </td> 
<td> <input name="userName" value="<c:out value='${item.user_name}'/>" ></td>
</tr>

<tr>	
<td> Password (*): </td>
<td><input name="password" value="<c:out value='${item.password}'/>" ></td>
</tr>

<tr>	
<td>Name (*):</td> 
<td><input name="name" value="<c:out value='${item.name}'/>" ></td>
</tr>
<tr>	
<td>Phone (*):</td> 
<td><input name="phone" value="<c:out value='${item.phone}'/>" ></td>
</tr>

<tr>
<td>email (*):</td> 
<td><input name="email" value="<c:out value='${item.email}'/>" ></td>
</tr>

<tr>	
<td>Address (*):</td>
<td><input name="address" value="<c:out value='${item.address}'/>" > </td> 
</tr>

<tr>
<td>UTA ID (*):</td>
<td><input name="UTAID" value="<c:out value='${item.uta_id}'/>" > </td> 
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