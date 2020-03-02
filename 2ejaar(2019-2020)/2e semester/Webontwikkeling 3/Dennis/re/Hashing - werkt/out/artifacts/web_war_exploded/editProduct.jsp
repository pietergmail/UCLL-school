<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>edit product</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
<body>
<div id="container">
    <header>
        <h1>
            <span>Web shop</span>
        </h1>
        <jsp:include page="header.jsp">
            <jsp:param name="current_page" value="editProduct"/>
        </jsp:include>
        <h2>edit product: ${Product.name}</h2>

    </header>
    <main>
        <form action="Controller?command=editProductSubmit" method="post" novalidate>
            <p><label for="name">name:</label><input type="text" id="name" name="name"required value="${Product.name}"></p>
            <p><label for="description">description:</label><input type="text" id="description" name="desc" required value="${Product.description}"></p>
            <p><label for="price">price:</label><input type="text" id="price" name="price" required value="${Product.price}"></p>
            <input type="hidden" value="${Product.productId}" name="id">
            <input type="submit">
        </form>
    </main>
    <footer> &copy; Webontwikkeling 3, UC Leuven-Limburg</footer>
</div>
</body>
</html>