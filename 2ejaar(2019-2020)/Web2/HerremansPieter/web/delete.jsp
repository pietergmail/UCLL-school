<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="robots" content="noindex"/>
    <meta name="Description" content="Inschrijvings pagina.">
    <meta name="theme-color" content="#339933"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="utf-8"/>
    <title>Accordiona</title>
    <link rel="stylesheet" type="text/css" href="css/reset.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="icon" type="image/png" href="img/logo.png">
</head>
<body>
<header>
    <div>
        <img src="img/logo.png" alt="logo accordiona">

        <h1 lang="nl">Accordiona Tienen</h1>
    </div>
    <nav>
        <ul>
            <li><a href="index.jsp">Home</a></li>
            <li><a href="inschrijven.jsp">Inschrijven</a></li>
            <li><a href="Servlet">Ingeschreven</a></li>
        </ul>
    </nav>
</header>
<main>
    <h2>Wijzig informatie over een persoon</h2>
    <form method="POST" id="form" enctype="multipart/form-data" class="span" action="ingeschreven.jsp">
        <article>
            <h2>Verwijder persoon</h2>
            <p>Ben je zeker dat je deze persoon wilt verwijdern?</p>
            <p><input type="submit" value="Ja"/><input type="submit" value="Neen"></p>
        </article>
    </form>
</main>
<footer>
    <p>
        Lorem ipsum dolor sit amet, consectetur adipisicing elit. Facere id perspiciatis quam sit? Alias consectetur laborum nisi perspiciatis praesentium quia similique tempora totam! Animi asperiores illum ipsum laudantium, maiores repellat?
    </p>
</footer>
</body>
</html>