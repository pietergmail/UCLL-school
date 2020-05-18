<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="style.css" />
<title>Demo Authorization - All Roles</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<%-- <jsp:include page="headerWithAuthorization.jsp"/>
 --%>
<main>
<h2>All Roles</h2>
<p>Everyone who logged in has acces to this page.</p>
<p> You can see this page because you are a ${sessionScope.user.role }.</p>
</main>

</body>
</html>