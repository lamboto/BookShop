<%--
  Created by IntelliJ IDEA.
  User: t_lamburov
  Date: 13.7.2021 г.
  Time: 12:35 ч.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Profile - Online Books Store</title>
</head>
<body>
<header>
    <jsp:directive.include file="navbar.jsp"/>
</header>

<div align="center">
    <br/>
    <h2>Welcome, ${loggedCustomer.fullName}</h2>
    <br/>

    <table border="0">
        <tr>
            <td><b>Email Address:</b></td>
            <td>${loggedCustomer.email}</td>
        </tr>
        <tr>
            <td><b>Full Name:</b></td>
            <td>${loggedCustomer.fullName}</td>
        </tr>
        <tr>
            <td><b>Phone Number:</b></td>
            <td>${loggedCustomer.phone}</td>
        </tr>
        <tr>
            <td><b>Address:</b></td>
            <td>${loggedCustomer.address}</td>
        </tr>
        <tr>
            <td><b>City:</b></td>
            <td>${loggedCustomer.city}</td>
        </tr>
        <tr>
            <td><b>Zip code:</b></td>
            <td>${loggedCustomer.zipcode}</td>
        </tr>
        <tr>
        </tr>
        <tr>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <a href="edit_profile?id=<c:out value='${loggedCustomer.customerId}' />">Edit My Profile</a>
            </td>
        </tr>
    </table>
</div>

<footer>
    <jsp:directive.include file="footer.jsp"/>
</footer>
</body>
</html>

