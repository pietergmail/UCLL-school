<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/sample.css"/>
    <title>Veggie</title>
</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="page" value="Login"/>
</jsp:include>


<main>
    <h2>Log In</h2>
    <c:if test="${errors != null}">
        <div class="error">
            <ul>
                <c:forEach var="error" items="${errors}">
                    <li>${error}</li>
                </c:forEach>
            </ul>
        </div>
    </c:if>
    <c:choose>
        <c:when test="${user eq null}">
            <p>Please log in.</p>
            <form form="novalidate" action="Servlet?command=LogInSubmit" method="post">
                <p>Your role:</p>
                <p class="input">
                    <input type="radio" id="customer" name="role" value="customer" checked>
                    <label for="customer">Customer</label>
                </p>
                <p class="input">
                    <input type="radio" id="admin" name="role" value="admin">
                    <label for="admin">Admin</label>
                </p>
                <input type="submit" value="Log In">
            </form>
        </c:when>
        <c:otherwise>
            <p>Welcome, ${user}</p>
            <form form="novalidate" action="Servlet?command=LogOut" method="post">
                <input type="submit" value="Log Out">
            </form>
        </c:otherwise>

    </c:choose>

</main>
</body>
</html>