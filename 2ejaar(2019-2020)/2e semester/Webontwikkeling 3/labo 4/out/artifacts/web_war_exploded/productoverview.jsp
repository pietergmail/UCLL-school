<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>Home</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="container">
    <header>
        <h1>
            <span>Web shop</span>
        </h1>
        <nav>
            <ul>
                <li><a href="Controller">Home</a></li>
                <li><a href="Controller?command=overview">Overview</a></li>
                <li id="actual"><a href="Controller?command=producten">Products</a></li>
                <li><a href="Controller?command=addproductpage">Add product</a></li>
                <li><a href="Controller?command=signUp">Sign up</a></li>
            </ul>
        </nav>
        <h2>Products</h2>

    </header>
    <main>
        <c:choose>
            <c:when test="${producten!=null}">
                <table>
                    <tr>
                        <th>Name</th>
                        <th>Description</th>
                        <th>Price</th>
                        <th>Verwijder</th>
                    </tr>
                    <c:forEach var="product" items="${producten}">
                        <tr>
                            <td><a href="Controller?command=updateproductpage&productId=${product.productId}">${product.name}</a></td>
                            <td>${product.description}</td>
                            <td>${product.price}</td>
                            <td><a href="Controller?command=verwijderproductpage&productId=${product.productId}&name=${product.name}&description=${product.description}&price=${product.price}"> Verwijder</a></td>
                        </tr>
                    </c:forEach>

                </table>
            </c:when>
            <c:otherwise>
                <p>Er zijn nog geen producten toegevoegd.</p>
            </c:otherwise>
        </c:choose>
    </main>
    <footer> &copy; Webontwikkeling 3, UC Leuven-Limburg</footer>
</div>
</body>
</html>