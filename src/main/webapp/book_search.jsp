<%--
  Created by IntelliJ IDEA.
  User: t_lamburov
  Date: 7.7.2021 г.
  Time: 13:47 ч.
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <title>Results for ${keyword} - Online Books Store</title>
</head>


<body>
<header>
    <jsp:directive.include file="navbar.jsp"/>
</header>
<div align="center">
    <c:if test="${fn:length(result) == 0}">
        <h2>No result for "${keyword}"</h2>
    </c:if>
    <c:if test="${fn:length(result) > 0}">
    <div align="left" style="width: 65%;margin: 0 auto">
        <center><h2>Results for "${keyword}"</h2></center>
        <c:forEach items="${result}" var="book">
        <div>
            <div style="display: inline-block; margin: 20px; width: 10%">
                <div align="left">
                    <a href="view_book?id=${book.bookId}">
                        <img src="data:image/jpg;base64,${book.base64Image}" width="128" height="164"/>
                    </a>
                </div>
            </div>
            <div style="display: inline-block; margin: 20px;vertical-align: top;width: 61%" align="left">
                <div>
                    <a href="view_book?id=${book.bookId}">
                        <b>${book.title}</b>
                    </a>
                </div>
                <div>Rating *****</div>
                <div><i></i>by ${book.author}</div>
                <div><b>$${book.price}</b></div>
                <div><p>${fn:substring(book.description,0,100)}...</p></div>
            </div>
                <div style="display: inline-block; margin: 20px;vertical-align: top" align="right">
                    <h3><b>$${book.price}</b></h3>
                    <h3><a href="">Add to Cart</a></h3>
                </div>
            </c:forEach>
        </div>
    </div>

</div>
</c:if>

<footer>
    <jsp:directive.include file="footer.jsp"/>
</footer>
</body>
</html>

