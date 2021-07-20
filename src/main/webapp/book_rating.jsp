<%--
  Created by IntelliJ IDEA.
  User: t_lamburov
  Date: 20.7.2021 г.
  Time: 14:22 ч.
  To change this template use File | Settings | File Templates.
--%>
<c:forTokens items="${book.ratingStars}" delims="," var="star">
    <c:if test="${star eq 'on'}">
        <img src="resources/images/rating_on.png"/>
    </c:if>
    <c:if test="${star eq 'off'}">
        <img src="resources/images/rating_off.png"/>
    </c:if>
    <c:if test="${star eq 'half'}">
        <img src="resources/images/rating_half.png"/>
    </c:if>
</c:forTokens>