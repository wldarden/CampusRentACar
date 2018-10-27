<%@ include file = "Header.jsp" %>

<title>Admin HomePage</title>
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
<h2>Welcome to <%=role%>'s Homepage, <%=userName%></h2>

<br>
<p><a href="<%=request.getContextPath()%>/AdminController?action=showAllSystemUsersProfile">Would you like to see all system users profile? </a> <br>
You could edit any users profiles from <a href="/CampusRentACar/AdminController?action=showAllSystemUsersProfile">here </a> <br>


 <p><a href="<%=request.getContextPath()%>/AdminRevokeRenter.jsp">Would you like to revoke rental privileges? </a><br></p>
</div>

<%@ include file = "Footer.jsp" %>