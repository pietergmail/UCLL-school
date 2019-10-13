<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="domain.model.Dier"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Mijn huisdieren</title>
<link type="text/css" href="style/style.css" rel="stylesheet" />
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
		<h2>Mijn liefste huisdieren</h2>
		<p>Maak kennis met mijn liefste huisdieren. Hoe heten ze, hoeveel
			eten ze, ... Ik noteer het hier allemaal.
		</p>
		<p>Het meest hongerige dier is <a id="calculatedValue"><%= ((Dier)request.getAttribute("meestHongerige")).getNaam() %></a>.</p>
		<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quia
			culpa esse. Delectus nemo similique reiciendis provident quas sunt
			fuga numquam neque quibusdam eum libero eius sit nam asperiores sequi
			voluptatum!</p>

	</main>
	<footer>
		WebOntwikkeling 2 - 2018-2019
	</footer>
	</div>
</body>
</html>