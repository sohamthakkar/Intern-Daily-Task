<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Here</title>

<style>
table, tr, td {
	border: 1px solid black;
	width: 300px;
	height: 25px;
}

input {
	width: 200px;
}

select {
	width: 207px;
	height: 22px;
}

h3 {
	text-align: center;
}
</style>
</head>
<body>
	<%@ taglib prefix="s" uri="http://java.sun.com/jstl/core_rt"%>
	<%@ taglib prefix="spring"
		uri="http://www.springframework.org/tags/form"%>
	<center>
		<a href="search">Search Result</a>
		<spring:form action="insert" method="post" modelAttribute="key">
			<table>

				<spring:hidden path="id" />
				<spring:hidden path="cred.credId" />
				<tr>

					<td colspan="2"><h3>Register Here</h3></td>

				</tr>

				<tr>
					<td>FirstNames:</td>
					<td><spring:input path="firstName" /></td>

				</tr>
				<tr>
					<td>LastName:</td>
					<td><spring:input path="lastName" /></td>

				</tr>
				<tr>
					<td>EmailId:</td>
					<td><spring:input path="cred.emailAddress" /></td>

				</tr>
				<tr>
					<td>Password:</td>
					<td><spring:input path="cred.password" /></td>

				</tr>
				<tr>
					<td>City:</td>
					<td><spring:input path="city" /></td>

				</tr>

				<tr>
					<td>State:</td>

					<td><spring:select path="state.stateId">
							<spring:option value="SELECT" label="SELECT" />
							<s:forEach items="${State}" var="i">
								<spring:option value="${i.stateId}" label="${i.stateName}" />
							</s:forEach>
						</spring:select></td>

				</tr>


				<tr>
					<td colspan="2" align="center"><spring:button>REGISTER</spring:button></td>
				</tr>
			</table>
		</spring:form>



	</center>

</body>
</html>