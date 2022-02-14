<%--
  Created by IntelliJ IDEA.
  User: BAPS
  Date: 2/12/2022
  Time: 11:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Insert Employee</title>
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
    <h2>Insert Employee</h2>
    <form action="employeeServlet" method="post">
        <table>
            <input type="hidden" name="flag" value="insertEmp">
            <tr>
                <td>Insert Employees</td>
                <td><input type="text" name="insertEmp" placeholder="enter Employee"></td>
            </tr>
            <tr>
                <td><button type="submit" class="btn"> Submit</button></td>
            </tr>
        </table>
    </form>

</div>

</body>
</html>
