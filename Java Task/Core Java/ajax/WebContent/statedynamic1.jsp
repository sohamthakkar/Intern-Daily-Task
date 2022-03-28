<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions"%>

 

<c:set var="statelist" value="${sessionScope.statelist}"></c:set>

 

<c:set var="lengthofList" value="${f:length(statelist)}"></c:set>

 

[
    <c:forEach var="i" items="${statelist}" varStatus="j">
    {
    "stateId":"${i.stateId}",
    "stateName":"${i.stateName}"
    
    }
    
    
    
    <c:if test="${j.count ne lengthofList}">,</c:if>
    </c:forEach>
]