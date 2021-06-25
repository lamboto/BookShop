<%--
  Created by IntelliJ IDEA.
  User: t_lamburov
  Date: 24.6.2021 г.
  Time: 16:17 ч.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Bookstore Administration</title>
</head>
<body>
<header>
    <jsp:directive.include file="header.jsp"/>
</header>

<div align="center">
    <h2>Administrative Dashboard</h2>
</div>
<div align="center">
    <hr width="60%"/>
    <h2>Quick Actions:</h2>
    <b>
        <a href="create_book">New Book</a> &nbsp;
        <a href="create_user">New User</a> &nbsp;
        <a href="create_category">New Category</a> &nbsp;
        <a href="create_category">New Customer</a> &nbsp;
    </b>
</div>
<div align="center">
    <hr width="60%"/>
    <h2>Recent Sales:</h2>
</div>

<div align="center">
    <h2>Recent Reviews:</h2>
</div>

<div align="center">
    <h2>Statistics:</h2>
</div>

<footer>
    <jsp:directive.include file="footer.jsp"/>
</footer>
</body>
</html>
