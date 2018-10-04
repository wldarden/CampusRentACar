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
<p><a href="/company_management/SystemUserController?action=showAllSystemUsersProfile">Would you like to see all system users profile? </a> <br>
You could edit any users profiles from <a href="/company_management/SystemUserController?action=showAllSystemUsersProfile">here </a> <br>


 <p><a href="/company_management/AdminRevokeRenter.jsp">Would you like to revoke rental privileges? </a><br></p>
</div>

<%@ include file = "Footer.jsp" %>