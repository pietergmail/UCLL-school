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
        <c:choose>
            <c:when test="${person!=null}">
                <p>Welcome, ${person.firstName}, ${person.role}</p>
                <form action="Controller?command=LogOut" method="post">
                    <input type="submit" value="Log Out">
                </form>
            </c:when>
            <c:otherwise>
                <p>Please log in</p>
                <c:if test="${error != null}">
                    <p class="error">
                        ${error}
                    </p>
                </c:if>
                <form action="Controller?command=Login" method="post">
                    <p class="input">
                        <label for="id">Your id</label>
                        <input type="text" id="id" name="id">
                    </p>
                    <p class="input">
                        <label for="password">Your password</label>
                        <input type="text" id="password" name="password">
                    </p>
                    <input type="submit" value="Log In">
                </form>
            </c:otherwise>
        </c:choose>
    </main>
    <footer> &copy; Webontwikkeling 3, UC Leuven-Limburg</footer>
</div>
</body>
</html>