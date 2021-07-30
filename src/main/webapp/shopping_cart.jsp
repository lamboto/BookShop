<%--
  Created by IntelliJ IDEA.
  User: t_lamburov
  Date: 13.7.2021 г.
  Time: 10:09 ч.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Shopping cart</title>
</head>
<body>

<header>
    <jsp:directive.include file="navbar.jsp"/>
</header>

<div align="center">
    <h2>Your Cart Details</h2>

    <c:set var="cart" value="${sessionScope['cart']}"/>

    <c:if test="${cart.totalItems == 0}">
        <h2>There's no items in your cart!</h2>
    </c:if>

    <c:if test="${cart.totalItems > 0}">
        <div>
            <form>
                <table border="1">
                    <tr>
                        <th>No</th>
                        <th>Book</th>
                        <th>Quantity</th>
                        <th>Price</th>
                        <th>Subtotal</th>
                        <th>
                            <a href=""><b>Clear Cart</b></a>
                        </th>
                    </tr>
                    <c:forEach items="${cart.items}" var="item" varStatus="status">
                        <tr>
                            <td>${status.index+1}</td>
                            <td>
                                <img src="data:image/jpg;base64,${item.key.base64Image}" width="128" height="164"/>
                                &nbsp;&nbsp;
                                    ${item.key.title}
                            </td>
                            <td>${item.value}</td>
                            <td><fmt:formatNumber value="${item.key.price}" type="currency"/></td>
                            <td><fmt:formatNumber value=" ${item.value * item.key.price}" type="currency"/></td>
                            <td><a href="">Remove</a></td>
                        </tr>
                    </c:forEach>

                    <tr>
                        <td></td>
                        <td></td>
                        <td><b>${cart.totalQuantity} book(s)</b></td>
                        <td>Total:</td>
                        <td colspan="2"><b><fmt:formatNumber value="${cart.totalAmount}" type="currency"/></b></td>
                    </tr>
                </table>
            </form>
        </div>
    </c:if>

</div>

<footer>
    <jsp:directive.include file="footer.jsp"/>
</footer>

</body>
</html>
