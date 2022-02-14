<%--
  Created by IntelliJ IDEA.
  User: BAPS
  Date: 2/8/2022
  Time: 2:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
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
    <form action="DepartmentController" method="get">
        <input type="hidden" class="btn" name="flag" value="search"> <input
            type="submit" value="SearchAll">
    </form>
</div>
<div class="container">
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
    <table border="1px solid black" class="table table-dark">
        <thead>
        <tr>
            <th>ID</th>
            <th>Department Name</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="i" items="${sessionScope.DeptList}">
            <tr>
                <td>${i.deptId}</td>
                <td>${i.deptName}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
