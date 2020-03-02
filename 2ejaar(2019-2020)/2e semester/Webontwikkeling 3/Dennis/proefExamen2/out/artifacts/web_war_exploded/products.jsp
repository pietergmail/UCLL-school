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
        <h1>All products</h1>
        <table>
            <tr>
                <th>Name</th>
                <th>Price</th>
                <th>Vegetarian</th>
            </tr>
                <!-- <tr>
                    <td>Carot</td>
                    <td>1.4</td>
                    <td>true</td>
                </tr>-->
            <c:forEach items="${products}" var="product">
                <tr>
                    <td>${product.name}</td>
                    <td>${product.price}</td>
                    <td>${product.vegetarian}</td>
                </tr>
            </c:forEach>
        </table>
        <form action="Controller?action=OrderedOverview" method="post">
            <input class="small" type="submit" value="Sort by Price">
        </form>
        <p><a href="Controller">Go home.</a></p>
    </article>
</main>
</body>
</html>