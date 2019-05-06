package ui.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Occurences")
public class Occurence extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String woord = request.getParameter("woord");  // = papa
        String letter = request.getParameter("letter");// = a

        int total = 0;

        for (int i = 0; i < woord.length(); i++){
            if(woord.charAt(i) == letter.charAt(0) ){
                total++;
            }
        }

        request.setAttribute("result", total);   // localhost:8080/result.jsp?result=total
        RequestDispatcher view = request.getRequestDispatcher("result.jsp"); //
        view.forward(request, response);

    }
}
