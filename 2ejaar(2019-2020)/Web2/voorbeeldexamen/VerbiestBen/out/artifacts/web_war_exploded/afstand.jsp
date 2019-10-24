<%--
  Created by IntelliJ IDEA.
  User: Ben Verbiest
  Date: 15/03/2019
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="nl">
<head>
    <link rel="stylesheet" href="style.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8">
    <title>Kosten verdelen - Overzicht</title>
</head>
<body>
<header>
    <h1>Afstand</h1>
    <nav>
        <ul>
            <li><a href="index.jsp">Home</a></li>
            <li><a href="addPersoon.jsp">Voeg Persoon Toe</a></li>
            <li><a href="Servlet">Overzicht</a></li>
        </ul>
    </nav>
</header>
<main>
    <p>U fietste <%=request.getAttribute("foutieveHoogte")%> km, dit is geen geldige afstand.</p>
</main>

<footer>
    <p>Webontwikkeling 2</p> <p>-</p> <p>2018 - 2019</p>
</footer>
</body>
</html>
