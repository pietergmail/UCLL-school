package ui;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.ArrayList;

import domain.*;

@WebServlet("/Servlet")
public class Servlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        PersoonDB personen = new PersoonDB();

        ArrayList<Persoon> personenArray = personen.getPersonen();
        request.setAttribute("personen", personenArray);

        RequestDispatcher view = request.getRequestDispatcher("ingeschreven.jsp");
        view.forward(request, response);
    }
}
