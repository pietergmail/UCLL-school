package src.ui.controller;

import domain.db.MemberDB;
import domain.model.Member;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
            case "add" :
                destination = add(request, response);
                break;
            case "delete" :
                destination = delete(request, response);
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

    private String add (HttpServletRequest request, HttpServletResponse response){
        String voornaam = request.getParameter("voornaam");
        String achternaam = request.getParameter("achternaam");
        String adres = request.getParameter("adres");
        String email = request.getParameter("email");
        String geboortedatum = request.getParameter("geboortedatum");
        if(!voornaam.isEmpty() && !achternaam.isEmpty() && !adres.isEmpty()){
            Member member = new Member(voornaam, achternaam, adres, email, geboortedatum);
            db.voegtoe(member);
            return overview(request, response);
        }
        else {
            return "inschrijven.jsp";
        }
    }

    private String delete(HttpServletRequest request, HttpServletResponse response){
        String naam = request.getParameter("naam");
        db.verwijder(naam);
        return overview(request, response);
    }

    private String overview(HttpServletRequest request, HttpServletResponse response){
        request.setAttribute("members", db.getAll());
        return "overzicht_ingeschreven.jsp";
    }
}
