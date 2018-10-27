<%@ include file = "Header.jsp" %>

<title>All Rental Reservations</title>
<div id="horizontalLinks">
<a href="<%=request.getContextPath()%>/Manager.jsp">HomePage</a>
<a href="<%=request.getContextPath()%>/Logout">Logout</a>
</div>


<div id="main">
<% String userName = (String)request.getSession().getAttribute("sessionUser"); %> 
<% String role = (String)request.getSession().getAttribute("sessionRole"); %>
<h2><%=role%>, <%=userName%></h2>
<h4>Select a Rental Record you would like to delete, and click 'delete'</h4>  
<br>
<form name="deleteReservation" action="<%=request.getContextPath()%>/ManagerController?action=delete" method="post" >
 <table class="table1"> 
<tr> 
<th>Select a record</th>
<th>Rental id</th>
<th>Renter</th>
<th>Car id</th>
<th>Start time</th>
<th>End time</th> 				

</tr>
<c:forEach items="${Rentals}" var="item">
<tr> 

<th><input type="radio" name="pickedRentaltodelete" value="${item.rental_id}"/></th>

<th><c:out value="${item.rental_id}" /></th> 
<th><c:out value="${item.user_name}" /></th> 
<th><c:out value="${item.car_id}" /></th> 
<th><c:out value="${item.start_time}" /></th>
<th><c:out value="${item.return_time}" /></th>			

</tr>
</c:forEach>
 </table>
 
<p> 
<input name="action" value="edit" type="hidden">
<input name="delete" type="submit" value="delete">    
</p>
</form>

</div>

<%@ include file = "Footer.jsp" %>