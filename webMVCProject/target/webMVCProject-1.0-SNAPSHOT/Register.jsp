<%--
  Created by IntelliJ IDEA.
  User: BAPS
  Date: 2/4/2022
  Time: 11:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Signup User</title>
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
    <form action="userList" method="post">
        <input type="hidden" value="insert" name="flag">
        <table>
            <tr>
                <td>Enter your Name</td>
                <td><input type="text" name="fname" placeholder="First Name"></td>
            </tr>
            <tr>
                <td>Enter you Password</td>
                <td><input type="text" name="lname"  placeholder="Last Name"></td>
            </tr>
            <tr>
                <td>Enter you Mobile Number</td>
                <td><input type="number" name="mobile"  placeholder="Mobile Number"></td>
            </tr>
            <tr>
                <td>Enter you Email</td>
                <td><input type="email" name="email"  placeholder="Email Address"></td>
            </tr>
            <tr>
                <td><input type="checkbox" value="checked" name="condition">Terms And Condition</td>
            </tr>
            <tr></tr>

            <tr>
                <td><button type="submit" class="btn">Register</button></td>
                <td><button type="reset" class="btn">Reset</button></td>
            </tr>
            <tr><a href="userList">Users List</a></tr>
        </table>
    </form>
</div>


</body>
</html>
