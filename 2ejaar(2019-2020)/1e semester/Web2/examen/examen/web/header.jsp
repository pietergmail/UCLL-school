<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: herre
  Date: 26/12/2019
  Time: 12:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header>
    <h1>
        <img src="images/bikesBanner.png" alt="banner My Bikes">
    </h1>

    <nav class="nav">
        <ul>
            <li ${param.page == 'index'?'id="actual"':""}><a href="Servlet?command=home">Home</a></li>
            <li ${param.page == 'overview'?'id="actual"':""}><a href="Servlet?command=overview">Overview</a></li>
            <li ${param.page == 'add'?'id="actual"':""}><a href="Servlet?command=add">add</a></li>
            <c:if test="${cookie.brief.value == 'Nieuwsbrief'}">
                <c:choose>
                <c:when test="${param.page == 'brief'}">
                    <li id="actual"><a href="Servlet?command=nieuwsbrief">nieuwsbrief</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="Servlet?command=nieuwsbrief">nieuwsbrief</a></li>
                </c:otherwise>
                </c:choose>
            </c:if>
        </ul>
    </nav>
</header>