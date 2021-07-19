<%--
  Created by IntelliJ IDEA.
  User: t_lamburov
  Date: 19.7.2021 г.
  Time: 11:45 ч.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit Review - Bookstore Administration</title>
</head>
<body>
<header>
    <jsp:directive.include file="header.jsp"/>
</header>
<div align="center">
    <h2>
        <h2>Edit Review</h2>
    </h2>
</div>
<br>
<div align="center">
    <form action="edit_review" method="post" onsubmit="return validateInputForm()">
        <input type="hidden" name="reviewId" value="${review.reviewId}">

        <table>
            <tr>
                <td>Book:</td>
                <td><b>${review.book.title}</b></td>
            </tr>
            <tr>
                <td>Rating:</td>
                <td><b>${review.rating}</b></td>
            </tr>
            <tr>
                <td>Customer:</td>
                <td><b>${review.customer.fullName}</b></td>
            </tr>
            <tr>
                <td>Headline:</td>
                <td><input type="text" name="headline" id="headline" size="20"
                           value="<c:out value='${review.headline}' />"></td>
            </tr>
            <tr>
                <td>Comment:</td>
                <td><textarea rows="5" cols="70" name="comment">${review.comment}</textarea></td>
            </tr>
            <tr>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save">
                    <button id="buttonCancel">Cancel</button>
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
    $(document).ready(function (){
        $("#buttonCancel").click(function (){
            history.go(-1);
        })
    })

</script>
</html>
