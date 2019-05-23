
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"   %>
<html>
<head>
    <title>Winkel Wagen</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="container">
    <jsp:include page="header.jsp">
        <jsp:param name="page" value="cart"/>
    </jsp:include>
    <main>
        <h2>Shoppingcart</h2>
        <table>
            <tr>
                <th>Product Id</th>
                <th>Name</th>
                <th>Price</th>
                <th>add to cart</th>
            </tr>
            <c:forEach var="user" items="${user}">
                <tr>
                    <td>${user.getProductId()}
                    </td>
                    <td>${user.getName()}
                    </td>
                    <td>${user.getDescription()}
                    </td>
                    <td>${user.getPrice()}
                    </td>
`                   <td><a href="Controller?command=DeleteConfirmation&id=${user.getProductId()}&name=${user.getName()}">delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </main>
<footer>
&copy; Webontwikkeling 3, UC Leuven-Limburg
</footer>
</div>
</body>
</html>
