<%@ include file = "Header.jsp" %>

<title>Manager HomePage</title>
<div id="horizontalLinks">
<a href="<%=request.getContextPath()%>/Manager.jsp">HomePage</a>
<a href="<%=request.getContextPath()%>/ManagerController?action=editMyProfile">Edit My Profile</a>
<a href="<%=request.getContextPath()%>/Logout">Logout</a>
</div>

<div id="main">
<% String userName = (String)request.getSession().getAttribute("sessionUser"); %> 
<% String role = (String)request.getSession().getAttribute("sessionRole"); %>
<h2>Welcome to <%=role%>'s HomePage, <%=userName%></h2>
<a href="<%=request.getContextPath()%>/ManagerController?action=deleteReservation">delete a reservation</a>

<a href="<%=request.getContextPath()%>/ManagerController?action=viewCalendar">view all Rental records</a>

<a href="<%=request.getContextPath()%>/ViewAvailableCar.jsp">view all available vehicles</a>

<a href="<%=request.getContextPath()%>/NewCar.jsp">add a new vehicle</a>

</div>

<%@ include file = "Footer.jsp" %>