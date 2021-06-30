<%--
  Created by IntelliJ IDEA.
  User: t_lamburov
  Date: 30.6.2021 г.
  Time: 14:41 ч.
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
    <h2>Category Management</h2>
    <h3><a href="create_user">Create new Category</a></h3>
</div>
<div align="center">

</div>
<div align="center">
    <table border="1" cellpadding="5">
        <tr>
            <th>Index</th>
            <th>Id</th>
            <th>Category Name</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="category" items="${listCategories}" varStatus="status">
            <tr>
                <td>${status.index+1}</td>
                <td>${category.categoryId}</td>
                <td>${category.name}</td>
                <td>
                    <a href="edit_user?id=<c:out value='${category.categoryId}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="javascript:confirmDelete(${category.categoryId})">Delete</a>
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
    function confirmDelete(categoryId) {
        if (confirm("Are you sure you want to delete the category with ID "+categoryId+"?")){
            window.location='delete_category?id='+categoryId;
        }
    }
</script>
</html>
