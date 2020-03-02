<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta charset="UTF-8">
    <title>Overview</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="container">
    <header>
        <h1><span>Web shop</span></h1>
        <jsp:include page="header.jsp">
            <jsp:param name="page" value="personenOverview"/>
        </jsp:include>
        <h2>
            User Overview
        </h2>

    </header>
    <main>
        <c:choose>
            <c:when test="${awnser == 'true'}">
                <p>Password is correct</p>
            </c:when>
            <c:when test="${awnser == 'false'}">
                <p>Password is incorrect</p>
            </c:when>

        </c:choose>
        <table>
            <tr>
                <th>E-mail</th>
                <th>First Name</th>
                <th>Last Name</th>
            </tr>
            <c:forEach items="${personen}" var="person">
                <tr>

                    <td>${person.email}</td>
                    <td>${person.firstName}</td>
                    <td>${person.lastName}</td>
                    <td><a href="deletePerson.jsp?id=<c:out value='${person.userid}'></c:out>&name=<c:out value='${person.firstName}'></c:out>">delete</a></td>
                    <td><a href="checkPass.jsp?id=<c:out value='${person.userid}'></c:out>&name=<c:out value='${person.firstName}'></c:out>">check</a></td>
                </tr>

            </c:forEach>

            <caption>Users Overview</caption>
        </table>
    </main>
    <footer>
        &copy; Webontwikkeling 3, UC Leuven-Limburg
    </footer>
</div>
</body>
</html>