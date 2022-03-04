<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ taglib prefix="spring"
		uri="http://www.springframework.org/tags/form"%>
	<center>
		<h1>Register Here</h1>
		<spring:form action="update" method="post" modelAttribute="key">
			<table>
				<tr>
					
					<th><spring:hidden path="id" /></th>
				</tr>

				<tr>
					<th>FirstName :</th>
					<th><spring:input path="firstName" /></th>
				</tr>
				<tr>
					<th>LastName :</th>
					<th><spring:input path="lastName" /></th>
				</tr>
				<tr>
					<th>EmailId :</th>
					<th><spring:input path="emailAddress" /></th>
				</tr>
				<tr>
					<th>Password :</th>
					<th><spring:input path="password" /></th>
				</tr>
				<tr>

					<th align="center"><spring:button>Update</spring:button></th>
				</tr>
			</table>
		</spring:form>

		<a href="search">Search Result</a>
	</center>


</body>
</html>