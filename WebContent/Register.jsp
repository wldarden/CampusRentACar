<%@ include file = "Header.jsp" %>

<title>Register</title>
<div id="horizontalLinks">
<a href="Index.jsp">Login</a>
</div>

<div id="main">
<h2>Register and Create Your Profile</h2>
<form name="SystemUserController" action="SystemUserController" method="post" >
<input class="error" name="errMsg" value="<c:out value='${errorMsgs.errorMsg}'/>" disabled="disabled"> 
<table>
<tr>
<td> User Name (*): </td> 
<td> <input name="user_name" value="<c:out value='${systemUser.user_name}'/>" >
<td><input class="error" name="user_nameError" value="<c:out value='${errorMsgs.user_nameError}'/>"  disabled="disabled"> </td>
</tr>
<tr>	
<td> Password (*): </td>
<td><input name="password" value="<c:out value='${systemUser.password}'/>" > 
<td><input class="error" name="passwordError" value="<c:out value='${errorMsgs.passwordError}'/>"  disabled="disabled"> </td>
</tr>

<!------------ TO DO: pull down menu: add error and put back prev selected item  ---------> 

<tr>	
<td> Role (*): </td>
<td><select name="role"> 
	<option value=""></option>
	<option value="User">User</option>
	<option value="Admin">Admin</option>
	<option value="Manager">Manager</option>
</select>  
</tr>

<tr>	
<td>Name (*):</td> 
<td><input name="name" value="<c:out value='${systemUser.name}'/>" >
<td><input class="error" name="nameError" value="<c:out value='${errorMsgs.nameError}'/>"  disabled="disabled"> </td>
</tr>
<tr>	
<td>Phone (*):</td> 
<td><input name="phone" value="<c:out value='${systemUser.phone}'/>" >
<td><input class="error" name="phoneError" value="<c:out value='${errorMsgs.phoneError}'/>"  disabled="disabled"> </td>
</tr>

<tr>
<td>Email (*):</td> 
<td><input name="email" value="<c:out value='${systemUser.email}'/>" >
<td><input class="error" name="emailError" value="<c:out value='${errorMsgs.emailError}'/>"  disabled="disabled"> </td>
</tr>

<tr>	
<td>Address (*):</td>
<td><input name="address" value="<c:out value='${systemUser.address}'/>" >
<td><input class="error" name="addressError" value="<c:out value='${errorMsgs.addressError}'/>"  disabled="disabled"> </td>
</tr>
<tr> 	
<td>Date of Birth (*):</td>
<td><input name="dob" value="<c:out value='${systemUser.dob}'/>" >
<td><input class="error" name="dobError" value="<c:out value='${errorMsgs.dobError}'/>"  disabled="disabled"> </td> 
</tr>
<tr>	
<td>UTA ID (*):</td>
<td><input name="uta_id" value="<c:out value='${systemUser.uta_id}'/>" >
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
</table>
 <p> <input name="action" value="insertSystemUser" type="hidden"> 
<input name="submit" type="submit" value="submit">


</p> 
</form>
</div>

<%@ include file = "Footer.jsp" %>