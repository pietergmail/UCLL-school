package ui.controller;

import domain.db.MemberDB;
import domain.model.Member;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private MemberDB db = new MemberDB();

    public Controller(){super();}

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
            case "overview":
                destination = overview(request, response);
                break;
            case "deleteConfirmation" :
                destination = "deleteConfirmation.jsp";
                break;

            default :
                destination = home(request, response);
        }
        request.getRequestDispatcher(destination).forward(request, response);
    }

    private String home (HttpServletRequest request, HttpServletResponse response){
        Member oldest = db.Oldest();
        request.setAttribute("oudste", oldest);
        return "index.jsp";
    }

    private String overview(HttpServletRequest request, HttpServletResponse response){
        request.setAttribute("members", db.getAll());
        return "overzicht_ingeschreven.jsp";
    }
}
