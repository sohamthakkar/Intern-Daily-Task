<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions"%>

 

<c:set var="list" value="${sessionScope.list}"></c:set>
 

<c:set var="lengthofList" value="${f:length(list)}"></c:set>

 

[
    <c:forEach var="i" items="${list}" varStatus="j">
    {
    "registerId":"${i.registerId}",
    "firstname":"${i.fn}",
    "lastname":"${i.ln}"
    
    }
    
    
    
    <c:if test="${j.count ne lengthofList}"></c:if>    
    </c:forEach>
]