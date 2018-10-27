<%@ include file = "Header.jsp" %>

<title>Admin Show All System Users Profile</title>
<div id="horizontalLinks">
<a href="<%=request.getContextPath()%>/Admin.jsp">HomePage</a>
<a href="<%=request.getContextPath()%>/AdminController?action=showAllSystemUsersProfile">All System Users Profile</a>
<a href="<%=request.getContextPath()%>/AdminRevokeRenter.jsp">Revoke</a>
<a href="<%=request.getContextPath()%>/AdminController?action=editMyProfile">Edit My Profile</a>
<a href="<%=request.getContextPath()%>/Logout">Logout</a>
</div>


<div id="main">
<% String userName = (String)request.getSession().getAttribute("sessionUser"); %> 
<% String role = (String)request.getSession().getAttribute("sessionRole"); %>
<h2><%=role%>, <%=userName%></h2>
<h4>Select a system user's profile you would like to edit, and click edit</h4>  
<br>
<form name="Edit" action="<%=request.getContextPath()%>/AdminController?action=edit" method="post" >
 <table class="table1"> 
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
<input name="action" value="edit" type="hidden">
<input name="editProfile" type="submit" value="edit">    
</p>
</form>

</div>

<%@ include file = "Footer.jsp" %>