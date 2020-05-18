<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="style.css"/>
    <title>Demo Authorization - Home</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<%--
<jsp:include page="headerWithAuthorization.jsp"/>
--%>

<main>
    <h2>Home</h2>
    <c:if test="${notAuthorized!=null }">
        <p class="error">${notAuthorized }</p>

    </c:if>
    <c:choose>
        <c:when test="${user!=null }">
            <p>Welcome, ${user.name }</p>
            <form action="Controller?action=LogOut" method="post">
                <input type="submit" value="Log Out">
            </form>
        </c:when>
        <c:otherwise>
            <p>Please log in.</p>
            <form action="Controller?action=LogIn" method="post">
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
        </c:otherwise>
    </c:choose>
</main>
</body>
</html>