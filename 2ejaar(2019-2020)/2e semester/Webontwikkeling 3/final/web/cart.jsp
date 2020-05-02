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
            <jsp:param name="page" value="cart"/>
        </jsp:include>
        <h2>
            Cart
        </h2>

    </header>
    <main>
        <table>
            <c:choose>
                <c:when test="${cart!= null}">
                    <tr>
                        <th>Name</th>
                        <th>Description</th>
                        <th>Price</th>
                    </tr>
                    <c:forEach items="${cart}" var="Product">
                        <tr>
                            <td>${Product.name}</td>
                            <td>${Product.description}</td>
                            <td>${Product.price}</td>
                        </tr>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <p>The cart is empty.</p>
                </c:otherwise>
            </c:choose>
            <caption>Product Overview</caption>
        </table>
    </main>
    <footer>
        &copy; Webontwikkeling 3, UC Leuven-Limburg
    </footer>
</div>
</body>
</html>