<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="style.css"/>
    <title>Demo Authentication - Home</title>
</head>
<body>
<jsp:include page="header.jsp"/>


<main>
    <h2>Home</h2>

    <c:choose>
        <c:when test="${user!=null }">
            <p>Welcome, ${user.name }</p>
            <form action="Controller?action=LogOut" method="post">
                <input type="submit" value="Log Out">
            </form>
        </c:when>
        <c:otherwise>
            <p>Please log in, Anne and Celine.</p>
            <c:if test="${error ne null}">
                <p class="error">
                    ${error}
                </p>
            </c:if>
            <form action="Controller?action=LogIn" method="post">
                <p class="input">
                    <label for="name">Your name</label>
                    <input type="text" id="name" name="name">
                </p>
                <p class="input">
                    <label for="password">Your password</label>
                    <input type="text" id="password" name="password">
                </p>
                <input type="submit" value="Log In">
            </form>
        </c:otherwise>
    </c:choose>
</main>
</body>
</html>