<%--
  Created by IntelliJ IDEA.
  User: Ben Verbiest
  Date: 14/03/2019
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="nl">
<head>
    <link rel="stylesheet" href="style.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8">
    <title>Kosten verdelen - Voeg persoon toe</title>
</head>
<body>
<header>
    <h1>Toevoegen van personen</h1>
    <nav>
        <ul>
            <li><a href="index.jsp">Home</a></li>
            <li><a class="actief" href="addPersoon.jsp">Voeg Persoon Toe</a></li>
            <li><a href="Servlet">Overzicht</a></li>
        </ul>
    </nav>
</header>

<main>
    <h2>Voeg persoon toe:</h2>
    <div>
        <form action="Servlet" method="POST">
            <label for="name">naam</label>
            <input type="text" id="name" name="naam" required>

            <label for="bedrag">Bedrag</label>
            <input type="number" id="bedrag" step="0.01" name="amount" required>

            <label for="hoogte">hoogte</label>
            <input type="number" id="hoogte" name="hight" required>

            <input type="submit" value="Submit">
        </form>
    </div>
</main>

<footer>
    <p>Webontwikkeling 2</p> <p>-</p> <p>2018 - 2019</p>
</footer>
</body>
</html>