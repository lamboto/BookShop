<%--
  Created by IntelliJ IDEA.
  User: t_lamburov
  Date: 2.7.2021 г.
  Time: 14:26 ч.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title> Bookstore Administration</title>
</head>
<body>
<header>
    <jsp:directive.include file="header.jsp"/>
</header>
<div align="center">
    <h2>
        <c:if test="${book != null}">
            <h2>Edit Book</h2>
        </c:if>
        <c:if test="${book == null}">
            <h2>Create New Book</h2>
        </c:if>
    </h2>
</div>
<br>


<div align="center">
    <c:if test="${book != null}">
    <form action="edit_book" method="post" onsubmit="return validateInputForm()">
        <input type="hidden" name="bookId" value="${book.bookId}">
        </c:if>
        <c:if test="${book == null}">
        <form action="create_book" method="post" onsubmit="return validateInputForm()">
            </c:if>
            <table>
                <tr>

                    <td>Category:</td>
                    <td>
                        <select name="category">
                            <c:forEach items="${listCategories}" var="category">
                                <option value="${category.categoryId}">${category.name}</option>
                            </c:forEach>
                        </select>

                    </td>

                </tr>
                <tr>
                    <td>Title:</td>
                    <td><input type="text" name="title" id="title" size="20"
                               value="<c:out value='${book.title}' />"></td>
                </tr>
                <tr>
                    <td>Author:</td>
                    <td><input type="text" name="author" id="author" size="20"
                               value="<c:out value='${book.author}' />"></td>
                </tr>
                <tr>
                    <td>ISBN:</td>
                    <td><input type="text" name="isbn" id="isbn" size="20"
                               value="<c:out value='${book.isbn}' />"></td>
                </tr>
                <tr>
                    <td>Publish Date:</td>
                    <td><input type="date" name="publishDate" id="publishDate" size="20"
                               value="<c:out value='${book.publishDate}' />"></td>
                </tr>
                <tr>
                    <td>Price:</td>
                    <td><input type="number" name="price" id="price" size="20"
                               value="<c:out value='${book.price}' />"></td>
                </tr>
                <tr>
                    <td>Description:</td>
                    <td><input type="text" name="description" id="description" size="20"
                               value="<c:out value='${book.description}' />"></td>
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
