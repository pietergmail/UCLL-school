<%@ page import="domain.PersoonDB" %>
<%@ page import="java.util.Collection" %>
<%@ page import="domain.Persoon" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="robots" content="noindex"/>
    <meta name="Description" content="Inschrijvings pagina.">
    <meta name="theme-color" content="#339933"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="utf-8"/>
    <title>Accordiona</title>
    <link rel="stylesheet" type="text/css" href="css/reset.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="icon" type="image/png" href="img/logo.png">
</head>
<body>
<header>
    <div><img src="img/logo.png" alt="logo accordiona">

        <h1 lang="nl">Accordiona Tienen</h1>
    </div>
    <nav>
        <ul>
            <li><a href="index.jsp">Home</a></li>
            <li><a href="inschrijven.jsp">Inschrijven</a></li>
            <li><a href="Servlet">Ingeschreven</a></li>
        </ul>
    </nav>
</header>
<%
    ArrayList<Persoon> list = new ArrayList<Persoon>();
    list = (ArrayList<Persoon>) request.getAttribute("personen");
%>
<main>
    <table class="span">
        <thead>
        <tr>
            <th>Naam</th>
            <th>Geboortedatum</th>
            <th>Instrument</th>
            <th>Geslacht</th>
            <th>Edit</th>
            <th>Verwijder</th>
        </tr>
        </thead>
        <%
            for (Persoon persoon : list){
        %>
        <tbody>
        <tr>
            <td><%=persoon.getNaam()%></td>
            <td><%=persoon.getGeboortedatum()%></td>
            <td><%=persoon.getInstrument()%></td>
            <td><%=persoon.getStringgeslacht()%></td>
            <td><a href="edit.jsp">edit</a></td>
            <td><a href="delete.jsp">Verwijder</a></td>
            </tr>
        <%
            }
        %>
        </tbody>
    </table>

        <p class="span">De oudste persoon bij accordiona is *placeholder*</p>
</main>
<footer>
    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Architecto assumenda atque consequuntur, deleniti, eum exercitationem facere libero maiores modi natus nemo, obcaecati officiis omnis optio quis ut veritatis vero voluptate.

    </p>

</footer>
</body>
</html>