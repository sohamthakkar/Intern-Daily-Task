<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert State</title>
<style>
table, th, tr {
	border: 1px solid black;
	align: center;
	width: 280px;
	height: 25px;
}

input {
	width: 200px;
}

h3 {
	text-align: center;
}
</style>
</head>
<body>
	<%@ taglib prefix="spring"
		uri="http://www.springframework.org/tags/form"%>
	<center>
		<a href="searchState">Search State</a> <br>
		<spring:form action="insertState" method="post" modelAttribute="key">
			<table>
				<tr>
					<th colspan="2"><h3>Insert State</h3></th>
				</tr>
				<tr>
					<th>State :</th>
					<th><spring:input path="stateName" /></th>
				</tr>
				<tr>
					<th colspan="2"><spring:button>ADD STATE</spring:button></th>
				</tr>
			</table>
		</spring:form>
	</center>

</body>
</html>