<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 
  <html> 
  <head> 
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> 
  <title>Insert title here</title> 
  
  <script type="text/javascript">
  
  function fn1() {
	  
	  var x=document.getElementById("fn");
	  var y=document.getElementById("ln");
	  var viewData=document.getElementById("viewData"); 
	  
	  var htp=new XMLHttpRequest(); 
	  
	  htp.onreadystatechange=function(){ 
		  //alert(htp.readyState); 
		
		  if(htp.readyState==4){ 
			
			  var op = JSON.parse(htp.responseText); 
			  
			  console.log('op',op); 
			  
			  var tableData = '<tr>'+'<td>Id.</td>' +'<td>First Name</td>'+ '<td>Last Name</td>' +'</tr>';
			  
			  if(op && op.length > 0){ 
				
				  for(var i = 0; i < op.length; i++){
					  var fn = op[i].fn;
					  var ln = op[i].ln; 
					  var id = op[i].registerId; 
					  tableData = tableData + '<tr><td>'+registerId+'</td>' +'<td>'+fn+'</td>'+ '<td>'+ln+'</td>' +'</tr>'; 
					  } 
				  
				  viewData.innerHTML = tableData; 
				  
			  }
			  
		  }
		  
	  }
	  htp.open("get","register?fn="+x.value+"&ln="+y.value,true);
	  htp.send(); 
	  } 
  </script> 
  </head>
  
   <body>
    <table border="1px solid black"> 
    
    <tr> <td>First_Name:</td>
     <td>
    <input type="text" name="fn" id="fn">
    </td> 
    </tr>
    
     <tr> <td>Last_Name:</td>
      <td>
    <input type="text" name="ln" id="ln">
    </td>
     </tr>
     
    <tr> <td><input type="button" value="Submit" onclick="fn1()"></td> </tr>
     
     </table> 
     
     <br> 
     <br> 
     
    <table border="1px solid black" id="viewData">
      
      <tr>
       
      <td>Firstname</td>
      <td>Lastname</td>
      
      </tr>
        
</table>
</body> 
</html>
	