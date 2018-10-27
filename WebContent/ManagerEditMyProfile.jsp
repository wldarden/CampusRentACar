<%@ include file = "Header.jsp" %>

<title>Manager Edit My Profile</title>
<div id="horizontalLinks">
<a href="<%=request.getContextPath()%>/Manager.jsp">HomePage</a>
<a href="<%=request.getContextPath()%>/ManagerController?action=editMyProfile">Edit My Profile</a>
<a href="<%=request.getContextPath()%>/Logout">Logout</a>
</div>

<div id="main">
<% String userName = (String)request.getSession().getAttribute("sessionUser"); %> 
<% String role = (String)request.getSession().getAttribute("sessionRole"); %>
<h2><%=role%>, <%=userName%></h2>
<h5>You may edit your profile, but user name nor role cannot be edited. </h5>
<form name="ManagerController" action="<%=request.getContextPath()%>/ManagerController?action=validateEditting" method="post" >
<input class="error" name="errMsg" value="<c:out value='${errorMsgs.errorMsg}'/>" disabled="disabled"> 
 
<table>
<c:forEach items="${profile}" var="item">

<tr>
<td> Your User Name: </td> 
<td> <input class="notEditable" name="user_name" value="<c:out value='${item.user_name}'/>" readonly="readonly"> </td>
</tr>
<tr>	
<td> Password (*): </td>
<td><input name="password" value="<c:out value='${item.password}'/>" > 
<td><input class="error" name="passwordError" value="<c:out value='${errorMsgs.passwordError}'/>"  disabled="disabled"> </td>
</tr>
<tr>	
<td>Name (*):</td> 
<td><input name="name" value="<c:out value='${item.name}'/>" >
<td><input class="error" name="nameError" value="<c:out value='${errorMsgs.nameError}'/>"  disabled="disabled"> </td>
</tr>
<tr>	
<td> Your Role:</td> 
<td><input class="notEditable" name="role" value="<c:out value='${item.role}'/>" readonly="readonly" ></td>
</tr>
<tr>	
<td>Phone (*):</td> 
<td><input name="phone" value="<c:out value='${item.phone}'/>" >
<td><input class="error" name="phoneError" value="<c:out value='${errorMsgs.phoneError}'/>"  disabled="disabled"> </td>
</tr>
<tr>
<td>Email (*):</td> 
<td><input name="email" value="<c:out value='${item.email}'/>" >
<td><input class="error" name="emailError" value="<c:out value='${errorMsgs.emailError}'/>"  disabled="disabled"> </td>
</tr>
<tr>	
<td>Address (*):</td>
<td><input name="address" value="<c:out value='${item.address}'/>" >
<td><input class="error" name="addressError" value="<c:out value='${errorMsgs.addressError}'/>"  disabled="disabled"> </td>
</tr>
<tr> 	
<td>Date of Birth (*):</td>
<td><input name="dob" value="<c:out value='${item.dob}'/>" >
<td><input class="error" name="dobError" value="<c:out value='${errorMsgs.dobError}'/>"  disabled="disabled"> </td> 
</tr>
<tr>	
<td>UTA ID (*):</td>
<td><input name="uta_id" value="<c:out value='${item.uta_id}'/>" >
<td><input class="error" name="uta_idError" value="<c:out value='${errorMsgs.uta_idError}'/>"  disabled="disabled"> </td>
</tr>
<tr> 	
<td>Auto Club Membership:</td>
<td><select name="auto_club_member"> 
<c:choose>
 <c:when test="${item.auto_club_member==0}">
 <option value="no" selected>No</option>
  <option value="yes">Yes</option>
 </c:when>
 <c:otherwise>
  <option value="no">No</option>
 <option value="yes" selected>Yes</option>
 </c:otherwise>
</c:choose>	
</select>  </td></tr>
 <tr>
 <td colspan="2">(*) Mandatory field</td>
 </tr>
 </c:forEach>
</table>
 <p> <input name="action" value="validateEditting" type="hidden"> 
<input name="submit" type="submit" value="Submit"> </p> 
</form>
</div>

<br><br><br>
<%@ include file = "Footer.jsp" %>