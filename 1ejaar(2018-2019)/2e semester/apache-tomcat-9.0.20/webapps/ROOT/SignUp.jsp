<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMNCOe7tC1doHpGoWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js" integrity="sha384-cn7l7gDp0eyniUwwAZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/" crossorigin="anonymous"></script>

    <title>Sign Up</title>
</head>
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
<body>
    <h2>Sign Up</h2>
    <form action="Controller?command=Register" method="post" class="form-group">

        <!--Extra info nodig omdat ik model van persoon hergebruik -->
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

        <input value="Sign Up" type="submit" class="btn btn-primary">

    </form>
</body>
</main>
</html>
