<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="header.jsp" />
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta charset="UTF-8">
    <title>Sign Up</title>
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
            Add Product
        </h2>

    </header>
    <main>
        <c:if test="$(errors != null)">
        <div class="alert-danger">
            <ul>
                <c:forEach var="errors" items="${errors}">
                <li>${errors}</li>
                </c:forEach>
            </ul>
        </div>
        </c:if>

        <form method="post" action="Controller?command=addProduct" novalidate="novalidate">
            <!-- novalidate in order to be able to run tests correctly -->

            <p><label for="name">Name</label><input type="text" id="name" name="name"
                                                               required></p>
            <p><label for="description">Description</label><input type="text" id="description" name="description"
                                                             required></p>
            <p><label for="price">Price</label><input type="number" id="price" name="price" required></p>

            <p><input type="submit" id="addProduct" value="Add Product"></p>

        </form>
    </main>
    <footer>
        &copy; Webontwikkeling 3, UC Leuven-Limburg
    </footer>
</div>
</body>
</html>
