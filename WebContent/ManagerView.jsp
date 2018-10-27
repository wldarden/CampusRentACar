<%@ include file = "Header.jsp" %>

<title>All Rental Records</title>
<div id="horizontalLinks">
<a href="<%=request.getContextPath()%>/Manager.jsp">HomePage</a>
<a href="<%=request.getContextPath()%>/Logout">Logout</a>
</div>


<div id="main">
<% String userName = (String)request.getSession().getAttribute("sessionUser"); %> 
<% String role = (String)request.getSession().getAttribute("sessionRole"); %>
<h2><%=role%>, <%=userName%></h2>
<h4>Select a Rental Record you would like to view details, and click view</h4>  
<br>
<form name="View" action="<%=request.getContextPath()%>/ManagerController?action=viewDetail" method="post" >
 <table class="table1"> 
<tr> 
<th>Select a record</th>
<th>Rental id</th>
<th>Renter</th>
<th>Car id</th>
<th>Start time</th>
<th>End time</th> 				

</tr>
<c:forEach items="${allRentals}" var="item">
<tr> 

<th><input type="radio" name="pickedRental" value="${item.rental_id}"/></th>

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
<input name="editProfile" type="submit" value="view">    
</p>
</form>

</div>

<%@ include file = "Footer.jsp" %>