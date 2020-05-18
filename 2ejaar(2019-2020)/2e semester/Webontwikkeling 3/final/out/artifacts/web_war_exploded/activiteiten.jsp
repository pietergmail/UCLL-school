<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>Activities</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="container">
    <header>
        <h1>
            <span>Activities</span>
        </h1>
        <jsp:include page="header.jsp">
            <jsp:param name="page" value="activiteiten"/>
        </jsp:include>
        <h2>Activities</h2>

    </header>
    <main>
        <table>
            <tr><th>time</th><th>page</th></tr>
            <c:forEach items="${pages}" var="page">
                <c:set var = "index" value = "${fn:indexOf(page, '=')}"/>
                <tr><td>${fn:substring(page, 0,index)}</td><td>${fn:substring(page, index+1,-1)}</td></tr>
            </c:forEach>
        </table>
    </main>
    <footer> &copy; Webontwikkeling 3, UC Leuven-Limburg</footer>
</div>
</body>
</html>