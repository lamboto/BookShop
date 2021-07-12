<%--
  Created by IntelliJ IDEA.
  User: t_lamburov
  Date: 12.7.2021 г.
  Time: 12:19 ч.
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
    <h2>Customer Management</h2>
    <h3><a href="create_customer">Create new Customer</a></h3>
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
            <th>City</th>
            <th>Country</th>
            <th>Registered Date</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="customer" items="${listCustomers}" varStatus="status">
            <tr>
                <td>${status.index+1}</td>
                <td>${customer.customerId}</td>
                <td>${customer.email}</td>
                <td>${customer.fullName}</td>
                <td>${customer.city}</td>
                <td>${customer.country}</td>
                <td>${customer.registerDate}</td>
                <td>
                    <a href="edit_customer?id=<c:out value='${customer.customerId}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="javascript:confirmDelete(${customer.customerId})">Delete</a>
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
    function confirmDelete(customerId) {
        if (confirm("Are you sure you want to delete the customer with ID "+customerId+"?")){
            window.location='delete_customer?id='+customerId;
        }
    }
</script>
</html>