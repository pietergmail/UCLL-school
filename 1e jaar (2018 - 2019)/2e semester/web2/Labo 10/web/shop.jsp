<%--
  Created by IntelliJ IDEA.
  User: herre
  Date: 22/05/2019
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"   %>
<c:set var="page" value="shop" />
<html>
<head>
    <title>Winkel Wagen</title>
</head>
<body>
<div id="container">
    <jsp:include page="header.jsp">
        <jsp:param name="page" value="add"/>
    </jsp:include>
    <main>


        <form method="post" action="Controller?command=addProduct" novalidate="novalidate">
            <!-- novalidate in order to be able to run tests correctly -->

            <p><label for="name">Name</label><input type="text" id="name" name="name"
                                                    required value="${naamPreviousValue}"></p>
            <p><label for="description">Description</label><input type="text" id="description" name="description"
                                                                  required value="${descriptionPreviousValue}"></p>
            <p><label for="price">Price</label><input type="number" id="price" name="price"
                                                      required value="${pricePreviousValue}"></p>

            <p><input type="submit" id="addProduct" value="Add Product"></p>

        </form>
    </main>
    <footer>
        &copy; Webontwikkeling 3, UC Leuven-Limburg
    </footer>
</div>
</body>
</html>
