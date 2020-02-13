package ui;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import domain.*;

@WebServlet("/Servlet")
public class Servlet extends javax.servlet.http.HttpServlet {
    private PersoonDB personen = new PersoonDB();
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
      processRequest(request, response);
    }

    private  void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String command = "home";
        if (request.getParameter("command") != null){
            command = request.getParameter("command");
        }
        String destination = "";
        switch (command){
            case "home":
                destination = home(request, response);
                break;
            case "overview":
                destination = overview(request, response);
                break;
            case "inschrijven":
                destination = inschrijven(request, response);
                break;
            case "add":
                destination = add(request, response);
                break;
            case "deleteform":
                destination = deleteform(request, response);
                break;
            case "delete":
                destination = delete(request, response);
                break;
            default:
                destination = home(request, response);
        }

        request.getRequestDispatcher(destination).forward(request, response);
    }
    private String home(HttpServletRequest request, HttpServletResponse response){
        return "index.jsp";
    }

    private String overview(HttpServletRequest request, HttpServletResponse response){
        request.setAttribute("db", personen.getPersonen());
        String oldest = personen.getoudste().getNaam();
        request.setAttribute("oldest", oldest);
        return "ingeschreven.jsp";
    }

    private String inschrijven(HttpServletRequest request, HttpServletResponse response){
        return "inschrijven.jsp";
    }

    private String add(HttpServletRequest request, HttpServletResponse response){
        if(request.getParameter("naam").trim().isEmpty() || request.getParameter("age").trim().isEmpty()||
                request.getParameter("instrument").trim().isEmpty()){
            return "index.jsp";
        }else{
            int age = Integer.parseInt(request.getParameter("age"));
            personen.add(new Persoon(request.getParameter("naam"), age, request.getParameter("instrument")));
            request.setAttribute("db", personen.getPersonen());
            String oldest = personen.getoudste().getNaam();
            request.setAttribute("oldest", oldest);
            return "ingeschreven.jsp";
        }
    }

    private String deleteform(HttpServletRequest request, HttpServletResponse response){
        String naam = request.getParameter("naam");
        request.setAttribute("naam", naam);
        return "delete.jsp";
    }

    private String delete(HttpServletRequest request, HttpServletResponse response){
        ArrayList<Persoon> userdb = (ArrayList<Persoon>)request.getSession().getAttribute("naam");
        String name = request.getParameter("naam");
        int index = 0;
        if(request.getParameter("delete").equals("yes")){
            for(Persoon p : userdb) {
                if (p.getNaam().equals(name)) {
                    index = userdb.indexOf(p);
                }
            }
            userdb.remove(index);
        }
        return overview(request, response);
    }
}
