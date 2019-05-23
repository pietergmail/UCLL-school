<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"   %>
<c:set var="page" value="overview" />
<html>
<head>
    <title>delete?</title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="container">
    <jsp:include page="header.jsp">
        <jsp:param name="page" value="overview"/>
    </jsp:include>
    <main>
       <p>Are you sure you want to delete ${param.name} </p>
        <form method="post" action="Controller?command=Delete&id=${param.id}" novalidate="novalidate">
            <!-- novalidate in order to be able to run tests correctly -->

            <p><input type="submit" value="yes" name="delete"></p>

            <p><input type="submit" value="no" name="delete"></p>
        </form>

        </form>
    </main>
    <footer>
        &copy; Webontwikkeling 3, UC Leuven-Limburg
    </footer>
</div>

</body>
</html>
