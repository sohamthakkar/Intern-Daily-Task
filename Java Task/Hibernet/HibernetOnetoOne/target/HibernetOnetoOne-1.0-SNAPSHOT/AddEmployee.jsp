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
    <title>Title</title>
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
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<div class="container">
    <h1>Registration From</h1>
    <form action="employeeController" method="post">
        <input type="hidden" value="insert" name="flag">
        <table>
            <tr>
                <td>Enter Employee Name</td>
                <td><input type="text" name="empName" placeholder="Employee Name"></td>
            </tr>
            <tr>

                <td>Dept Name: </td>
                <td>
                    <select name="deptId">

                        <c:forEach  var="i" items="${sessionScope.List}">
                            <option value="${i.deptId}">${i.deptName}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr></tr>

            <tr>
                <td><button type="submit" class="btn">Register</button></td>
                <td><button type="reset" class="btn">Reset</button></td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>
