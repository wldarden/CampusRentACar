<%@ include file = "Header.jsp" %>

<title>Find Available Car</title>
<div id="horizontalLinks">
<a href="<%=request.getContextPath()%>/Manager.jsp">HomePage</a>
<a href="<%=request.getContextPath()%>/Logout">Logout</a>
</div>

<div id="main">

<form name="ManagerController" action="<%=request.getContextPath()%>/ManagerController?action=viewAvailableCar" method="post" >
<input class="error" name="errMsg" value="<c:out value='${errorMsgs.errorMsg}'/>" disabled="disabled"> 
<table>
<tr>
<td> Start Time (yyyy-MM-dd HH:mm:ss) (*): </td> 
<td> <input name="start_time" value="<c:out value='${systemUser.user_name}'/>" >
<td><input class="error" name="StartTimeError" value="<c:out value='${errorMsgs.getStarttimeError()}'/>"  disabled="disabled"> </td>
</tr>
<tr>	
<td> End Time (yyyy-MM-dd HH:mm:ss) (*): </td>
<td><input name="return_time" value="<c:out value='${systemUser.password}'/>" > 
<td><input class="error" name="ReturnTimeError" value="<c:out value='${errorMsgs.getReturnTimeError()}'/>"  disabled="disabled"> </td>
</tr>

 <tr>
 <td colspan="2">(*) Mandatory field</td>
 </tr>
</table>
 <p> <input name="action" value="insertSystemUser" type="hidden"> 
<input name="submit" type="submit" value="submit">


</p> 
</form>
</div>

<%@ include file = "Footer.jsp" %>