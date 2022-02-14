<%--
  Created by IntelliJ IDEA.
  User: BAPS
  Date: 2/3/2022
  Time: 5:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
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
    <title>Users list</title>
</head>
<body>

<div class="container">
    <form action="userList" method="get">
        <input type="hidden" name="flag" value="search"> <input
            type="submit" value="SearchAll">
    </form>
</div>

<div class="container">
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
    <table border="1px solid black" class="table table-dark">
        <thead>
        <tr>
            <th>ID</th>
            <th scope="col">First Name</th>
            <th scope="col">Last Name</th>
            <th scope="col">Mobile</th>
            <th scope="col">Email</th>
            <th>Edit User</th>
            <th>Delete User</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="i" items="${sessionScope.UserList}">
            <tr>
                <td>${i.id}</td>
                <td>${i.fname}</td>
                <td>${i.lname}</td>
                <td>${i.mobile}</td>
                <td>${i.email}</td>
                <td><a href="userList?id=${i.id}&flag=edit">Edit</a></td>
                <td><a href="userList?id=${i.id}&flag=delete">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
