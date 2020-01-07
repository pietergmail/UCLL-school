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
    <jsp:include page="header.jsp">
        <jsp:param name="page" value="Shopping Cart"/>
    </jsp:include>
    <main>
            <p>error</p>
            <p>No products in your shopping cart</p>
            <table>
                <tr>
                    <th>Product Id</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>Remove from Cart</th>
                </tr>

                    <tr>
                        <td>productId</td>
                        <td>name</td>
                        <td>description</td>
                        <td>price</td>
                        <td><a href="#">Remove From
                            Cart</a></td>
                    </tr>

                <caption>Shopping Cart</caption>
            </table>
    </main>
    <footer>
        &copy; Webontwikkeling 2, UC Leuven-Limburg
    </footer>
</div>
</body>
</html>