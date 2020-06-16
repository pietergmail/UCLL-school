<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header>
    <h1>Wielerclub Torenvrienden</h1>
    <nav>
        <ul>
            <li ${param.page eq 'Home'?'id="actual"':''}><a href="Servlet?command=Home">Home</a></li>
            <li ${param.page eq 'Leden'?'id="actual"':''}><a href="Servlet?command=Leden">Leden</a></li>
            <li ${param.page eq 'NiveauGroepen'?'id="actual"':''}><a href="Servlet?command=NiveauGroepen">Niveaugroepen</a></li>
            <li ${param.page eq 'Login'?'id="actual"':''}><a href="Servlet?command=LogIn">Login</a></li>

            <c:if test="${user == 'admin'}">
                <li ${param.page eq 'Vegetarian Product'?'id="actual"':''}><a href="Servlet?command=VegetarianProductOverview">Vegetarian Products</a></li>
            </c:if>
        </ul>
    </nav>
</header>
