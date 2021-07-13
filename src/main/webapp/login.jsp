<%--
  Created by IntelliJ IDEA.
  User: t_lamburov
  Date: 13.7.2021 г.
  Time: 10:09 ч.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<header>
    <jsp:directive.include file="navbar.jsp"/>
</header>

<div align="center">
    <h2>Customer Login</h2>
    <form action="login" method="post">
        Email: <input type="text" id="email" name="email" size="10"></br>
        Password: <input type="password" id="password" name="password" size="10"/>
        <input type="submit" value="Login"/>
    </form>
</div>

<footer>
    <jsp:directive.include file="footer.jsp"/>
</footer>

</body>
</html>
