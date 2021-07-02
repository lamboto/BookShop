<%--
  Created by IntelliJ IDEA.
  User: t_lamburov
  Date: 1.7.2021 г.
  Time: 15:41 ч.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Login</title>
</head>
<body>

<header>
    <jsp:directive.include file="header.jsp"/>
</header>

<div align="center">
    <h2>Admin Login:</h2>

    <form id="formLogin" action="login" method="post">
        <table>
            <tr>
                <td>Email:</td>
                <td><input type="text" name="email" id="email" size="20"></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password" id="password" size="20"></td>
            </tr>
            <tr>
                <td>
                    <button type="submit">Login</button>
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
