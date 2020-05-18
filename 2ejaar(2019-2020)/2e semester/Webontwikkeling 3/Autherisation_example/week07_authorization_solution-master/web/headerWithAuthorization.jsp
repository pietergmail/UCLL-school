<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header>
    <h1>Demo Authorization</h1>
    <nav>
        <ul>
            <li><a href="Controller">Home</a></li>
            <li><a href="Controller?action=Everyone">Everyone</a></li>
            <c:if test="${user.role=='ADMIN' }">
                <li><a href="Controller?action=Admin">Admin</a></li>
            </c:if>
            <c:if test="${user.role=='ADMIN' || user.role=='CUSTOMER' }">
                <li><a href="Controller?action=AllRoles">All Roles</a></li>
            </c:if>
        </ul>
    </nav>
</header>