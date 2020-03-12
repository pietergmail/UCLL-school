<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta charset="UTF-8">
    <title>Overview</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="container">
    <header>
        <h1><span>Web shop</span></h1>
        <nav>
            <ul>
                <li><a href="Controller">Home</a></li>
                <li id="actual"><a href="Controller?command=overview">Overview</a></li>
                <li><a href="Controller?command=producten">Products</a></li>
                <li><a href="Controller?command=addproductpage">Add product</a></li>
                <li><a href="Controller?command=signUp">Sign up</a></li>
            </ul>
        </nav>
        <h2>
            User Overview
        </h2>

    </header>
    <main>

        <c:choose>
            <c:when test="${personen!=null}">
                <table>
                    <tr>
                        <th>E-mail</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Verwijder</th>
                    </tr>
                    <c:forEach var="persoon" items="${personen}">
                        <tr>
                            <td>${persoon.email}</td>
                            <td>${persoon.firstName}</td>
                            <td>${persoon.lastName}</td>
                            <td><a href="Controller?command=verwijderpersonpage&userid=${persoon.userid}&email=${persoon.email}&firstname=${persoon.firstName}&lastname=${persoon.lastName}"> Verwijder</a></td>
                        </tr>
                    </c:forEach>


                    <caption>Users Overview</caption>
                </table>
            </c:when>
            <c:otherwise>
                <p>Er zijn nog geen personen toegevoegd.</p>
            </c:otherwise>
        </c:choose>

    </main>
    <footer>
        &copy; Webontwikkeling 3, UC Leuven-Limburg
    </footer>
</div>
</body>
</html>