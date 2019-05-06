package ui.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Controller")
public class Controller extends HttpServlet {

    public Controller() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String command = "home";
        if (request.getParameter("command") != null) {
            command = request.getParameter("command");
        }
        String destination;
        switch(command) {
            case "home" :
                destination = home(request, response);
                break;
            case "more" :
                destination = more(request, response);
                break;
            default :
                destination = home(request, response);
        }
        request.getRequestDispatcher(destination).forward(request, response);
    }

    private String home (HttpServletRequest request, HttpServletResponse response) {
        String answer = request.getParameter("quote");
        if ("yes".equals(answer)) {
            request.setAttribute(answer, "Even a dead fish can go with the flow");
            return "index.jsp";
        } else{
            return "index.jsp";
        }
    }

    private String more (HttpServletRequest request, HttpServletResponse response) {
        return "more.jsp";
    }
}

