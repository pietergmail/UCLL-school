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
       <p>Are you sure you want to delete <c:out value="${param.name}"/> </p>
        <form method="post" action="Controller?command=Delete" novalidate="novalidate">
            <!-- novalidate in order to be able to run tests correctly -->

            <p><input type="radio" name="radio" value="yes" id="yes">
            <label for="yes">Yes</label></p>

            <p><input type="radio" id="no" name="radio" value="no">
            <label for="no">no</label></p>

            <p><input type="submit" id="addProduct" value="Add Product"></p>
        </form>

        </form>
    </main>
    <footer>
        &copy; Webontwikkeling 3, UC Leuven-Limburg
    </footer>
</div>

</body>
</html>
