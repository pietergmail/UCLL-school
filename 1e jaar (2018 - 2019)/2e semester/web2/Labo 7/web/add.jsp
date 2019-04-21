<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Voeg een huisdier toe</title>
    <link rel="stylesheet" type="text/css" href="style/style.css"/>
</head>
<body>
<div id="container">
    <header>
        <h1>Mijn huisdieren</h1>
        <nav>
            <ul>
                <li><a href="Controller?command=home">Home</a></li>
                <li><a href="add.jsp">Voeg Toe</a></li>
                <li><a href="Controller?command=overview">Overzicht</a></li>
            </ul>
        </nav>
    </header>
    <main>
        <% ArrayList<String> errors = (ArrayList<String>) request.getAttribute("errors");
            if (errors != null) { %>
        <div class="alert alert-danger">
            <ul>
                <% for (String error : errors) {%>
                <li><%= error %>
                </li>
                <% } %>
            </ul>
        </div>
        <% } %>
        <h2>Voeg je huisdier toe</h2>
        <form method="POST" action="Controller?command=add" novalidate>
            <p class="form-group <%=request.getAttribute("naamClass")%>">
                <label class="control-label" for="naam">Naam:</label>
                <input id="naam" name="naam" type="text"
                       value="<%= request.getAttribute("naamPreviousValue") != null ? request.getAttribute("naamPreviousValue") : ""%>">
            </p>
            <p class="form-group <%=request.getAttribute("soortClass")%>">
                <label class="control-label" for="soort">Soort:</label>
                <input id="soort" name="soort" type="text"
                       value="<%= request.getAttribute("soortPreviousValue") != null ? request.getAttribute("soortPreviousValue") : ""%>">
            </p>
            <p class="form-group <%=request.getAttribute("voedselClass")%>">
                <label class="control-label" for="voedsel">Aantal keer eten per dag:</label>
                <input id="voedsel" name="voedsel" type="number" max="10" min="1"
                       value="<%= request.getAttribute("voedselPreviousValue") != null ? request.getAttribute("voedselPreviousValue") : ""%>">
            </p>
            <p>
                <input type="submit" value="Voeg dier toe" id="submit">
            </p>
            <p class="left">Alle velden zijn verplicht.</p>
        </form>
    </main>
    <footer>
        WebOntwikkeling 2 - 2018-2019
    </footer>
</div>
</body>
</html>