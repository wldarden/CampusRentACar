<%@ include file = "Header.jsp" %>

<title>Admin HomePage</title>
<div id="horizontalLinks">
<a href="/CampusRentACar/AdminController?action=showAllSystemUsersProfile">All System Users Profile</a>
<a href="/CampusRentACar/AdminRevokeRenter.jsp">Revoke</a>
<!-- <a href="/CampusRentACar/EditProfile.jsp">Edit My Profile</a> -->
<a href="/CampusRentACar/SystemUserController?action=editOwnProfile">Edit My Profile</a>
<a href="/CampusRentACar/Logout.jsp">Logout</a>
</div>

<div id="main">
<h2>Welcome to Admin Homepage</h2>
<br>
<p><a href="/CampusRentACar/AdminController?action=showAllSystemUsersProfile">Would you like to see all system users profile? </a> <br>
You could edit any users profiles from <a href="/CampusRentACar/AdminController?action=showAllSystemUsersProfile">here </a> <br>


 <p><a href="/CampusRentACar/AdminRevokeRenter.jsp">Would you like to revoke rental privileges? </a><br></p>
</div>

<%@ include file = "Footer.jsp" %>