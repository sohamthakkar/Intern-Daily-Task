<%@ page import="com.example.model.Department" %>
<%@ page import="com.example.dao.DepartmentDao" %>
<%@ page import="java.util.List" %>
<%@ page import="java.io.PrintWriter" %>
<%--

  Created by IntelliJ IDEA.
  User: BAPS
  Date: 2/9/2022
  Time: 11:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Employee Edit</title>
    <style>
        .container{
            width: 40%;
            border: 1px solid black;
            margin:  auto;
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
    <h1>Update From</h1>
    <form action="employeeController" method="post">
        <input type="hidden" value="update" name="flag">

        <table>
            <c:forEach  var="i" items="${sessionScope.List}">
            <tr>
                <td>ID</td>
                <td><input type="text" name="empName" placeholder="Employee Name" value="${i.empId}" readonly></td>
            </tr>
            <tr>

                <td>Dept Id: </td>

                <td><input type="text" name="Department Name" value="${i.deptId.deptId}" readonly></td>
            </tr>
            <tr>
                <td>Enter Employee Name</td>
                <td><input type="text" name="empName" placeholder="Employee Name" value="${i.empName}"></td>
            </tr>
            <tr>
                <tr>
                    <td>Department:</td>
                    <td>
                        <select name="deptId">

                        <option value="${i.deptId.deptId}" selected>${i.deptId.deptName}</option>
                        <c:forEach var="j" items="${sessionScope.AllList}">
                            <c:if test="${j.deptId ne i.deptId.deptId}">
                                <option value="${j.deptId}">${j.deptName}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                    </td>
                </tr>
            </tr>
            </c:forEach>
            <tr>
                <td><button type="submit" class="btn">Upadte</button></td>

            </tr>

        </table>

    </form>
</div>


</body>
</html>
