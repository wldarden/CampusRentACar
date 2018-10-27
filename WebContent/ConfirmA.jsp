
<%@ include file = "Header.jsp" %>

<title>Confirm</title>
<div id="horizontalLinks">
<a href="Updateownprofile.jsp">Update Profile|</a>
<a href="Logout">Logout|</a>
</div>


<div id="main">
<h2>Welcome to Renter's Homepage</h2>
<br>
Your subscription has been confirmed. <br>
<FONT size= 5 color="green">Thank you!</FONT>
<br><br>
<a href="<%=request.getContextPath() %>/ViewReservedController?action=listReserved">You can check your rentals' status here. </a> <br>


</div>

<div id="footer">
University of Texas at Arlington <br>
CSE 6329-001 Class Project, Fall 2018 <br>
Team 3 <br>
</div>
</div>
</body>
</html>