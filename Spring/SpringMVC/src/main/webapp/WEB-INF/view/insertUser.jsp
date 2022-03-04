<%--
  Created by IntelliJ IDEA.
  User: BAPS
  Date: 2/20/2022
  Time: 10:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Insert User</title>
</head>
<body>

<div class="container">
    <spring:form action="insert" method="post" modelAttribute="key">
        <table>
            <tr>
                <th>Enter Name</th>
                <th><spring:input path="name"/> </th>
            </tr>
            <tr>
                <th>Enter Email</th>
                <th><spring:input path="email"/></th>
            </tr>
            <tr>
                <th>Enter Mobile</th>
                <th><spring:input path="mobile"/></th>
            </tr>
            <tr>
                <th></th>
                <th><spring:button>Submit</spring:button></th>
            </tr>
        </table>
    </spring:form>
</div>


</body>
</html>
