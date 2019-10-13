<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@page import="domain.model.Member"%>
<!DOCTYPE html>
<html lang="nl">
<head>
    <meta name="robots" content="noindex"/>
    <meta name="Description" content="Inschrijvings pagina.">
    <meta name="theme-color" content="#339933"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="utf-8"/>
    <title>VAK</title>
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
        <div class="span">
            <p> Dit is de hoofdpagina van de  beste informatiebron over VAK kampen. Hier kan je alles vinden van onze geschiedenis
                tot alle info over aankomende evenementen. VAK-kampen zijn bedoeld voor Ex-leden van de
                lee
                rlingeraad van Don Bosco Haacht en vrienden.</p>
        </div>
        <article>
            <h2 lang="nl" class="A1"> Wat is VAK? </h2>

            <p class="A1" ><img src="img/benjamin_op_een_boom.JPG" alt="foto VAK" class="img"></p>
            <p>
                VAK is een non profit organisatie die kampen organiseert voor de jeugd.

            </p>
        </article>
        <article>
            <h2 lang="nl" class="A1"> wat wilt VAK bereiken?</h2>

            <p class="A1"><img src="img/groepsfoto.JPG" alt="groepsfoto VAK" class="img"></p>
            <p>
                Het doel van VAK is om met een leuke vriendengroep op avontuurlijke kampen te gaan.
            </p>
        </article>


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
