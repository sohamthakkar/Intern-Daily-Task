<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
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
<body class="container">

<h1><a href="InsertEmployee.jsp">Insert Employee</a></h1>
<h1><a href="InsertProject.jsp">Insert Project</a></h1>
<h1><a href="employeeServlet?flag=search">List Employee</a></h1>
</body>
</html>