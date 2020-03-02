<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<header>
    <h1>Mijn Veggie Website</h1>
    <nav>
        <ul>
            <li><a href="Controller">Home</a></li>
            <c:if test="${not empty userRole}">
                <li><a href="Controller?action=overview">Products</a></li>

            </c:if>
            <li><a href="Controller?action=js">Javascript</a></li>
            <c:if test="${not empty userRole}">

            <li><a href="Controller?action=vegetarian">Vegetarian Products</a></li>
            </c:if>
        </ul>
    </nav>
</header>