<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Veggie</title>
    <link rel="stylesheet" href="css/sample.css">
</head>
<body>
<jsp:include page="header.jsp">
<jsp:param name="page" value="Vegetarian Products"/>
</jsp:include>
<main>
    <article>
        <h1>Vegetarian products</h1>
        <table>

            <tr>
                <th>Name</th>
                <th>Price</th>
            </tr>
                <tr>
                    <td>names are fake</td>
                    <td>price is in gold</td>
                </tr>
        </table>
    </article>
</main>
</body>
</html>