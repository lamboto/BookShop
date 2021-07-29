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
    <title>Write review - online Book Store</title>
    <script src="resources/js/jquery-3.6.0.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/rateYo/2.3.2/jquery.rateyo.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/rateYo/2.3.2/jquery.rateyo.min.js"></script>
</head>
<body>

<header>
    <jsp:directive.include file="navbar.jsp"/>
</header>

<div align="center">
    <form id="reviewForm">
        <table class="normal" width="60%">
            <tr>
                <td><h3>You already wrote a review for this book</h3></td>
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
                <td>
                    <div id="rateYo"></div>

                    <br/>
                    <input type="text" name="headline" size="60" readonly="readonly" value="${review.headline}"/>
                    <br/>
                    <br/>
                    <textarea name="comment" cols="70" rows="10" readonly="readonly">${review.comment}</textarea>
                </td>
            </tr>
        </table>
    </form>
</div>

<footer>
    <jsp:directive.include file="footer.jsp"/>
</footer>
<script>
    $(function () {


        $("#rateYo").rateYo({
            starWidth: "40px",
            fullStar: true,
            rating: ${review.rating},
            readOnly: true,
            onSet: function (rating, rateYoInstance) {
                $("#rating").val(rating);
            }
        });

    });
</script>
</body>
</html>


