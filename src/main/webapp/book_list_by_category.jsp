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
    <h2>${category.name}</h2>
</div>

<div align="center" style="width: 80%;margin: 0 auto">
    <c:forEach items="${listBooks}" var="book">
        <div style="float: left; display: inline-block; margin: 20px">
            <div>
                <a href="view_book?id=${book.bookId}">
                    <img src="data:image/jpg;base64,${book.base64Image}" width="128" height="164"/>
                </a>
            </div>
            <div>
                <a href="view_book?id=${book.bookId}">
                    <b>${book.title}</b>
                </a>
            </div>
            <div>
                <jsp:directive.include file="book_rating.jsp"/>
            </div>
            <div><i></i>by ${book.author}</div>
            <div><b>$${book.price}</b></div>
        </div>
    </c:forEach>
</div>


<footer>
    <jsp:directive.include file="footer.jsp"/>
</footer>
</body>
</html>
