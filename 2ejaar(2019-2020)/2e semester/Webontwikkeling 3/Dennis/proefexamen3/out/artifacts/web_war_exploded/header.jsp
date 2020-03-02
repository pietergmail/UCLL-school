<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<header>
	<h1>Mijn Veggie Website</h1>
	<nav>
		<ul>
			<li><a href="Controller?action=Home">Home</a></li>
			<c:if test="${not empty username}"><li><a href="Controller?action=Overview">Products</a></li></c:if>
			<li><a href="javascript.html">Javascript</a></li>
			<c:if test="${not empty username and username.stringValue eq 'AdMin'}"><li><a href="Controller?action=Vegetarian">Vegetarian Products</a></li></c:if>
		</ul>
	</nav>
</header>