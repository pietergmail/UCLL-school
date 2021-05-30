<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="styles.css">
    <title>Sign Up</title>
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

    <h2>Sign Up</h2>
    <form action="Controller?command=Register" method="post">

        <!--Extra info nodig omdat ik model van persoon hergebruik -->
        <label for="fname">First Name:</label>
        <input type="text" id="fname" name="fname">
        <br>

        <label for="lname">Last Name:</label>
        <input type="text" id="lname" name="lname">
        <br>

        <label for="email">Email:</label>
        <input type="text" id="email" name="email">
        <br>

        <label for="GSM">GSM:</label>
        <input type="text" id="GSM" name="GSM">
        <br>

        <label for="date">Date:</label>
        <input type="text" id="date" name="date">
        <br>

        <label for="room">Room:</label>
        <input type="text" id="room" name="room">
        <br>

        <label for="password">Password:</label>
        <input type="text"  id="password" name="password">
        <br>

        <input value="Sign Up" type="submit">

    </form>
</body>
</html>
