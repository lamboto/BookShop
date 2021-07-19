<%--
  Created by IntelliJ IDEA.
  User: t_lamburov
  Date: 19.7.2021 г.
  Time: 11:10 ч.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Manage reviews - Bookstore Administration</title>

</head>
<body>
<header>
    <jsp:directive.include file="header.jsp"/>
</header>

<div align="center">
    <h2>Review Management</h2>
</div>
<div align="center">

</div>
<div align="center">
    <table border="1" cellpadding="5">
        <tr>
            <th>Index</th>
            <th>Id</th>
            <th>Rating</th>
            <th>Headline</th>
            <th>Customer</th>
            <th>Review On</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="review" items="${listReviews}" varStatus="status">
            <tr>
                <td>${status.index+1}</td>
                <td>${review.reviewId}</td>
                <td>${review.rating}</td>
                <td>${review.headline}</td>
                <td>${review.customer.fullName}</td>
                <td>${review.headline}</td>
                <td>
                    <a href="edit_review?id=<c:out value='${review.reviewId}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="javascript:confirmDelete(${review.reviewId})">Delete</a>
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
    function confirmDelete(reviewId) {
        if (confirm("Are you sure you want to delete the review with ID "+reviewId+"?")){
            window.location='delete_review?id='+reviewId;
        }
    }
</script>
</html>