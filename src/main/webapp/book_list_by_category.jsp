<%--
  Created by IntelliJ IDEA.
  User: t_lamburov
  Date: 6.7.2021 г.
  Time: 15:25 ч.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Books in ${category} - Online Books Store</title>
</head>
<body>

<header>
    <jsp:directive.include file="navbar.jsp"/>
</header>

<div align="center">
    <c:forEach items="${listBooks}" var="book">
        <div>
            <div>
                <img src="data:image/jpg;base64,${book.base64Image}" width="84" height="110"/>
            </div>
            <div>${book.title}</div>
        </div>
    </c:forEach>
</div>

<footer>
    <jsp:directive.include file="footer.jsp"/>
</footer>
</body>
</html>
