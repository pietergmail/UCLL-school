<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Niveaugroepen Wielerclub Torenvrienden</title>
    <link rel="stylesheet" href="css/sample.css">
</head>
<body>
<jsp:include page="header.jsp"/>

<main>
    <article>
        <h1>Alle niveaugroepen</h1>
        <table>
            <tr>
                <th>Naam</th>
                <th class="number">Richtsnelheid</th>
                <th class="omschrijving">Omschrijving</th>
            </tr>
            <c:forEach items="${groepen}" var="groepen">
                <tr>
                    <td>${groepen.naam}</td>
                    <td class="number">${groepen.richtsnelheid}</td>
                    <td class="omschrijving">${groepen.omschrijving}</td>
                </tr>
            </c:forEach>
        </table>
       
        <p><a href="#">Go home.</a></p>
    </article>
</main>
</body>
</html>