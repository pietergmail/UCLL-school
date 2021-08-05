<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Contact Tracing</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMNCOe7tC1doHpGoWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js" integrity="sha384-cn7l7gDp0eyniUwwAZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/" crossorigin="anonymous"></script>

    <script src="js/Persons.js"></script>
</head>
<body>
<header class="container-lg">
    <h1>Contact Tracing @Campus Proximus</h1>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <p class="nav-item"><a href="index.jsp" class="nav-link">home</a></p>
        <p class="nav-item"><a href="search.jsp" class="nav-link">search</a></p>
        <p class="nav-item"><a href="search-date.jsp" class="nav-link">search-date</a></p>
        <p class="nav-item"><a href="SignUp.jsp" class="nav-link">Sign Up</a></p>
        <p class="nav-item"><a href="covid-19.jsp" class="nav-link">covid-19</a></p>
        <c:choose>
        <c:when test="${not empty user}">
            <p  class="nav-item"><a href="friends.jsp" class="nav-link">friends</a> </p>
        </c:when>
    </c:choose>
    </nav>
</header>
<main class="container-lg">

<h2>Contact Overview</h2>

<P id="count">Count: dummy</P>
<div class="container-lg">
    <table class="table table-striped table-responsive-lg">
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

<h2>add person</h2>
<form action="" class="form-group">
    <label for="fname">First Name:</label>
    <input type="text" id="fname" name="fname" class="form-control">
    <br>

    <label for="lname">Last Name:</label>
    <input type="text" id="lname" name="lname" class="form-control">
    <br>

    <label for="email">Email:</label>
    <input type="text" id="email" name="email" class="form-control">
    <br>

    <label for="GSM">GSM:</label>
    <input type="text" id="GSM" name="GSM" class="form-control">
    <br>

    <label for="date">Date:</label>
    <input type="text" id="date" name="date" class="form-control">
    <br>

    <label for="room">Room:</label>
    <input type="text" id="room" name="room" class="form-control">
    <br>

    <label for="password">Password:</label>
    <input type="text"  id="password" name="password" class="form-control">
    <br>

    <input type="button" value="add person" onclick="addPerson()" class="btn btn-primary">

</form>
<c:choose>
    <c:when test="${not empty user}">
        <p>Welcome ${user.getFirstName()}!</p>
        <form method="post" action="Controller?command=LogOut" class="form-group">
            <p>
                <input type="submit" id="logoutbutton" value="Log Out" class="btn btn-primary">
            </p>
        </form>
    </c:when>
    <c:otherwise>
        <h2>Log in</h2>
        <form action="Controller?command=LogIn" method="post" class="form-group">

            <label for="emaillogin">Your email</label>
            <input type="text" id="emaillogin" name="emaillogin" class="form-control">
            <br>

            <label for="passwordlogin">Your password</label>
            <input type="text" id="passwordlogin" name="passwordlogin" class="form-control">
            <br>

            <input value="Log In" type="submit" class="btn btn-primary">

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
</main>
</body>
</html>
