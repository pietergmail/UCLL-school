<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true" %>
<html>
<head>
    <title>Something wrong</title>
</head>
<body>
    <main>
        <p>Sorry! Something went wrong...</p>
        <p>${pageContext.exception}</p>
        <p>Go <a href="Controller">home</a></p>
    </main>
</body>
</html>
