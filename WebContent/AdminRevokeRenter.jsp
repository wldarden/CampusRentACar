<%@ include file = "Header.jsp" %>

<title>Admin Revoke Renter</title>
<div id="horizontalLinks">
<a href="<%=request.getContextPath()%>/Admin.jsp">HomePage</a>
<a href="<%=request.getContextPath()%>/AdminController?action=showAllSystemUsersProfile">All System Users Profile</a>
<a href="<%=request.getContextPath()%>/AdminRevokeRenter.jsp">Revoke</a>
<a href="<%=request.getContextPath()%>/AdminController?action=editMyProfile">Edit My Profile</a>
<a href="<%=request.getContextPath()%>/Logout.jsp">Logout</a>
</div>


<div id="main">
<% String userName = (String)request.getSession().getAttribute("sessionUser"); %> 
<% String role = (String)request.getSession().getAttribute("sessionRole"); %>
<h2><%=role%>, <%=userName%></h2>
<h5>Enter the user name you would like to revoke a rental privilege</h5> 
<br>
<form name="Revoke" action="<%=request.getContextPath()%>/AdminController?action=revoke" method="post" >
<input class="error" name="errMsg" value="<c:out value='${errorMsgs.errorMsg}'/>" disabled="disabled"> 

<table>
<tr>
<td> User Name : </td> 
<td> <input name="user_name" value="<c:out value='${systemUser.user_name}'/>" > </td>
<td><input class="error" name="user_nameError" value="<c:out value='${errorMsgs.user_nameError}'/>"  disabled="disabled"> </td>

</tr>
</table>

<p> <input name="action" value="revoke" type="hidden"> 
<input name="submit" type="submit" value="Submit"> </p> 
</form>
</div>
<%@ include file = "Footer.jsp" %>