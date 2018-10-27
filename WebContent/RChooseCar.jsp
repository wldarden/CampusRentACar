<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Companies List</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="style.css" rel="stylesheet" type="text/css" />
<body>
    <div class="header_resize">
      <div class="logo"><h1><a href="/NewFile.jsp">Reserved rentals</a></h1></div>
      <div class="menu_nav">
      </div>
  </div>

     <div class="mainbar"><div class="submb"></div></div>
      
       <form action="<%=request.getContextPath() %>/ViewReservedController?action=RChoose" method="post">
       <table class="myTable"> 
			<tr class="myTableRow"> 
		
				<th class="myTableHead" style="width: 66px; ">Car_id</th> 
				<th class="myTableHead" style="width: 90px; ">Car_name</th>
				<th class="myTableHead" style="width: 66px; ">Capacity</th>
				<th class="myTableHead" style="width: 90px; ">Weekday_rate</th>
				<th class="myTableHead" style="width: 90px; ">Weekend_rate</th> 
				<th class="myTableHead" style="width: 90px; ">Week_rate</th>
				<th class="myTableHead" style="width: 63px; ">GPS</th>
				<th class="myTableHead" style="width: 63px; ">On_star</th>  
				<th class="myTableHead" style="width: 63px; ">Sirius_xm</th>
				<th class="myTableHead" style="width: 63px; ">Payment</th>  
			</tr>

 		<c:forEach items="${RCHOOSE}" var="item">
			<tr class="myTableRow">
			<td class="myTableCell" style="width: 74px; "><c:out value="${item.car_id}" /></td>
			<td class="myTableCell" style="width: 90px; "><c:out value="${item.car_name}" /></td>
			<td class="myTableCell" style="width: 74px; "><c:out value="${item.capacity}" /></td>
			<td class="myTableCell" style="width: 70px; "><c:out value="${item.weekday_rate}" /></td>
			<td class="myTableCell" style="width: 63px; "><c:out value="${item.weekend_rate}" /></td>
			<td class="myTableCell" style="width: 63px; "><c:out value="${item.week_rate}" /></td>
			<td class="myTableCell" style="width: 63px; "><c:out value="${item.gps}" /></td>
			<td class="myTableCell" style="width: 63px; "><c:out value="${item.on_star}" /></td>
			<td class="myTableCell" style="width: 63px; "><c:out value="${item.sirius_xm}" /></td>
			<td class="myTableCell" style="width: 63px; "><c:out value="${item.sirius_xm}" /></td>
			</tr>
		</c:forEach>
	<tr>
	<td>Please enter the car_id:</td>
 	<td><input name="car_id" value="<c:out value='${systemUser.id}'/>" style="width: 275px; "> </td>
 	</tr>
 	
 </table>
 <input type="submit" value="Submit">
 
 <a href="NewFile.jsp">|Back to welcome page|</a>
</body>
</html>