<%--
  Created by IntelliJ IDEA.
  User: t_lamburov
  Date: 7.7.2021 г.
  Time: 12:45 ч.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <title>${book.title}- Online Books Store</title>
    <script src="resources/js/jquery-3.6.0.min.js" type="text/javascript"></script>
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
                <jsp:directive.include file="book_rating.jsp"/>&nbsp;&nbsp;
                <a href="#reviews">${fn:length(book.reviews)}Reviews</a>
            </td>
            <td valign="top" rowspan="2" width="20%">
                <h2>$${book.price}</h2>
                </br> </br>
                <button id="buttonAddToCart">Add to Cart</button>
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
            <td><h2><a id="reviews">Customer Reviews</a></h2></td>
            <td colspan="2" align="center">
                <button id="buttonWriteReview">Write a Customer Review</button>
            </td>
        </tr>
        <tr>
            <td colspan="3">
                <table border="0">
                    <c:forEach items="${book.reviews}" var="review">
                        <tr>
                            <td>
                                <c:forTokens items="${review.stars}" delims="," var="star">
                                    <c:if test="${star eq 'on'}">
                                        <img src="resources/images/rating_on.png"/>
                                    </c:if>
                                    <c:if test="${star eq 'off'}">
                                        <img src="resources/images/rating_off.png"/>
                                    </c:if>
                                </c:forTokens>
                                - <b>${review.headline}</b>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                by ${review.customer.fullName} on ${review.reviewTime}
                            </td>
                        </tr>
                        <tr><td><i>${review.comment}</i></td></tr>
                        <tr><td>&nbsp;</td></tr>
                    </c:forEach>
                </table>
            </td>
        </tr>
    </table>
</div>
<footer>
    <jsp:directive.include file="footer.jsp"/>
</footer>
<script>
    $(document).ready(function (){
       $("#buttonWriteReview").click(function (){
            window.location = 'write_review?book_id=' + ${book.bookId};
       });
        $("#buttonAddToCart").click(function (){
            window.location = 'add_to_cart?book_id=' + ${book.bookId};
        });

    });

</script>
</body>
</html>