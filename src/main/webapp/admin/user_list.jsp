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
    <title>Manage user - Bookstore Administration</title>

</head>
<body>
<header>
    <jsp:directive.include file="header.jsp"/>
</header>

<div align="center">
    <h2>User Management</h2>
    <h3><a href="create_user">Create new User</a></h3>

</div>
<div align="center">

</div>
<div align="center">
    <table border="1" cellpadding="5">
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
                    <a href="edit_user?id=<c:out value='${user.userId}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="javascript:confirmDelete(${user.userId})">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

<footer>
    <jsp:directive.include file="footer.jsp"/>
</footer>
</body>
<script>
    function confirmDelete(userId) {
     if (confirm("Are you sure you want to delete the user with ID "+userId+"?")){
         window.location='delete_user?id='+userId;
     }
    }
</script>
</html>
