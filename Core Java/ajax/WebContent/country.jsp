<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script>

function fn1()
    {
        var cn1=document.getElementById("cn");
        var st1=document.getElementById("st");
        
        var htp=new XMLHttpRequest();
        
        htp.onreadystatechange=function()	
            {
                if(htp.readyState==4)
                    {
                        var jsn=JSON.parse(htp.responseText);
                        
                        st1.innerHTML='';
                        
                        for(var i=0;i<jsn.length;i++)
                            {
                                var opt=document.createElement("option");
                                opt.value=jsn[i].sid;
                                opt.text=jsn[i].sname;
                                st1.options.add(opt);
                            }
                    }
            }
        htp.open("get","state.jsp",true);
        htp.send();
    }

</script>
</head>


<body>

COUNTRY:<select id="cn" onchange="fn1()">
    <option value="1">SELECT</option>
    <option value="2">INDIA</option>
    <option value="3">USA</option>
    <option value="4">RUSSIA</option>    
</select><br>


STATE:<select id="st">

    <option>SELECT</option>
        
</select>
</body>
</html>+