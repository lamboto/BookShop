<%--
  Created by IntelliJ IDEA.
  User: t_lamburov
  Date: 28.6.2021 г.
  Time: 11:16 ч.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create User - Bookstore Administration</title>
</head>
<body>
<header>
    <jsp:directive.include file="header.jsp"/>
</header>
<div align="center">
    <h2>Create New User</h2>
</div>
<br>
<div align="center">
    <form action="create_user" method="post" onsubmit="return validateInputForm()">
        <table>
            <tr>
                <td>Email:</td>
                <td><input type="text" name="email" id="email" size="20"></td>
            </tr>
            <tr>
                <td>Full Name:</td>
                <td><input type="text" name="fullname" id="fullname" size="20"></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" name="password" id="password" size="20"></td>
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
<script type="text/javascript">
    function validateInputForm() {
        let fieldEmail = document.getElementById("email");
        let fieldFullname = document.getElementById("fullname");
        let fieldPassowrd = document.getElementById("password");

        if (fieldEmail.value.length === 0) {
            alert("Email is required")
            fieldEmail.focus();
            return false;
        }
        if (fieldFullname.value.length === 0) {
            alert("Fullname is required")
            fieldEmail.focus();
            return false;
        }
        if (fieldPassowrd.value.length === 0) {
            alert("Passowrd is required")
            fieldEmail.focus();
            return false;
        }
    }

</script>
</html>
