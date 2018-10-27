<%@ include file = "Header.jsp" %>

<title>Rental Details</title>
<div id="horizontalLinks">
<a href="<%=request.getContextPath()%>/Manager.jsp">HomePage</a>
<a href="<%=request.getContextPath()%>/Logout">Logout</a>
</div>

<div id="main">
<% String userName = (String)request.getSession().getAttribute("sessionUser"); %> 
<% String role = (String)request.getSession().getAttribute("sessionRole"); %>
<h2><%=role%>, <%=userName%></h2>

<form name="ManagerController" action="<%=request.getContextPath()%>/ManagerController?action=viewCalendar" method="post" >

 
<table>
<c:forEach items="${RentalDetail}" var="item">

<tr>
<td> rental id: </td> 
<td> <input class="notEditable" name="rental_id" value="<c:out value='${item.rental_id}'/>" readonly="readonly"> </td>
</tr>
<tr>	
<td> car id: </td>
<td> <input class="notEditable" name="car_id" value="<c:out value='${item.car_id}'/>" readonly="readonly"> </td>
</tr>
<tr>	
<td> user name:</td> 
<td> <input class="notEditable" name="user_name" value="<c:out value='${item.user_name}'/>" readonly="readonly"> </td>
</tr>
<tr>	
<td> start time:</td> 
<td><input class="notEditable" name="start_time" value="<c:out value='${item.start_time}'/>" readonly="readonly" ></td>
</tr>
<tr>	
<td> return time:</td> 
<td> <input class="notEditable" name="return_time" value="<c:out value='${item.return_time}'/>" readonly="readonly"> </td>
</tr>
<tr>
<td> credit card number:</td> 
<td> <input class="notEditable" name="credit_card" value="<c:out value='${item.credit_card}'/>" readonly="readonly"> </td>
</tr>
<tr>	
<td> payment amount:</td>
<td> <input class="notEditable" name="payment" value="<c:out value='${item.payment}'/>" readonly="readonly"> </td>
</tr>
<tr> 	
<td> rental type:</td>
<td> <input class="notEditable" name="rental_type" value="<c:out value='${item.rental_type}'/>" readonly="readonly"> </td>
</tr>

<tr> 	
<td>if confirmed:</td>
<td><select name="confirmed"> 
<c:choose>
 <c:when test="${item.confirmed==0}">
 <option value="no" selected>No</option>
  <option value="yes">Yes</option>
 </c:when>
 <c:otherwise>
  <option value="no">No</option>
 <option value="yes" selected>Yes</option>
 </c:otherwise>
</c:choose>	
</select>  </td></tr>
 
 </c:forEach>
</table>
 <p> <input name="action" value="validateEditting" type="hidden"> 
<input name="submit" type="submit" value="go back"> </p> 
</form>
</div>

<br><br><br>
<%@ include file = "Footer.jsp" %>