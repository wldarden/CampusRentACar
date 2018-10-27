<%@ include file = "Header.jsp" %>

<title>Admin Edit Your Profile Success</title>
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
<h5>You successfully edited your own profile. </h5>

<a href="<%=request.getContextPath()%>/Admin.jsp">Back to your home page</a>

</div>

<br><br><br>
<%@ include file = "Footer.jsp" %>