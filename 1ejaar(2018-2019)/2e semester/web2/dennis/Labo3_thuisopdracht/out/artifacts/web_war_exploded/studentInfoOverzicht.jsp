<%@ page import="java.util.ArrayList" %>
<%@ page import="domain.Student" %>
<%@ page import="domain.StudentDB" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% ArrayList<Student> db = (ArrayList<Student>)request.getAttribute("db");%>
<html>
<head>
    <title>Student Info: Overzicht</title>
    <style>
        thead{
            color: white;
            background-color: #3e7a8b;
        }
        tbody tr td{
            color:black;
        }
        tbody tr:nth-child(even){
            background-color: #b5e1e7;
        }
        tbody tr:nth-child(odd){
            background-color: #8f94cb;
        }

    </style>
</head>
<body>
    <nav>
        <ul>
            <li><a href="/StudentInfo">overzicht</a></li>
            <li><a href="studentForm.jsp">form</a></li>
        </ul>
    </nav>
    <table>
        <thead>
            <tr>
                <th>Naam</th>
                <th>Voornaam</th>
                <th>Leeftijd</th>
                <th>Studierichting</th>
            </tr>
        </thead>
        <tbody>
        <%
            for(Student student : db){
                out.println("<tr>");
                    out.println("<td>" + student.getNaam() + "</td>");
                    out.println("<td>" + student.getVoornaam() + "</td>");
                    out.println("<td>" + student.getLeeftijd() + "</td>");
                    out.println("<td>" + student.getStudierichting() + "</td>");
                out.println("</tr>");
            }
        %>
        </tbody>
    </table>
</body>
</html>
