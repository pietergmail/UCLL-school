<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta charset="UTF-8">
    <title>Sign Up</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="container">
    <header>
        <h1><span>Web shop</span></h1>
        <jsp:include page="header.jsp">
            <jsp:param name="page" value="signup"/>
        </jsp:include>
        <h2>
            Sign Up
        </h2>

    </header>
    <main>
        <c:if test="${errors != null}">
            <div class="alert-danger">
                <ul>
                    <c:forEach var="error" items="${errors}">
                        <li>${error}</li>
                    </c:forEach>
                </ul>
            </div>
        </c:if>

        <form novalidate="novalidate" method="post" action="Controller?command=signUpSubmit">
            <!-- novalidate in order to be able to run tests correctly -->
            <p><label for="userid">User id</label><input type="text" id="userid" name="userid"
                                                         required value="${prevId}"></p>
            <p><label for="firstName">First Name</label><input type="text" id="firstName" name="firstName"
                                                               required value="${prevFirstName}"></p>
            <p><label for="lastName">Last Name</label><input type="text" id="lastName" name="lastName"
                                                             required value="${prevLastName}"></p>
            <p><label for="email">Email</label><input type="email" id="email" name="email" required value="${prevEmail}"></p>
            <p><label for="password">Password</label><input type="password" id="password" name="password"
                                                            required value="${prevPassword}"></p>
            <p><input type="submit" id="signUp" value="Sign Up"></p>

        </form>
    </main>
    <footer>
        &copy; Webontwikkeling 3, UC Leuven-Limburg
    </footer>
</div>
</body>
</html>
