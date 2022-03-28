<%--
  Created by IntelliJ IDEA.
  User: BAPS
  Date: 2/12/2022
  Time: 3:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EmployeeList</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .container{
            width: 40%;
            border: 1px solid black;
            margin-top: 20px;
            margin: auto;
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
<div class="container">
    <h2>List Employee</h2>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
    <table border="1px solid black" class="table table-dark">
        <input type="hidden" name="flag" value="search">
        <tr>
            <td>Id</td>
            <td>Employee Name</td>
            <td>Assign</td>
            <td>Delete</td>
        </tr>
        <c:forEach var="i" items="${sessionScope.empList}" >
            <tr>
                <td>${i.employeeId}</td>
                <td>${i.employeeName}</td>
                <td><a href="employeeServlet?flag=edit&id=${i.employeeId}">Assign</a></td>
                <td><a href="employeeServlet?flag=delete&id=${i.employeeId}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
