<%@ include file = "Header.jsp" %>
<title>login page</title>
<div id="horizontalLinks">
<a href="Register.jsp">Register</a>
<a href="Index.jsp">Login</a>
</div>

<div id="main">
<form name="SystemUserController" action="SystemUserController" method="post" >
<input class="error" name="errMsg" value="<c:out value='${indexErrorMsgs}'/>" disabled="disabled"> 

<h2>Enter Your User Name and Password.</h2>
<table>
<tr>
<td> User Name (*): </td> 
<td> <input name="user_name" value="<c:out value='${systemUser.user_name}'/>" >
<td><input class="error" name="user_nameError" value="<c:out value='${errorMsgs.user_nameError}'/>"  disabled="disabled"> </td>
</tr>
<tr>	
<td> Password (*): </td>
<td> <input name="password" value="<c:out value='${systemUser.password}'/>" >
<td><input class="error" name="passwordError" value="<c:out value='${errorMsgs.passwordError}'/>"  disabled="disabled"> </td>
</tr>
 
 <tr>
 <td colspan="2">(*) Mandatory field</td>
 </tr>
</table>
<!-- <p><input name="action" value="verifySystemUser" type="hidden">
<input name="submit" type="submit" value="verifySystemUser"></p> -->
<p><input name="action" value="verifySystemUser" type="hidden">
<input name="submit" type="submit" value="submit"></p>
</form>

<p><a href="http://localhost:8080/CampusRentACar/Register.jsp">New user first time login?</a></p>
</div>
<%@ include file = "Footer.jsp" %>