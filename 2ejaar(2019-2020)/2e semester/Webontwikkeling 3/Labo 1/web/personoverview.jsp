<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta charset="UTF-8">
<title>Overview</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="container">
<header>
<h1><span>Web shop</span></h1>
<nav>
<ul>
<li><a href="Servlet">Home</a></li>
<li id="actual"><a href="Servlet?command=overview">Overview</a></li>
<li><a href="Servlet?command=signUp">Sign up</a></li>
</ul>
</nav>
<h2>
User Overview
</h2>

</header><main>
<table>
<tr>
<th>E-mail</th>
<th>First Name</th>
<th>Last Name</th>
</tr>
<tr>
    <c:forEach items="${personen}" var="person">
        <td>${person.getEmail()}</td><td>${person.getFirstName()}</td><td>${person.getLastName()}</td>
    </c:forEach>
</tr>

<caption>Users Overview</caption>
</table>
</main>
<footer>
&copy; Webontwikkeling 3, UC Leuven-Limburg
</footer>
</div>
</body>
</html>