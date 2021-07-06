<%--
  Created by IntelliJ IDEA.
  User: t_lamburov
  Date: 2.7.2021 г.
  Time: 17:13 ч.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Manage book - Bookstore Administration</title>

</head>
<body>
<header>
    <jsp:directive.include file="header.jsp"/>
</header>

<div align="center">
    <h2>Book Management</h2>
    <h3><a href="create_book">Create new Book</a></h3>
</div>
<div align="center">

</div>
<div align="center">
    <table border="1" cellpadding="5">
        <tr>
            <th>Index</th>
            <th>Id</th>
            <th>Image</th>
            <th>Title</th>
            <th>Author</th>
            <th>Category</th>
            <th>Price</th>
            <th>Last Updated</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="book" items="${listBooks}" varStatus="status">
            <tr>
                <td>${status.index+1}</td>
                <td>${book.bookId}</td>
                <td><img src="data:image/jpg;base64,${book.base64Image}" width="84" height="110"/></td>
                <td>${book.title}</td>
                <td>${book.author}</td>
                <td>${book.category.name}</td>
                <td>$${book.price}</td>
                <td>${book.lastUpdateTime}</td>

                <td>
                    <a href="edit_book?id=<c:out value='${book.bookId}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="javascript:confirmDelete(${book.bookId})">Delete</a>
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
    function confirmDelete(bookId) {
        if (confirm("Are you sure you want to delete the book with ID "+bookId+"?")){
            window.location='delete_book?id='+bookId;
        }
    }
</script>
</html>
