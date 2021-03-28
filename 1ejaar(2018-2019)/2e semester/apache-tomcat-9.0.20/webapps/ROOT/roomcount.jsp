<%--
  Created by IntelliJ IDEA.
  User: herre
  Date: 15 Jan 2021
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Room Count</title>
    <script src="js/RoomCount.js"></script>
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

<h1>Room count</h1>
<div id="count_rooms">
    <p>dummy1</p>
    <p>dummy2</p>
    <p>dummy3</p>
    <p>dummy4</p>
</div>

</body>
</html>
