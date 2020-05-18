<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="style.css"/>
    <title>Demo Authentication - EveryOne</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<main>
    <h2>EveryOne</h2>
    <c:if test="${user ne null}">
        <p>Hi ${user.name}. Nice to meet you.</p>
    </c:if>
    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusamus dicta error harum id quas repellendus.</p>
</main>

</body>
</html>