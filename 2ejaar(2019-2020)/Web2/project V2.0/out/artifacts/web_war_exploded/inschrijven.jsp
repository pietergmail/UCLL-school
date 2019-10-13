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
    <div><img src="img/logo.png" alt="logo accordiona">

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
<main class="inschrijvingen">

            <p class="span">
                Lorem ipsum dolor sit amet, consectetur adipisicing elit. Blanditiis non repellendus voluptatem. Alias dolorem illum iusto, nisi numquam quas repellendus rerum veritatis! Cupiditate iusto nemo nisi possimus praesentium soluta ullam?
            </p>

    <form method="POST" id="form" enctype="multipart/form-data" class="span">
            <p class="textfield">
                <label for="naam">Vul hier u naam in. (*)</label>
                <br>
                <input type="text" name="naam" id="naam" required>
            </p>
            <p class="textfield">
                <label for="datum">Vul hier u geboortedatum in.</label>
                <br>
                <input type="date" name="datum" id="datum">
            </p>

            <p class="textfield">
                <label for="instrument">Vul hier u instrument in. (*)</label>
                <br>
                <input type="text" name="instrument" id="instrument" required>
            </p>
            <p>
                Duid hier u geslacht aan.
            </p>
                <p>
                    <label for="contacttel">man:</label>
                    <input class="radio" type="radio" name="contact" id="contacttel" checked>
                </p>
                <p>
                    <label for="contactmail">vrouw:</label>
                    <input class="radio" type="radio" name="contact" id="contactmail">
                </p>
        <p><input type="submit" value="Send"/></p>
                <p>* betekent verplicht veld.</p>
    </form>
 </main>
<footer>
    <p>
        Lorem ipsum dolor sit amet, consectetur adipisicing elit. Architecto assumenda atque consequuntur, deleniti, eum exercitationem facere libero maiores modi natus nemo, obcaecati officiis omnis optio quis ut veritatis vero voluptate.
    </p>

</footer>
</body>
