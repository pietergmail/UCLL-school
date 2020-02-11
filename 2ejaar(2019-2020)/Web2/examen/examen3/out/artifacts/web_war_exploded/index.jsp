<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="nl">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <title>Bikes</title>
    <link rel="stylesheet" media="all" href="css/reset.css">
    <link rel="stylesheet" media="all" href="css/project.css">
    <link href='https://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>
</head>

<body>
<jsp:include page="header.jsp">
    <jsp:param name="page" value="overview"/>
</jsp:include>

<div class="container">
    <main>
        <section>
            <h2>My Bikes</h2>

            <form action="Servlet?command=cookie" method="post">
                <p>
                    <input type="checkbox" name="nieuwsbrief" value="Nieuwsbrief" ${brief == "Nieuwsbrief"?'checked':''}>Ja, ik wil de nieuwsbrief ontvangen <br>
                </p>
                <p>
                    <input type="submit" value="Submit">
                </p>
            </form>
        </section>
    </main>

</div>
</body>
</html>
