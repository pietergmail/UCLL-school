package ui.controller;

import domain.DB.StudentDB;
import domain.model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/StudentInfo")
public class StudentInfo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Student greetje = new Student("Jongen", "Greetje", "Toegepaste Informatica", 23);
        Student kristien = new Student("Melaerts", "Kristien", "Chemie", 21);
        Student elke = new Student("Steegmans", "Elke", "Vroedkunde", 16);
        Student jan = new Student("Van Hee", "Jan", "Verpleegkunde", 18);

        StudentDB lijst = new StudentDB();

        lijst.voegStudentToe(greetje);
        lijst.voegStudentToe(kristien);
        lijst.voegStudentToe(elke);
        lijst.voegStudentToe(jan);


        String pNaam = request.getParameter("naam");
        String pVoornaam = request.getParameter("voornaam");


        String result = "";
        String niet =  "Helaas, de student waarnaar je vraagt is niet gevonden.";

        if (lijst.bestaandeStudent(pNaam, pVoornaam)){


           result = "Je vroeg naar volgende gegevens: " + pNaam + " " +pVoornaam
                   + " (" + lijst.getStudent(pNaam, pVoornaam).getLeeftijd() + " jaar): "
                   + lijst.getStudent(pNaam, pVoornaam).getStudierichting();

            request.setAttribute("antwoord", result);

            RequestDispatcher view = request.getRequestDispatcher("gevonden.jsp");
            view.forward(request, response);
        }
        else{

            request.setAttribute("niet", niet);

            RequestDispatcher view = request.getRequestDispatcher("nietGevonden.jsp");
            view.forward(request, response);
        }


    }
}
