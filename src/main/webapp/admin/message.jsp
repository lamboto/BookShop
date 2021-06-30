<%--
  Created by IntelliJ IDEA.
  User: t_lamburov
  Date: 29.6.2021 г.
  Time: 17:56 ч.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Message - Bookstore Administration</title>
</head>
<body>
<header>
    <jsp:directive.include file="header.jsp"/>
</header>

<div align="center">
    <h3>${message}</h3>
</div>
<footer>
    <jsp:directive.include file="footer.jsp"/>
</footer>
</body>
</html>
