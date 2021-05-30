<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Contact Tracing</title>
    <link rel="stylesheet" href="styles.css">
    <script src="js/Covid.js"></script>
</head>
<body>
<header>
    <h1>Contact Tracing @Campus Proximus</h1>
    <p><a href="index.jsp">home</a></p>
    <p><a href="search.jsp">search</a></p>
    <p><a href="SignUp.jsp">Sign Up</a></p>
    <p><a href="covid-19.jsp">covid-19</a></p>
    <c:choose>
        <c:when test="${not empty user}">
            <p><a href="friends.jsp">friends</a> </p>
        </c:when>
    </c:choose>
</header>

<h2>Contact Overview</h2>
<div class="flex-container">
    <table>
        <thead>
        <th>Name</th>
        <th>Date</th>
        </thead>
        <tbody id = "tbody">
        <tr>
        </tr>
        </tbody>
    </table>
</div>

<form action="">
    <label for="name">Name: </label>
    <input type="text" id="name" name="name">
    <br>

    <label for="date">Date: </label>
    <input type="text" id="date" name="date">
    <br>

    <input type="button" value="button" onclick="send()">
</form>
</body>
</html>