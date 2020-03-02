<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta charset="UTF-8">
    <title>Add product</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="container">
    <header>
        <h1><span>Web shop</span></h1>
        <jsp:include page="header.jsp">
            <jsp:param name="page" value="addProduct"/>
        </jsp:include>
        <h2>
            Add product
        </h2>

    </header>
    <main>
        <c:if test="${errors != null}">
            <div class="alert-danger">
                <ul>
                    <c:forEach var="error" items="${errors}">
                        <li>${error}</li>
                    </c:forEach>
                </ul>
            </div>
        </c:if>

        <form novalidate="novalidate" method="post" action="Controller?command=addProductSubmit">
            <!-- novalidate in order to be able to run tests correctly -->
            <p><label for="name">Name</label><input type="text" id="name" name="name"
                                                         required value="${prevName}"></p>

            <p><label for="description">Description</label><input type="text" id="description" name="description"
                                                               required value="${prevDescription}"></p>
            <p><label for="price">Price</label><input type="text" id="price" name="price"
                                                             required value="${prevPrice}"></p>

            <p><input type="submit" id="signUp" value="Sign Up"></p>

        </form>
    </main>
    <footer>
        &copy; Webontwikkeling 3, UC Leuven-Limburg
    </footer>
</div>
</body>
</html>
