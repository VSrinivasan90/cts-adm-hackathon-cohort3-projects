<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>
    Test Add Beneficiary
</title>
</head>
<body>
<%-- <form:form method="POST" modelAttribute="beneficiary">
	Name: <form:input path="name" type="text" required="required"></form:input>  <br><br>
	Nickname: <form:input path="nickname" type="text" required="required"></form:input> <br><br>
	Bene Account Number: <form:input path="beneaccountnumber" type="text" required="required"></form:input> <br><br>
	<input type="Submit" value="Submit"> <br><br>
</form:form> --%>
<form action="/beneficiary" method="POST">
	New Name: <input name="name" type="text" ></input>  <br><br>
	Nickname: <input name="nickname" type="text" required="required"></input> <br><br>
	Bene Account Number: <input name="beneaccountnumber" type="text" required="required"></input> <br><br>
	<input type="Submit" value="Submit"> <br><br>
</form>
</body>
</html>