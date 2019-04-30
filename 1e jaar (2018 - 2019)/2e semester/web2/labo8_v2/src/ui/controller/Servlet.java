package ui.controller;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/Servlet")
public class Servlet extends javax.servlet.http.HttpServlet {
    private static final Object ServletException = ;

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
