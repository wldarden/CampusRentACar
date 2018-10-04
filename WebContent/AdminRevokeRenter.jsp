<%@ include file = "Header.jsp" %>

<title>Admin HomePage</title>
<div id="horizontalLinks">
<a href="/company_management/SystemUserController?action=showAllSystemUsersProfile">All System Users Profile</a>
<a href="/company_management/AdminRevokeRenter.jsp">Revoke</a>
<a href="/company_management/EditProfile.jsp">Edit My Profile</a>
<a href="Logout">Logout</a>
</div>

<div id="main">
<h2>Welcome to Admin Homepage</h2>
<br>
<form name="Revoke" action="/company_management/SystemUserController?action=revoke" method="post" >

Enter the user name you would like to revoke a rental privilege 

<table>
<tr>
<td> User Name : </td> 
<td> <input name="user_name" value="<c:out value='${UserModel.user_name}'/>" > </td>
</tr>
</table>

<p> <input name="action" value="revoke" type="hidden"> 
<input name="submit" type="submit" value="Submit"> </p> 
</form>
</div>
<%@ include file = "Footer.jsp" %>