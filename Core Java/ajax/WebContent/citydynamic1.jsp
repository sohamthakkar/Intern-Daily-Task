<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions"%>

 

<c:set var="citylist" value="${sessionScope.citylist}"></c:set>

 

<c:set var="lengthofList" value="${f:length(citylist)}"></c:set>

 

[
    <c:forEach var="i" items="${citylist}" varStatus="j">
    {
    "cityId":"${i.cityId}",
    "cityName":"${i.cityName}"
    
    }
    
    
    
    <c:if test="${j.count ne lengthofList}">,</c:if>
    </c:forEach>
]