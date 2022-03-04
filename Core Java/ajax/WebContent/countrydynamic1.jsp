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
        var countryId=document.getElementById("country");
        var stateId=document.getElementById("state");
        
        var htp=new XMLHttpRequest();
        
        htp.onreadystatechange=function()
            {
                if(htp.readyState==4)
                    {
                        var jsn=JSON.parse(htp.responseText);
                        
                        stateId.innerHTML='';
                        
                        alert(htp.responseText);
                        
                        for(var i=0;i<jsn.length;i++)
                            {
                                var opt=document.createElement("option");
                                opt.value=jsn[i].stateId;
                                opt.text=jsn[i].stateName;
                                stateId.options.add(opt);
                            }
                    }
            }
        htp.open("get","state?con="+countryId.value+"&flag=search",true);        //changes to be done over here
        htp.send();
    }

function loadcity(){
	
      var stateId=document.getElementById("state");
      var cityId=document.getElementById("city");

      var htp=new XMLHttpRequest();
      
      htp.onreadystatechange=function()
          {
              if(htp.readyState==4)
                  {
                      var jsn=JSON.parse(htp.responseText);
                      
                      cityId.innerHTML='';
                      
                      alert(htp.responseText);
                      
                      for(var i=0;i<jsn.length;i++)
                          {
                              var opt=document.createElement("option");
                              opt.value=jsn[i].cityId;
                              opt.text=jsn[i].cityName;
                              cityId.options.add(opt);
                          }
                  }
          }
      htp.open("get","city?sta="+stateId.value+"&flag=search",true);        //changes to be done over here
      htp.send();
}

</script>


</head>

<body>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>


Country<select name="countryId" id="country" onchange="fn1()">

<option>Select</option>

<c:forEach items="${sessionScope.countrylist}" var="p">

<option value="${p.countryId }">${p.countryName}</option>

</c:forEach>

</select>


State<select name="stateId" id="state" onchange="loadcity()">

<option>Select</option>

<c:forEach items="${sessionScope.statelist}" var="p">

<option value="${p.stateId }">${p.stateName}</option>

</c:forEach>

</select>


City<select name="cityId" id="city">

<option>Select</option>

<c:forEach items="${sessionScope.citylist}" var="p">

<option value="${p.cityId }">${p.cityName}</option>

</c:forEach>

</select>

</body>
</html>