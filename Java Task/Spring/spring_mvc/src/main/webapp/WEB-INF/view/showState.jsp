<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@taglib prefix="f" uri="http://java.sun.com/jstl/core_rt"%>
	<center>
		<table border="1px">
			<tr>

				<th colspan="6"><h4>EMPLOYEE DATA</h4></th>
			</tr>
			<tr>

				<th>STATE</th>


			</tr>
			<f:forEach items="${State}" var="i">
				<tr>

					<td>${i.stateName}</td>

				</tr>
			</f:forEach>
		</table>
	</center>

</body>
</html>