package ui.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Controller")
public class Controller extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        String command = "home";
        if (request.getParameter("command") != null){
            command = request.getParameter("command");
        }
        String destination;
        switch(command){
            case "home":
                destination = home(request, response);
                break;
            case "more":
                destination = more(request, response);
                break;
            default:
                destination = home(request, response);
        }
        request.getRequestDispatcher(destination).forward(request, response);
    }

    private String home (HttpServletRequest request, HttpServletResponse response){
        return "index.jsp";
    }

    private String more (HttpServletRequest request, HttpServletResponse response){
        return "more.jsp";
    }
}
