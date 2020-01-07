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
    </jsp:include>
    <main>

        <p>error</p>

        <p>No products to show</p>

        <table>
            <tr>
                <th>Product Id</th>
                <th>Name</th>
                <th>Description</th>
                <th>Price</th>
                <th>Add to Cart</th>
            </tr>
            <tr>
                <td>productId</td>
                <td>name</td>
                <td>description</td>
                <td>price</td>
                <td><a href="#">Add to Cart</a>
                </td>
            </tr>

            <caption>Product Overview</caption>
        </table>
    </main>
    <footer>
        &copy; Webontwikkeling 2, UC Leuven-Limburg
    </footer>
</div>
</body>
</html>