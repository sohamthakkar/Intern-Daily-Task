<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>update data</title>
	<style>
		.container{
			width: 40%;
			border: 1px solid black;
			margin:  auto;
			margin-top: 20px;
			padding: 10px;
		}
		.btn{
			width: 100%;
			height: 30px;
			background: black;
			color: aliceblue;
		}
	</style>
</head>
<body>
	<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

	<c:forEach var="i" items="${sessionScope.EditUser}">
		<form action="userList" method="get">
			<h2>Update Data</h2>
			<div class="container">
			<input type="hidden" value="insert" name="flag">
			<input type="hidden"  name="id" value="${i.id}">
			<table>
				<tr>
					<td>User ID</td>
					<td><input type="text" name="id" value="${i.id}" readonly></td>
				</tr>
				<tr>
					<td>Enter your Name</td>
					<td><input type="text" name="fname" value="${i.fname}" placeholder="First Name"></td>
				</tr>
				<tr>
					<td>Enter you LastName</td>
					<td><input type="text" name="lname" value="${i.lname}"  placeholder="Last Name"></td>
				</tr>
				<tr>
					<td>Enter you Mobile Number</td>
					<td><input type="number" name="mobile" value="${i.mobile}"  placeholder="Mobile Number"></td>
				</tr>
				<tr>
					<td>Enter you Email</td>
					<td><input type="email" name="email" value="${i.email}"  placeholder="Email Address"></td>
				</tr>
				<tr></tr>

				<tr>
					<td><button type="submit" value="Update" class="btn">Register</button></td>
				</tr>
			</table>
			</div>
		</form>
	</c:forEach>

</body>
</html>