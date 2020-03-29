<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Verwijder Person</title>
</head>
<body>
<article>
    <p>Ben je zeker dat je deze persoon ${param.email} ${param.firstname} ${param.lastname} wil verwijderen?</p>
    <form action="Controller?command=verwijderPerson&userid=${param.userid}&email=${param.email}&firstname=${param.firstname}&lastname=${param.lastname}" method="POST">
        <input type="submit" value="Zeker">
        <button type="submit" formaction="Controller?command=overview">Toch niet </button>
    </form>
</article>
</body>
</html>
