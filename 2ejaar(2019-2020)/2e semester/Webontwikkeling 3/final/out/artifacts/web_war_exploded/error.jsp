<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>Error</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="container">
    <header>
        <h1>
            <span>Web shop</span>
        </h1>
        <jsp:include page="header.jsp">
            <jsp:param name="page" value=""/>
        </jsp:include>
        <h2>Home</h2>

    </header>
    <main>

        <article><h1 style="font-size: 48px">I am error!</h1>
            <p>You caused a ${pageContext.exception} on the server!</p>
            <P>You are not supposed to do that, now the server crashed</P>
            <p>thx.</p>
            <p>
                <a href="Controller">Home</a></p>
        </article>
    </main>
    <footer> &copy; Webontwikkeling 3, UC Leuven-Limburg</footer>
</div>
</body>
</html>