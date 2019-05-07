<%@ page import="domain.model.Product" %>
<%@ page import="java.util.ArrayList" %>
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
        <%
            if (request.getAttribute("products") == null) {
        %>
        <p>No products to show</p>
        <%
        } else { %>
        <table>
            <tr>
                <th>Product Id</th>
                <th>Name</th>
                <th>Description</th>
                <th>Price</th>
            </tr>
            <% for (Product product : (ArrayList<Product>) (request.getAttribute("products"))) { %>
            <tr>
                <td><%= product.getProductId()%>
                </td>
                <td><%= product.getName()%>
                </td>
                <td><%= product.getDescription()%>
                </td>
                <td><%= product.getPrice()%>
                </td>
            </tr>
            <% } %>
            <caption>Product Overview</caption>
        </table>
        <% } %>
    </main>
    <footer>
        &copy; Webontwikkeling 3, UC Leuven-Limburg
    </footer>
</div>
</body>
</html>