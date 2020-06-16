<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
        <c:choose>
            <c:when test="${person==null}">
                <form novalidate="novalidate" method="post" action="Controller?command=signUpSubmit">
                    <!-- novalidate in order to be able to run tests correctly -->
                    <p><label for="userid">User id</label><input type="text" id="userid" name="userid"
                                                                 required value="${fn:escapeXml(param.prevId)}"></p>
                    <p><label for="firstName">First Name</label><input type="text" id="firstName" name="firstName"
                                                                       required value="${fn:escapeXml(param.prevFirstName)}"></p>
                    <p><label for="lastName">Last Name</label><input type="text" id="lastName" name="lastName"
                                                                     required value="${fn:escapeXml(param.prevLastName)}"></p>
                    <p><label for="email">Email</label><input type="email" id="email" name="email" required value="${fn:escapeXml(param.prevEmail)}"></p>
                    <p><label for="password">Password</label><input type="password" id="password" name="password"
                                                                    required value="${fn:escapeXml(param.prevPassword)}"></p>
                    <p>please select the role:</p>
                    <p>
                        <input type="radio" id="User" name="role" value="User" checked>
                    <label for="User">User</label>
                    </p>

                    <p>
                        <input type="radio" id="Admin" name="role" value="Admin">
                        <label for="Admin">Admin</label>
                    </p>


                    <p><input type="submit" id="signUp" value="Sign Up"></p>

                </form>
            </c:when>
            <c:otherwise>
                <p>Name: ${person.firstName} ${person.lastName}</p>
                <p>email: ${person.email}</p>
                <p>role: ${person.role}</p>
            </c:otherwise>
        </c:choose>
    </main>
    <footer>
        &copy; Webontwikkeling 3, UC Leuven-Limburg
    </footer>
</div>
</body>
</html>
