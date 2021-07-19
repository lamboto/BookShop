<%--
  Created by IntelliJ IDEA.
  User: t_lamburov
  Date: 25.6.2021 г.
  Time: 10:24 ч.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div align="center">
    <div>
        <a href="${pageContext.request.contextPath}/admin">

            <img src="/resources/images/BookstoreLogo%20(1).png" alt="Book store logo">
        </a>
    </div>
    <div>
        <c:if test="${userEmail != null}">
            <br/>
            Welcome Admin, <c:out value="${userEmail}"/> | <a href="logout">Logout</a>
            <br/>
        </c:if>
        <c:if test="${userEmail == null}">
            <br/>
            <a href="login">Login</a>
            <br/>
        </c:if>
    </div>
    <div>
        <br/>
        <b>
            <a href="list_users">Users</a> &nbsp;
            <a href="list_categories">Categories</a> &nbsp;
            <a href="list_books">Books</a> &nbsp;
            <a href="list_customers">Customers</a> &nbsp;
            <a href="list_reviews">Reviews</a> &nbsp;
            <a href="orders">Orders</a> &nbsp;
        </b>
    </div>
</div>