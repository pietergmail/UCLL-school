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
    <title>VAK - Inschrijven</title>
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

            <p class="span">
                Wil jij jou jeugdige en avontuurlijke zelf bovenhalen? Dit kan tijdens deze enthousiaste en exclusieve evenementen die VAK organiseert. Deze evenementen variëren van daguitstappen tot een weekje weg in de wilde natuur. Doordat vak in een besloten kring werkt zal er altijd een vrolijke sfeer aanwezig zijn die je innerlijke zelf naar boven haalt!
            </p>

    <form method="POST" id="Controller?command=home" enctype="multipart/form-data">
            <article>
                <h2>Inschrijven voor volgende VAK</h2>
            <p class="textfield">
                <label for="naam">Vul hier u achternaam in. (*)</label>
                <br>
                <input type="text" name="naam" id="naam" required>
            </p>
            <p class="textfield">
                <label for="voornaam">Vul hier u voornaam in. (*)</label>
                <br>
                <input type="text" name="voornaam" id="voornaam" required>
            </p>

            <p class="textfield">
                <label for="adres">Vul hier u adres in</label>
                <br>
                <input type="text" name="adres" id="adres" required>
            </p>
            <p class="textfield">
                <label for="email">vul hier u emailadres in(*)</label>
                <br>
                <input type="email" name="email" id="email" required>
            </p>
            <p class="textfield">
                <label for="telephone">Vul hier u geboortedatum in.</label>
                <br>
                <input type="tel" name="telphone" id="telephone">
            </p>
        <p><input type="submit" value="Send"/></p>
                <p>* betekent verplicht veld.</p>
            </article>
    </form>

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
