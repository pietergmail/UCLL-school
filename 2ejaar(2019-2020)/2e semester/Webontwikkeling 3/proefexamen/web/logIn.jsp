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
<jsp:include page="header.jsp"/>


<main>
    <h2>Log In</h2>
        <p class="error">Some error message</p>

            <p>Welcome, //naam gebruiker//</p>
            <form action="#" method="">
                <input type="submit" value="Log Out">
            </form>

            <p>Please log in.</p>
            <form action="#" method="">
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

</main>
</body>
</html>