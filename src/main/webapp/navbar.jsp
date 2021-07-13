<%--
  Created by IntelliJ IDEA.
  User: t_lamburov
  Date: 24.6.2021 г.
  Time: 14:56 ч.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div align="center">
    <div>
        <a href="${pageContext.request.contextPath}/">
            <img src="/resources/images/BookstoreLogo%20(1).png" alt="Book store logo"/>
        </a>
    </div>

    <div>
        <form action="search" method="get">
            <input type="text" name="keyword" size="50"/>
            <input type="submit" value="Search"/>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="login">Sign In</a>
            <a href="register_customer">Register</a>
            <a href="view_cart">Cart</a>
        </form>
    </div>
    <div>&nbsp;</div>
    <div>
        <c:forEach var="category" items="${allCategories}" varStatus="status">
            <a href="view_category?id=${category.categoryId}">
                <b><c:out value="${category.name}"/></b>
            </a>
            <c:if test="${not status.last}">
                &nbsp; | &nbsp;
            </c:if>
        </c:forEach>
    </div>
</div>