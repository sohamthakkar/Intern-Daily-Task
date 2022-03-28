<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display page</title>
</head>
<body>

	<%@taglib prefix="f" uri="http://java.sun.com/jstl/core_rt"%>
	<a href="welcome">Click Here for Add Employee</a> &nbsp;&nbsp;&nbsp;
	<a href="state">Click Here for insertState</a>
	<br>
	<br>
	<table border="1px" align="left">
		<tr>

			<th colspan="8"><h4>EMPLOYEE DATA</h4></th>
		</tr>
		<tr>
			<th>FIRSTNAME</th>
			<th>LASTNAME</th>
			<th>USERNAME</th>
			<th>PASSWORD</th>
			<th>CITY</th>
			<th>STATE</th>
			<th colspan="2" width="25px">ACTION</th>

		</tr>
		<f:forEach items="${EmpList}" var="i">
			<tr>
				<td>${i.firstName}</td>

				<td>${i.lastName}</td>

				<td>${i.cred.emailAddress}</td>

				<td>${i.cred.password}</td>

				<td>${i.city}</td>

				<td>${i.state.stateName}</td>

				<td><a href="delete?id=${i.id}">Delete</a></td>

				<td><a href="edit?id=${i.id}">Edit</a></td>

			</tr>
		</f:forEach>
	</table>


</body>
</html>