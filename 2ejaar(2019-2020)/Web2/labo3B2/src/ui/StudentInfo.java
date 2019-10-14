package ui;

import domain.Student;
import domain.StudentDB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/StudentInfo")
public class StudentInfo extends HttpServlet {
    StudentDB studentenDB = new StudentDB();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(request.getParameter("naam").trim().isEmpty() || request.getParameter("leeftijd").trim().isEmpty() ||
        request.getParameter("richting").trim().isEmpty() || request.getParameter("voornaam").trim().isEmpty()){

            RequestDispatcher view = request.getRequestDispatcher("studentForm.jsp"); //
            view.forward(request, response);
        }else{
            studentenDB.addStudent(new Student(request.getParameter("naam"), request.getParameter("voornaam"),
                    request.getParameter("richting"), Integer.parseInt(request.getParameter("leeftijd"))));

            request.setAttribute("db", studentenDB.getStudents());
            RequestDispatcher view = request.getRequestDispatcher("studentInfoOverzicht.jsp"); //
            view.forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("naam") == null){
            request.setAttribute("db", studentenDB.getStudents());
            RequestDispatcher view = request.getRequestDispatcher("studentInfoOverzicht.jsp"); //
            view.forward(request, response);
        }
        String naam = request.getParameter("naam");
        String voornaam = request.getParameter("voornaam");

        for (Student x : studentenDB.getStudents()){
            if(x.getNaam().equalsIgnoreCase(naam) && x.getVoornaam().equalsIgnoreCase(voornaam)){
                String result = x.getNaam() + " " + x.getVoornaam() + " (" + Integer.toString(x.getLeeftijd()) + " jaar): " + x.getStudierichting();

                request.setAttribute("result", result);
                request.setAttribute("db", studentenDB.getStudents());
                RequestDispatcher view = request.getRequestDispatcher("gevonden.jsp"); //
                view.forward(request, response);
            }
        }
            RequestDispatcher view = request.getRequestDispatcher("nietgevonden.jsp"); //
            view.forward(request, response);

    }
}
