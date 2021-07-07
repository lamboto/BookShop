<%--
  Created by IntelliJ IDEA.
  User: t_lamburov
  Date: 24.6.2021 г.
  Time: 12:29 ч.
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Index</title>
</head>
<body>

<header>
    <jsp:directive.include file="navbar.jsp"/>
</header>

<div align="center">
    <div align="center" style="width: 80%;margin: 0 auto">
        <h2>New books:</h2>
        <c:forEach items="${newBooks}" var="book">
            <div style="display: inline-block; margin: 20px">
                <div>
                    <a href="view_book?id=${book.bookId}">
                        <img src="data:image/jpg;base64,${book.base64Image}" width="128" height="164"/>
                    </a>
                </div>
                <div>
                    <a href="view_book?id=${book.bookId}">
                        <b>${book.title}</b>
                    </a>
                </div>
                <div>Rating *****</div>
                <div><i></i>by ${book.author}</div>
                <div><b>$${book.price}</b></div>
            </div>
        </c:forEach>
    </div>
    <div align="center" style="clear: both">
        <h2>Best-Selling Books:</h2>
    </div>
    <div align="center" style="clear: both">
        <h2>Most-favored Books:</h2>
    </div>
</div>

<footer>
    <jsp:directive.include file="footer.jsp"/>
</footer>
</body>
</html>
