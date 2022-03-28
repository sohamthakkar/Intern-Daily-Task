<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
String s2=request.getParameter("un");
String s3=request.getParameter("pw");

Class.forName("com.mysql.jdbc.Driver");
		
Connection con = DriverManager.getConnection("jdbc:mysql://localhost/demo", "root" , "root");
		
Statement st = con.createStatement();
		 
ResultSet rs = st.executeQuery("select * from register3 where user_name='"+s2+"'");

String s4="";
String s5="";
int i=0;

while(rs.next())
{
i=rs.getInt("id");
s4=rs.getString("user_name");
s5=rs.getString("password");
}

session.setAttribute("i",i);

if(s3.equals(s5))
{
	response.sendRedirect("wel.jsp");
}

else
{
	response.sendRedirect("login.jsp");
    session.setAttribute("error","incorrect password or username");
}
st.close();
con.close();
%>

</body>
</html>