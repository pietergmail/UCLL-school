<%@ page import="java.time.Period" %>
<%@ page import="domain.db.PersoonDB" %>
<%@ page import="domain.model.Persoon" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Ben Verbiest
  Date: 1/03/2019
  Time: 21:05
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
    <h1>Overzicht van alle aanwezige personen</h1>
    <nav>
        <ul>
            <li><a href="index.jsp">Home</a></li>
            <li><a href="addPersoon.jsp">Voeg Persoon Toe</a></li>
            <li><a class="actief" href="Servlet">Overzicht</a></li>
        </ul>
    </nav>
</header>
<main id="overzichtMain">
    <%ArrayList<Persoon> db = ((ArrayList<Persoon>) request.getAttribute("database"));%>
    <h2>De betaling wordt verdeeld over <%=db.size()%> aantal personen</h2>

    <table id="overzicht">
        <tr>
            <th>Naam</th>
            <th>Bedrag</th>
        </tr>
        <%
            for (Persoon p:db) {
        %>
        <tr>
            <td><%=p.getNaam()%></td>
            <td><%=p.getBedrag()%></td>
            <td><%=p.getHoogte()%></td>
        </tr>
        <%}%>
    </table>

    <p>
        <%=request.getAttribute("meestBetaald")%>
        heeft het meeste betaald, dit ter waarde van
        <%=request.getAttribute("hoogsteBedrag")%>
        euro.
    </p>
    <p>
        De gemiddelde afstand is gelijk aan <%=request.getAttribute("gemiddeldeAfstand")%>
    </p>
</main>

<footer>
    <p>Webontwikkeling 2</p> <p>-</p> <p>2018 - 2019</p>
</footer>
</body>
</html>