<%--
  Created by IntelliJ IDEA.
  User: t_lamburov
  Date: 7.7.2021 г.
  Time: 12:45 ч.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${book.title}- Online Books Store</title>
</head>
<header>
    <jsp:directive.include file="navbar.jsp"/>
</header>

<div align="center">
    <table width="80%">
        <tr>
            <td colspan="3" align="left">
                <h2>${book.title}</h2> by ${book.author}
            </td>
        </tr>
        <tr>
            <td rowspan="2">
                <img src="data:image/jpg;base64,${book.base64Image}" width="240" height="300"/>
            </td>
            <td valign="top" align="left">
                Rating *****
            </td>
            <td valign="top" rowspan="2" width="20%">
                <h2>$${book.price}</h2>
                </br> </br>
                <button type="sumbit">Add to Cart</button>
            </td>
        </tr>
        <tr>
            <td valign="top" style="text-align: justify">
                ${book.description}
            </td>
        </tr>
        <tr>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td><h2>Customer Reviews</h2></td>
            <td colspan="2" align="center">
                <button>Write a Customer Review</button>
            </td>
        </tr>
    </table>
</div>
<footer>
    <jsp:directive.include file="footer.jsp"/>
</footer>
</body>
</html>