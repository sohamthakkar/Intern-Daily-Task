<%--
  Created by IntelliJ IDEA.
  User: BAPS
  Date: 2/12/2022
  Time: 3:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Assign Employee</title>
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
    <form action="employeeServlet" method="post">
        <input type="hidden" value="update" name="flag">

        <table>
            <c:forEach  var="i" items="${sessionScope.empList}">
                <tr>
                    <td>ID</td>
                    <td><input type="text" name="empId" placeholder="Employee Name" value="${i.employeeId}" readonly></td>
                </tr>
                <tr>
                    <td>Employee Name</td>
                    <td><input type="text" name="empName" placeholder="Employee Name" value="${i.employeeName}" readonly></td>
                </tr>
                <tr>
                <tr>
                    <td>Projects:</td>
                    <td>
                        <c:forEach var="j" items="${sessionScope.projets}">
                            <input type="checkbox" name="proId" value="${j.projectId}">${j.projectName}
                        </c:forEach>
                    </td>
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
