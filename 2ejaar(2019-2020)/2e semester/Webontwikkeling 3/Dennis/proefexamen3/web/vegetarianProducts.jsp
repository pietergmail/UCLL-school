<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Veggie</title>
    <link rel="stylesheet" href="css/sample.css">
</head>
<body>
<jsp:include page="header.jsp"/>

<main>
    <article>
        <h1>Vegetarian products</h1>
        <table>
            <tr>
                <th>Name</th>
                <th>Price</th>
            </tr>
                <c:forEach items="${products}" var="product">
                    <tr>
                        <td>${product.name}</td>
                        <td>${product.price}</td>
                    </tr>
                </c:forEach>
        </table>
    </article>
</main>
</body>
</html>