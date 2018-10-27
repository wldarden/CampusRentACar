<%@ include file = "Header.jsp" %>

<title>Confirm</title>
<div id="horizontalLinks">
<a href="Updateownprofile.jsp">Update Profile|</a>
<a href="Logout">Logout|</a>
</div>

<div id="main">
<h2>Confirmation</h2>
<form action="<%=request.getContextPath() %>/Confirm?action=Confirm" method="post">
<input name="errMsg"  value="<c:out value='${errorMsgs.errorMsg}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 401px" disabled="disabled">
<table>
<tr>
<td>Rental ID</td>
<td> <input name="id" value="<c:out value='${systemUser.id}'/>" style="width: 275px; "> </td>
<td><input name = "rental_idError" value = "<c:out value='${errorMsgs.getRentalIDerror()}'/>" type="text" style="background-color: white; color: red; border: none; width: 400px" disabled = "disabled" maxlength="60"></td>
</tr>
<tr>
<td> Card type: </td>
<td><select name="card_type"> 
	<option value="american">American</option>
	<option value="master">MasterCard</option>
	<option value="visa">Visa</option>
	<option value="discover">Discover</option>
</select>  </td>
</tr>
<tr>
<td>Credit card number</td>
<td> <input name="cardNumber" value="<c:out value='${systemUser.cardNumber}'/>" style="width: 275px; "> </td>
<td><input name = "cvvError" value = "<c:out value = '${errorMsgs.getCrediterror()}'/>" type="text" style="background-color: white; color: red; border: none; width: 404px" disabled = "disabled" maxlength="60"></td>
</tr>
<tr>
<td>Card holder</td>
<td> <input name="cardholder" value="<c:out value='${systemUser.name}'/>" style="width: 275px; " > </td>
<td><input name = "cvvError" value = "<c:out value = '${errorMsgs.getHoldererror()}'/>" type="text" style="background-color: white; color: red; border: none; width: 404px" disabled = "disabled" maxlength="60"></td>
</tr>
<tr>
<td> Expiry Month: </td>
<td><select name="expiry_month"> 
	<option value="1">01</option>
	<option value="2">02</option>
	<option value="3">03</option>
	<option value="4">04</option>
	<option value="5">05</option>
	<option value="6">06</option>
	<option value="7">07</option>
	<option value="8">08</option>
	<option value="9">09</option>
	<option value="10">10</option>
	<option value="11">11</option>
	<option value="12">12</option>
</select>  </td>
</tr>
<tr>
<td> Expiry year: </td>
<td><select name="expiry_year"> 
	<option value="2019">2019</option>
	<option value="2020">2020</option>
	<option value="2021">2021</option>
	<option value="2022">2022</option>
	<option value="2023">2023</option>
	<option value="2024">2024</option>
	<option value="2025">2025</option>
	<option value="2026">2026</option>
	<option value="2027">2027</option>
	<option value="2028">2028</option>
	<option value="2029">2029</option>
</select>  </td>
</tr>
<tr>
<td>CVV</td>
<td> <input name="cvv" value="<c:out value='${ConfirmModel.cvv}'/>" style="width: 275px; "> </td>
<td><input name = "cvvError" value = "<c:out value = '${errorMsgs.getCVVerror()}'/>" type="text" style="background-color: white; color: red; border: none; width: 404px" disabled = "disabled" maxlength="60"></td>
</tr>
</table>

<input type="submit" value="Submit">


<a href="NewFile.jsp">|Back to welcome page|</a>

</div>

<div id="footer">
University of Texas at Arlington <br>
CSE 6329-001 Class Project, Fall 2018 <br>
Team 3 <br>
</div>
</div>
</body>
</html>