<%@ include file = "Header.jsp" %>

<title>User HomePage</title>
<div id="horizontalLinks">
<a href="<%=request.getContextPath()%>/User.jsp">HomePage</a>
<a href="<%=request.getContextPath()%>/UserController?action=editMyProfile">Edit My Profile</a>
<a href="<%=request.getContextPath()%>/Logout.jsp">Logout</a>
</div>

<div id="main">
<% String userName = (String)request.getSession().getAttribute("sessionUser"); %> 
<% String role = (String)request.getSession().getAttribute("sessionRole"); %>
<h2>Welcome to <%=role%>'s HomePage, <%=userName%></h2>


</div>

<%@ include file = "Footer.jsp" %>