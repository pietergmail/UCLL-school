<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta charset="UTF-8">
    <title>Users</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="container">
    <header>
        <h1><span>Web shop</span></h1>
        <nav>
            <ul>
                <li id="actual"><a href="Controller">Home</a></li>
                <li><a href="Controller?command=overview">Overview</a></li>
                <li><a href="Controller?command=add">Add Product</a></li>
            </ul>
        </nav>
        <h2>
            Product Overview
        </h2>

    </header>
    <main>
        <c:choose>
        <c:when test="${products == null || empty products}">
        <p>No products to show</p>
        </c:when>
        <c:otherwise>
        <table>
            <tr>
                <th>Product Id</th>
                <th>Name</th>
                <th>Description</th>
                <th>Price</th>
            </tr>
            <c:forEach var="product" items="${products}"><tr>
                <td>${product.productId}
                </td>
                <td>${product.name}
                </td>
                <td>${product.description}
                </td>
                <td>${product.price}
                </td>
            </tr>
            </c:forEach>
            <caption>Product Overview</caption>
        </table>
        </c:otherwise>
        </c:choose>
    </main>
    <footer>
        &copy; Webontwikkeling 3, UC Leuven-Limburg
    </footer>
</div>
</body>
</html>