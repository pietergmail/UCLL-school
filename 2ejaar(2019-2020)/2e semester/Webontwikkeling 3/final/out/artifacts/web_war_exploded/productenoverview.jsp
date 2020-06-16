<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta charset="UTF-8">
    <title>Overview</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="container">
    <header>
        <h1><span>Web shop</span></h1>
        <jsp:include page="header.jsp">
            <jsp:param name="page" value="productenOverview"/>
        </jsp:include>
        <h2>
            Product Overview
        </h2>
    </header>
    <main>
        <table>
            <tr>
                <th>Name</th>
                <th>Description</th>
                <th>Price</th>
            </tr>
            <c:forEach items="${producten}" var="Product">
                <tr>
                    <c:if test="${person.role == 'Admin'}">
                    <td><a href="Controller?command=editProduct&id=${Product.productId}">${Product.name}</a></td>
                    </c:if>
                    <td><c:out value="${Product.description}"/></td>
                    <td><c:out value="${Product.price}"/></td>
                    <c:if test="${person.role == 'Admin'}">
                    <td><a href="deleteProduct.jsp?id=<c:out value='${Product.productId}'></c:out>&name=<c:out value='${Product.name}'></c:out>">delete</a></td>
                    </c:if>
                    <td><a href="Controller?command=addtocart&id=<c:out value='${Product.productId}'></c:out>">add to cart</a></td>
                </tr>
            </c:forEach>
            <caption>Product Overview</caption>
        </table>
    </main>
    <footer>
        &copy; Webontwikkeling 3, UC Leuven-Limburg
    </footer>
</div>
</body>
</html>
