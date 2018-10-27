<%@ include file = "Header.jsp" %>

<title>All Available Cars</title>
<div id="horizontalLinks">
<a href="<%=request.getContextPath()%>/Manager.jsp">HomePage</a>
<a href="<%=request.getContextPath()%>/Logout">Logout</a>
</div>

<div id="main">
<% String userName = (String)request.getSession().getAttribute("sessionUser"); %> 
<% String role = (String)request.getSession().getAttribute("sessionRole"); %>
<h2><%=role%>, <%=userName%></h2>

<form name="ManagerController" action="<%=request.getContextPath()%>/ManagerController?action=backfromview" method="post" >

 
<table>
<c:forEach items="${AvailableCar}" var="item">

<tr>
<td> car name: </td> 
<td> <input class="notEditable" name="car_name" value="<c:out value='${item.car_name}'/>" readonly="readonly"> </td>
</tr>
<tr>	
<td> car id: </td>
<td> <input class="notEditable" name="car_id" value="<c:out value='${item.car_id}'/>" readonly="readonly"> </td>
</tr>


 
 </c:forEach>
</table>
 <p> <input name="action" value="validateEditting" type="hidden"> 
<input name="submit" type="submit" value="go back"> </p> 
</form>
</div>

<br><br><br>
<%@ include file = "Footer.jsp" %>