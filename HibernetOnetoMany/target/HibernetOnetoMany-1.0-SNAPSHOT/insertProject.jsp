<%--
  Created by IntelliJ IDEA.
  User: BAPS
  Date: 2/10/2022
  Time: 2:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Insert Projects</title>
</head>
<body>
<div>
    <h1>Enter Your Project Name</h1>
    <form action="EmployeeController" method="post">
        <table>
            <input type="hidden" name="flag" value="insert">
            <tr>
                <th>Enter yout Project Name: </th>
                <th><input type="text" name="projectName" placeholder="Project Name"></th>
            </tr>
            <tr>
                <th><input type="submit" value="submit" class="btn"/></th>
            </tr>
        </table>
    </form>
</div>

</body>
</html>
