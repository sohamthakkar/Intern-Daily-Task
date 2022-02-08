<%--
  Created by IntelliJ IDEA.
  User: BAPS
  Date: 2/7/2022
  Time: 1:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
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
    <title>Update data</title>
</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>


    <form action="StudentServlet" method="get">

        <h2>Update Data</h2>

        <div class="container">
            <input type="hidden" value="update" name="flag">
            <c:forEach var="i" items="${sessionScope.EditList}">
            <table>

                <tr>
                    <td>User ID</td>
                    <td><input type="text" name="id" value="${i.id}" readonly></td>
                </tr>
                <tr>
                    <td>Enter your Name</td>
                    <td><input type="text" name="fname" value="${i.studentFn}" placeholder="First Name"></td>
                </tr>
                <tr>
                    <td>Enter you LastName</td>
                    <td><input type="text" name="lname" value="${i.studentLn}"  placeholder="Last Name"></td>
                </tr>
                <tr>
                    <td>Enter you Mobile Number</td>
                    <td><input type="number" name="mobile" value="${i.studentMobile}"  placeholder="Mobile Number"></td>
                </tr>
                <tr>
                    <td>Enter you Email</td>
                    <td><input type="email" name="email" value="${i.studentEmail}"  placeholder="Email Address"></td>
                </tr>

                <tr>
                    <td>Enter your Address</td>
                    <td><input type="text" name="address" value="${i.studentAddress}" placeholder="Address"></td>
                </tr>

                <tr>
                    <td><button type="submit" value="Update" class="btn">Register</button></td>
                </tr>

            </table>
            </c:forEach>
        </div>

    </form>


</body>
</html>
