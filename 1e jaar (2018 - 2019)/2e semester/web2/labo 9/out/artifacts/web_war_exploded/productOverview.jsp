<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="page" value="overview" />
<!DOCTYPE html>
<html>
<body>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta charset="UTF-8">
    <title>Overview</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<div id="container">
    <jsp:include page="header.jsp">
        <jsp:param name="page" value="overview"/>
    </jsp:include>
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
            <c:set var="name" value="iets"/>
            <c:forEach var="product" items="${products}"><tr>
                <td>${product.productId}
                </td>
                <td>${product.name}
                </td>
                <td>${product.description}
                </td>
                <td>${product.price}
                </td>
                <td><a href="Controller?command=DeleteConfirmation">delete</a></td>
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