<%@ page import="java.util.ArrayList" %>
<%@ page import="domain.Student" %>
<%
    Student greetje = new Student("Jongen", "Greetje", "Toegepaste Informatica", 23);
    Student kristien = new Student("Melaerts", "Kristien", "Chemie", 21);
    Student elke = new Student("Steegmans", "Elke", "Vroedkunde", 16);
    Student jan = new Student("Van Hee", "Jan", "Verpleegkunde", 18);
    Student Dennis = new Student("Winnepenincskx", "Dennis", "rondhangen en betaald worden", 18);

    ArrayList<Student> students = new ArrayList<Student>();
    students.add(greetje);
    students.add(kristien);
    students.add(elke);
    students.add(jan);
    students.add(Dennis);

%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
        for(Student student : students){
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
