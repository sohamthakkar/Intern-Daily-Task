<%--
  Created by IntelliJ IDEA.
  User: BAPS
  Date: 2/8/2022
  Time: 11:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Department</title>
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
    <h1>Registration From</h1>
    <form action="DepartmentController" method="post">
        <input type="hidden" name="flag" value="insert" >
        <table>
            <tr>
                <td>Enter Department Name</td>
                <td><input type="text" name="nameDept"  placeholder="Department Number"></td>
            </tr>
            <tr>
                <td><button type="submit" class="btn">Register</button></td>
                <td><button type="reset" class="btn">Reset</button></td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>
