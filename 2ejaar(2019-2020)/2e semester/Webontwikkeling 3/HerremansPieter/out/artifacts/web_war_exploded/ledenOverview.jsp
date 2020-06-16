<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Leden Wielerclub Torenvrienden</title>
    <link rel="stylesheet" href="css/sample.css">
</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="page" value="Leden"/>
</jsp:include>

<main>
    <article>
        <h1>Alle leden</h1>
        <table>
            <tr>
                <th>Email</th>
                <th>Naam</th>
                <th>Niveaugroep</th>
            </tr>
            <c:forEach items="${leden}" var="leden">
                <tr>
                    <td>${leden.email}</td>
                    <td>${leden.naam}</td>
                    <td>${leden.niveaugroep}</td>
                </tr>
            </c:forEach>
        </table>
       
        <p><a href="Servlet?command=Home">Go home.</a></p>

        <form action="Servlet?command=SortByName" method="post">
            <input class="small" type="submit" value="Sort By Name">
        </form>

    </article>
</main>
</body>
</html>