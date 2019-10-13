<%--
  Created by IntelliJ IDEA.
  User: Dennis
  Date: 25/02/2019
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <p id="antwoord"> Het antwoord is: <%= request.getAttribute("result") %> keer.</p>
</body>
</html>
