<%--
  Created by IntelliJ IDEA.
  User: BAPS
  Date: 2/8/2022
  Time: 10:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee List</title>
    <style>
        .container{
            width: 60%;
            border: 1px solid black;
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
<div class="container">
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

    <form action="employeeController?flag=insert" method="post">
        <button type="submit" class="btn">Add Employee</button>
    </form>
    <table border="1px solid black" class="table table-dark">
        <thead>
        <tr>
            <th>ID</th>
            <th>Employee Name</th>
            <th>Department Name</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="i" items="${sessionScope.List}">
            <tr>
                <td>${i.empId}</td>
                <td>${i.empName}</td>
                <td>${i.deptId.deptName}</td>
                <td><a href="employeeController?id=${i.empId}&flag=edit">Edit</a></td>
                <td><a href="employeeController?id=${i.empId}&flag=delete">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
