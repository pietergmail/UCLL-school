<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>Home</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="container">
    <header>
        <h1>
            <span>Web shop</span>
        </h1>
        <jsp:include page="header.jsp">
            <jsp:param name="page" value="index"/>
        </jsp:include>
        <h2>Home</h2>

    </header>
    <main> Sed ut perspiciatis unde omnis iste natus error sit
        voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque
        ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae
        dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit
        aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos
        qui ratione voluptatem sequi nesciunt.
        <br>
        <a href="Controller?command=changeTeam">
            <c:choose>
                <c:when test="${IndexPicture == 'yes' or cookie.IndexPicture.value == 'yes'}">In the future, don't show this picture anymore</c:when>
                <c:when test="${IndexPicture == 'no' or IndexPicture == null}">Please, show my team</c:when>
            </c:choose>
        </a>
        <c:choose>
            <c:when test="${IndexPicture == 'yes' or cookie.IndexPicture.value == 'yes'}"><img src="images/belgischHockeyTeam.jpg" alt="hockey team"></c:when>
        </c:choose>
    </main>
    <footer> &copy; Webontwikkeling 3, UC Leuven-Limburg</footer>
</div>
</body>
</html>