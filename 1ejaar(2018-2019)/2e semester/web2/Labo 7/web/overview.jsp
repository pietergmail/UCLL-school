<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="domain.db.DierDB"%>
<%@page import="domain.model.Dier"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bekijk alle dieren</title>
<link rel="stylesheet" type="text/css" href="style/style.css">
</head>
<body>
	<div id="container">
	<header>
		<h1>Mijn huisdieren</h1>
		<nav>
			<ul>
				<li><a href="Controller?command=home">Home</a></li>
				<li><a href="add.jsp">Voeg Toe</a></li>
				<li><a href="Controller?command=overview">Overzicht</a></li>
			</ul>
		</nav>
	</header>		
	<main>
		<h2>Bekijk alle dieren</h2>
		<table>
			<thead>
				<tr>
					<th>Naam</th>
					<th>Soort</th>
					<th>Voedsel</th>
			</thead>
			<tbody>
			<% ArrayList<Dier> dieren = (ArrayList<Dier>)request.getAttribute("dieren"); %>
			<%
				for (Dier dier : dieren) {
			%>
				<tr>
					<td><%=dier.getNaam()%></td>
					<td><%=dier.getSoort()%></td>
					<td><%=dier.getVoedsel()%></td>
				</tr>
			<%
				}
			%>
			</tbody>
		</table>
	</main>
	<footer>
		WebOntwikkeling 2 - 2018-2019
	</footer>
	</div>
</body>
</html>