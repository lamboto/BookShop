<%--
  Created by IntelliJ IDEA.
  User: t_lamburov
  Date: 28.7.2021 г.
  Time: 15:32 ч.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <title>Review Posted - Online Book Store</title>
</head>
<body>

<header>
    <jsp:directive.include file="navbar.jsp"/>
</header>

<div align="center">

    <table class="normal" width="60%">
        <tr>
            <td><h2>Your Reviews</h2></td>
            <td>&nbsp;</td>
            <td><h2>${loggedCustomer.fullName}</h2></td>
        </tr>
        <tr>
            <td colspan="3">
                <hr/>
            </td>
        </tr>
        <tr>
            <td>
                <h2>${book.title}</h2><br/>
                <img src="data:image/jpg;base64,${book.base64Image}" width="240" height="300"/>
            </td>
            <td colspan="2">
                <h3>Your review has been posted. Thank you!</h3>
            </td>
        </tr>

    </table>
</div>

<footer>
    <jsp:directive.include file="footer.jsp"/>
</footer>
</body>
</html>


