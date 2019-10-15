package ui;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.ArrayList;

import domain.*;

@WebServlet("/Servlet")
public class Servlet extends javax.servlet.http.HttpServlet {
    private PersoonDB personen = new PersoonDB();
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        if(request.getParameter("naam").trim().isEmpty() || request.getParameter("age").trim().isEmpty()||
            request.getParameter("instrument").trim().isEmpty()){
            RequestDispatcher view = request.getRequestDispatcher("ingeschreven.jsp");
            view.forward(request, response);
        }else{
            int age = Integer.parseInt(request.getParameter("age"));
            personen.add(new Persoon(request.getParameter("naam"), age, request.getParameter("instrument")));
            RequestDispatcher view = request.getRequestDispatcher("ingeschreven.jsp");
            view.forward(request, response);
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setAttribute("db", personen.getPersonen());
        RequestDispatcher view = request.getRequestDispatcher("ingeschreven.jsp");
        view.forward(request, response);
    }
}
