<%--
  Created by IntelliJ IDEA.
  User: t_lamburov
  Date: 25.6.2021 г.
  Time: 16:43 ч.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Manage users - Bookstore Administration</title>
</head>
<body>
<header>
    <jsp:directive.include file="header.jsp"/>
</header>

<div align="center">
    <h2>User Management</h2>
    <h3><a href="">Create new User</a></h3>
</div>
<div align="center">
    <table border="1">
        <tr>
            <th>Index</th>
            <th>Id</th>
            <th>Email</th>
            <th>Full Name</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="user" items="${listUsers}" varStatus="status">
            <tr>
                <td>${status.index+1}</td>
                <td>${user.userId}</td>
                <td>${user.email}</td>
                <td>${user.fullName}</td>
                <td>
                    <a href="">Edit</a> &nbsp;
                    <a href="">Delete</a> &nbsp;
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

<footer>
    <jsp:directive.include file="footer.jsp"/>
</footer>
</body>
</html>
