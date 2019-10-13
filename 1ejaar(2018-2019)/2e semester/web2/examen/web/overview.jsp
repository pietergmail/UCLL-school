<!-- Made possible by Dennis_bot
the bot who can't do jack shit
if yo have questions
don't bother to ask
as we will all die
and nothing mathers in this world
--><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="nl">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <title>brief</title>
    <link rel="stylesheet" media="all" href="css/reset.css">
    <link rel="stylesheet" media="all" href="css/project.css">
    <link href='https://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>
</head>

<body>
<jsp:include page="header.jsp">
    <jsp:param name="page" value="brief"/>
</jsp:include>

<div class="container">
    <main>
        <section>
            <h2>My Bikes</h2>
            <ul>
                <c:forEach items="${bikes}" var="bike">
                    <p>${bike.itemId}, ${bike.brand}, ${bike.category}, ${bike.description}, ${bike.price}</p>
                </c:forEach>
            </ul>
        </section>
    </main>

</div>
</body>
</html>
