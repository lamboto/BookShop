<%--
  Created by IntelliJ IDEA.
  User: t_lamburov
  Date: 24.6.2021 г.
  Time: 14:54 ч.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Admin Login</title>
</head>
<body>

<header>
    <jsp:directive.include file="header.jsp"/>
</header>

<div align="center">
    <h2>Login form:</h2>
    <form>
        Email: <input type="text" size="10"></br>
        Password: <input type="password" size="10"/>
        <input type="submit" value="Login"/>
    </form>
</div>

<footer>
    <jsp:directive.include file="../footer.jsp"/>
</footer>

</body>
</html>
