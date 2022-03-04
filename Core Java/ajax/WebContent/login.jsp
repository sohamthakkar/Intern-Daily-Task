<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

 
<script type="text/javascript" >
 

function fn1()
    {
        
        var x=document.getElementById("un");
        var y=document.getElementById("pw");
        
        var htp=new XMLHttpRequest();
        
        htp.onreadystatechange=function(){
            /*
            There are five readyState of AJAX
                
                0=request not initialized
                1=request initialized
                2=process
                3=send
                4=response
                
            */    
            if(htp.readyState==4){
                        
                    alert(htp.responseText);
            }
        }
        
    htp.open("get","verifydynamic.jsp?un="+x.value+"&pw="+y.value,true);
    htp.send();
}

</script>
                
</head>

 
<body>

<table border="2px solid black"> 
<tr>
<td>USER NAME:</td>
<td><input type="text" id="un"/></td>
</tr>

<tr>
<td>PASSWORD:</td>
<td><input type="password" id="pw"/></td>
</tr>

<tr>
<td><input type="submit"  value="LOGIN" onclick="fn1()"/></td>
</tr>

<%
String s=(String)session.getAttribute("error");
if(s!=null)
{
	out.println(s);
}

session.removeAttribute("error");
%>

</table>
</body>
</html>