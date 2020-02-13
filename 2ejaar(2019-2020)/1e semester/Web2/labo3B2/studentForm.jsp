<%--
  Created by IntelliJ IDEA.
  User: Dennis
  Date: 11/03/2019
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>form</title>
</head>
<body>
    <h1>form</h1>
    <article>
        <form action="StudentInfo" method="post">
            <label for="naam">naam:</label>
            <input type="text" id="naam" name="naam">
            <label for="voornaam">voornaam:</label>
            <input type="text" id="voornaam" name="voornaam">
            <label for="leeftijd">leeftijd:</label>
            <input type="text" id="leeftijd" name="leeftijd">
            <label for="richting">richting:</label>
            <input type="text" id="richting" name="richting">
            <input type="submit">

        </form>
    </article>
</body>
</html>
