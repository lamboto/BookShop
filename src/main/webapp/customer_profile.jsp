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

    <form action="edit_customer" method="post" onsubmit="return validateInputForm()">
        <input type="hidden" name="customerId" value="${loggedCustomer.customerId}">
            <table>
                <tr>
                    <td>Email Address:</td>
                    <td><input type="text" class="normal" name="email" id="email" size="20"
                               value="<c:out value='${loggedCustomer.email}' />"></td>
                </tr>
                <tr>
                    <td>Full Name:</td>
                    <td><input type="text" name="fullname" id="fullname" size="20"
                               value="<c:out value='${loggedCustomer.fullName}' />"></td>
                </tr>
                <tr>
                    <td>Phone Number:</td>
                    <td><input type="text" name="phone" id="phone" size="20"
                               value="<c:out value='${loggedCustomer.phone}' />"></td>
                </tr>
                <tr>
                    <td>Address:</td>
                    <td><input type="text" name="address" id="address" size="20"
                               value="<c:out value='${loggedCustomer.address}' />"></td>
                </tr>
                <tr>
                    <td>City:</td>
                    <td><input type="text" name="city" id="city" size="20"
                               value="<c:out value='${loggedCustomer.city}' />"></td>
                </tr>
                <tr>
                    <td>Zip code:</td>
                    <td><input type="text" name="zipcode" id="zipcode" size="20"
                               value="<c:out value='${loggedCustomer.zipcode}' />"></td>
                </tr>
                <tr>
                    <td>Country:</td>
                    <td><input type="text" name="country" id="country" size="20"
                               value="<c:out value='${loggedCustomer.country}' />"></td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <a href="edit_customer?id=<c:out value='${loggedCustomer.customerId}' />">Edit My Profile</a>
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

