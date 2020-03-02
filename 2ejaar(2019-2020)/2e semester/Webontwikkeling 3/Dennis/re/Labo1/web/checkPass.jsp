<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>check password</title>
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
        <h2>check password</h2>

    </header>
    <main>
        <h2>check: ${param.name}</h2>
        <form action="Controller?command=checkPasswordSubmit" method="post">
            <label for="submit">Enter the password: </label>
            <input type="password" name="password" value="">

            <input type="submit" id="submit">
            <input type="hidden" name="id" value="${param.id}">
        </form>
        <a href="Controller?command=overview">cancel delete</a>
    </main>
    <footer> &copy; Webontwikkeling 3, UC Leuven-Limburg</footer>
</div>
</body>
</html>