<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@page import="domain.db.MemberDB"%>
<%@page import="domain.model.Member"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="nl">
<head>
    <meta name="robots" content="noindex"/>
    <meta name="Description" content="De geschiedenis Pagina.">
    <meta name="theme-color" content="#339933"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="utf-8"/>
    <title>VAK - Geschiedenis</title>
    <link rel="stylesheet" type="text/css" href="css/reset.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="icon" type="image/png" href="img/logo.png">
</head>
<body>
<header>
    <div>
        <img src="img/logo.png" alt="logo vak">

        <h1 lang="nl">Verbond voor Avontuurlijke Kampen</h1>
    </div>
    <nav>
        <ul>
            <li><a href="Controller?command=home">Home</a></li>
            <li><a href="inschrijven.jsp">Inschrijven</a></li>
            <li><a href="Controller?command=overview">overzicht ingeschreven</a></li>
        </ul>
    </nav>
</header>
<main>

    <table>
        <thead>
            <tr>
                <th>Voornaam</th>
                <th>Achternaam</th>
                <th>adres</th>
                <th>email</th>
                <th>geboortedatum</th>
                <th>edit</th>
                <th>delete</th>
        </thead>
        <tbody>
        <% ArrayList<Member> members = (ArrayList<Member>)request.getAttribute("members"); %>
        <%
            for(Member member: members){
        %>
            <td><%=member.getVoornaam()%></td>
            <td><%=member.getAchternaam()%></td>
            <td><%=member.getAdres()%></td>
            <td><%=member.getEmail()%></td>
            <td><%=member.getdatum()%></td>
            <th><a>pas aan</a></th>
            <th><a>Delete</a></th>
        </tr>
    <%
            }
    %>
        </tbody>
    </table>
</main>
    <footer>
    <p>
        Contactpersoon: Benjamin Delauré <br>
        <br>
        GROTE BAAN 89, 3150 WESPELAAR<br>
        Mail: benjamindelaure@gmail.com<br>
    </p>
</footer>
</body>
