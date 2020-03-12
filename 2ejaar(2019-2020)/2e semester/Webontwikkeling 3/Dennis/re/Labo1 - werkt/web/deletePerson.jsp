<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>delete</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="container">
    <header>
        <h1>
            <span>Web shop</span>
        </h1>
        <jsp:include page="header.jsp">
            <jsp:param name="page" value="delete    "/>
        </jsp:include>
        <h2>delete</h2>

    </header>
    <main>
        <h2>delete: ${param.name}</h2>
        <form action="Controller?command=DeletePersonSubmit" method="post">
            <label for="submit">Are you sure to delete?</label>
            <input type="submit" id="submit">

            <input type="hidden" name="id" value="<c:out value='${param.id}'/>">
        </form>
        <a href="Controller?command=overview">cancel delete</a>
    </main>
    <footer> &copy; Webontwikkeling 3, UC Leuven-Limburg</footer>
</div>
</body>
</html>