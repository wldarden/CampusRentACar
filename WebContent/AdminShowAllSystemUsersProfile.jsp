<%@ include file = "Header.jsp" %>
<style>
table {
    border-collapse: collapse;
    width:500px;
 	margin: 10px auto;
}

table, th, td {
    border: 1px solid black;
}
</style>


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
<p>
Select a system user's profile you would like to edit, and click edit  
<br>

<br></p>
<form name="Edit" action="/company_management/SystemUserController?action=edit" method="post" >
 <table> 
<tr> 
<th>Select a system user</th>
<th>Role</th>
<th>name</th>
<th>User Name</th>
<th>Email</th> 				

</tr>
<c:forEach items="${allSystemUsers}" var="item">
<tr> 

<th><input type="radio" name="pickedSystemUser" value="${item.user_name}"/></th>

<th><c:out value="${item.role}" /></th> 
<th><c:out value="${item.name}" /></th> 
<th><c:out value="${item.user_name}" /></th>
<th><c:out value="${item.email}" /></th>			

</tr>
</c:forEach>
 </table>
 
<p>
Select a system user's profile you would like to edit, and click   
<input name="action" value="edit" type="hidden">
<input name="editProfile" type="submit" value="edit">    
</p>
</form>

<!-- <p> <input name="action" value="insertSystemUser" type="hidden"> 
<input name="submit" type="submit" value="insertSystemUser"> </p> -->


</div>

<%@ include file = "Footer.jsp" %>