<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Verwijder Product</title>
</head>
<body>
<article>
    <p>Ben je zeker dat je dit product ${param.name} ${param.description} ${param.price} wil verwijderen?</p>
    <form action="Controller?command=verwijderProduct&productid=${param.productId}&name=${param.name}&description=${param.description}&price=${param.price}" method="POST">
        <input type="submit" value="Zeker">
        <button type="submit" formaction="Controller?command=producten">Toch niet </button>
    </form>
</article>
</body>
</html>
