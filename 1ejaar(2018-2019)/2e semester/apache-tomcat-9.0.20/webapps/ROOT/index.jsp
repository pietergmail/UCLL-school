<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Contact Tracing</title>
    <link rel="stylesheet" href="styles.css">
    <script src="js/Persons.js"></script>
</head>
<body>
<header>
    <h1>Contact Tracing @Campus Proximus</h1>
    <p><a href="index.jsp">home</a></p>
    <p><a href="search.jsp">search</a></p>
    <p><a href="SignUp.jsp">Sign Up</a></p>
    <p><a href="covid-19.jsp">covid-19</a></p>
    <p><a href="roomcount.jsp">roomcount</a></p>
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
        <th>First name</th>
        <th>Last name</th>
        <th>Date</th>
        <th>Room</th>
        <th>Email</th>
        <th>GSM</th>
        <th>Delete</th>
        </thead>
        <tbody id="tbody">
        <tr>
            <td>dummy</td>
            <td>dummy</td>
            <td>dummy</td>
            <td>dummy</td>
            <td>dummy</td>
            <td>dummy</td>
            <td>dummy</td>
        </tr>
        </tbody>
    </table>
</div>

<form action="">
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

    <input type="button" value="add person" onclick="addPerson()">

</form>
<c:choose>
    <c:when test="${not empty user}">
        <p>Welcome ${user.getFirstName()}!</p>
        <form method="post" action="Controller?command=LogOut">
            <p>
                <input type="submit" id="logoutbutton" value="Log Out">
            </p>
        </form>
    </c:when>
    <c:otherwise>
        <h2>Log in</h2>
        <form action="Controller?command=LogIn" method="post">

            <label for="emaillogin">Your email</label>
            <input type="text" id="emaillogin" name="emaillogin">
            <br>

            <label for="passwordlogin">Your password</label>
            <input type="text" id="passwordlogin" name="passwordlogin">
            <br>

            <input value="Log In" type="submit">

        </form>
    </c:otherwise>
</c:choose>

<h2>Most visited rooms</h2>
<div id="most_common">
    <p>dummy1</p>
    <p>dummy2</p>
    <p>dummy3</p>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</body>
</html>
