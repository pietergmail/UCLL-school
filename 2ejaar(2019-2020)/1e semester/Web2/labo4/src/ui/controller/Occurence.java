package ui.controller;

import domain.model.LetterCounter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Occurence")
public class Occurence extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String woord = request.getParameter("woord");
       String letter = request.getParameter("letter");

        LetterCounter dwoord = new LetterCounter(woord);
        int total = dwoord.aantal(letter);

       request.setAttribute("result", total);
       RequestDispatcher view = request.getRequestDispatcher("result.jsp");
       view.forward(request, response);
    }
}
