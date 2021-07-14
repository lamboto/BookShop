<%--
  Created by IntelliJ IDEA.
  User: t_lamburov
  Date: 14.7.2021 г.
  Time: 15:47 ч.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit Prorfile</title>
</head>
<body>
<header>
    <jsp:directive.include file="navbar.jsp"/>
</header>
<div align="center">
    <h2>Edit Customer</h2>
</div>
<br>
<div align="center">
    <form action="edit_profile" method="post" onsubmit="return validateInputForm()">
        <input type="hidden" name="customerId" value="${customer.customerId}">
        <table>
            <tr>
                <td>Email Address:</td>
                <td><b>${customer.email}</b> (Cannot be changed)</td>
            </tr>
            <tr>
                <td>Full Name:</td>
                <td><input type="text" name="fullname" id="fullname" size="20"
                           value="<c:out value='${customer.fullName}' />"></td>
            </tr>
            <tr>
                <td>Phone Number:</td>
                <td><input type="text" name="phone" id="phone" size="20"
                           value="<c:out value='${customer.phone}' />"></td>
            </tr>
            <tr>
                <td>Address:</td>
                <td><input type="text" name="address" id="address" size="20"
                           value="<c:out value='${customer.address}' />"></td>
            </tr>
            <tr>
                <td>City:</td>
                <td><input type="text" name="city" id="city" size="20"
                           value="<c:out value='${customer.city}' />"></td>
            </tr>
            <tr>
                <td>Zip code:</td>
                <td><input type="text" name="zipcode" id="zipcode" size="20"
                           value="<c:out value='${customer.zipcode}' />"></td>
            </tr>
            <tr>
                <td>Country:</td>
                <td><input type="text" name="country" id="country" size="20"
                           value="<c:out value='${customer.country}' />"></td>
            </tr>

            <tr>
                <td>Password:</td>
                <td><input type="password" name="password" id="password" size="20"/></td>
            </tr>
            <tr>
                <td>Confirm Passowrd:</td>
                <td><input type="password" name="confirmPassword" id="confirmPassword" size="20"/></td>
            </tr>
            <tr>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save">
                    <input type="submit" value="Cancel">
                </td>
            </tr>
        </table>
    </form>
</div>

<footer>
    <jsp:directive.include file="footer.jsp"/>
</footer>
</body>

</html>