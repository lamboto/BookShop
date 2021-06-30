<%--
  Created by IntelliJ IDEA.
  User: t_lamburov
  Date: 30.6.2021 г.
  Time: 16:12 ч.
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
        <c:if test="${category != null}">
            <h2>Edit Category</h2>
        </c:if>
        <c:if test="${category == null}">
            <h2>Create New Category</h2>
        </c:if>
    </h2>
</div>
<br>
<div align="center">
    <c:if test="${category != null}">
    <form action="edit_category" method="post" onsubmit="return validateInputForm()">
        </c:if>
        <c:if test="${category == null}">
        <form action="create_category" method="post" onsubmit="return validateInputForm()">
            </c:if>
            <table>

                <c:if test="${category != null}">
                    <input type="hidden" name="categoryId" value="<c:out value='${category.categoryId}'/>"/>
                </c:if>
                <tr>
                    <td>Name :</td>
                    <td><input type="text" name="name" id="name" size="20"
                               value="<c:out value='${category.name}' />"></td>
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
        let fieldName = document.getElementById("name");


        if (fieldName.value.length === 0) {
            alert("Category Name is required")
            fieldName.focus();
            return false;
        }

    }

</script>
</html>
