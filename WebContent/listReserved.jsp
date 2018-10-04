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
      
      
       <table class="myTable"> 
			<tr class="myTableRow"> 
				<th class="myTableHead" style="width: 70px; height: 44px">rental_id</th>
				<th class="myTableHead" style="width: 74px; ">car_id</th> 
				<th class="myTableHead" style="width: 70px; ">user_name</th>
				<th class="myTableHead" style="width: 80px; ">start_time</th>
				<th class="myTableHead" style="width: 90px; ">return_time</th>
				<th class="myTableHead" style="width: 74px; ">credit_card</th> 
				<th class="myTableHead" style="width: 70px; ">payment</th>
				<th class="myTableHead" style="width: 63px; ">rental_type</th>  
				<th class="myTableHead" style="width: 63px; ">confirmed</th> 
			</tr>

 		<c:forEach items="${RENTALS}" var="item">
			<tr class="myTableRow">
			<td class="myTableCell" style="width: 70px; "><c:out value="${item.rental_id}" /></td>
			<td class="myTableCell" style="width: 74px; "><c:out value="${item.car_id}" /></td>
			<td class="myTableCell" style="width: 70px; "><c:out value="${item.user_name}" /></td>
			<td class="myTableCell" style="width: 80px; "><c:out value="${item.start_time}" /></td>
			<td class="myTableCell" style="width: 90px; "><c:out value="${item.return_time}" /></td>
			<td class="myTableCell" style="width: 74px; "><c:out value="${item.credit_card}" /></td>
			<td class="myTableCell" style="width: 70px; "><c:out value="${item.payment}" /></td>
			<td class="myTableCell" style="width: 63px; "><c:out value="${item.rental_type}" /></td>
			<td class="myTableCell" style="width: 63px; "><c:out value="${item.confirmed}" /></td>
			</tr>
		</c:forEach>
 </table>
 <br>
 <a href="NewFile.jsp">|Back to welcome page|</a>
</body>
</html>