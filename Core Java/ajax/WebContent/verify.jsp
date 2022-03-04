<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%

String s1=request.getParameter("un");
String s2=request.getParameter("pw");
 

if(s1.equals("admin") && s2.equals("admin"))
    {
        out.println("HELLO ! ADMIN");
    }
else
    {
        out.println("WRONG USERNAME OR PASSWORD !");
    }

%>
</body>
</html>