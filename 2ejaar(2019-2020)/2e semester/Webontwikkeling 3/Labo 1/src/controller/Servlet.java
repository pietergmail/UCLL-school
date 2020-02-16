package controller;

import domain.db.PersonDbInMemory;
import domain.model.DomainException;
import domain.model.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    PersonDbInMemory personen = new PersonDbInMemory();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processrequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processrequest(request, response);
    }

    protected void processrequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String command = "";
        if (request.getParameter("command") != null){
            command = request.getParameter("command");
        }

        String destination;
        switch (command) {
            case "home":
                destination = home(request, response);
                break;
            case "overview":
                destination = overview(request, response);
                break;
            case "signUp":
                destination = signUp(request, response);
                break;
            case "addPerson":
                destination = addPerson(request, response);
                break;
            default:
                destination = home(request, response);
        }
        request.getRequestDispatcher(destination).forward(request, response);
    }

    private String addPerson(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<String> errors = new ArrayList<>();

        Person person = new Person();
        SetId(person, request, response, errors);
        SetEmail(person, request, response, errors);
        setVoornaam(person, request, response, errors);
        SetAchternaam(person, request, response, errors);
        setPassword(person, request, response, errors);

        if (errors.size() == 0){
            personen.add(person);
            return overview(request, response);
        }else{
            request.setAttribute("errors", errors);
            return "bikeAdd.jsp";
        }
    }

    private void setPassword(Person person, HttpServletRequest request, HttpServletResponse response, ArrayList<String> errors) {
        try{
            person.setEmail(request.getParameter("password"));
            request.setAttribute("prevpassword", request.getParameter("password"));
        }catch (DomainException e){
            errors.add(e.getMessage());
        }
    }

    private void SetAchternaam(Person person, HttpServletRequest request, HttpServletResponse response, ArrayList<String> errors) {
        try{
            person.setEmail(request.getParameter("lastName"));
            request.setAttribute("prevlastName", request.getParameter("lastName"));
        }catch (DomainException e){
            errors.add(e.getMessage());
        }
    }

    private void setVoornaam(Person person, HttpServletRequest request, HttpServletResponse response, ArrayList<String> errors) {
        try{
            person.setEmail(request.getParameter("firstName"));
            request.setAttribute("prevfirstName", request.getParameter("firstName"));
        }catch (DomainException e){
            errors.add(e.getMessage());
        }
    }

    private void SetId(Person person, HttpServletRequest request, HttpServletResponse response, ArrayList<String> errors) {
        try{
            if(personen.get(request.getParameter("userid")) != null) throw new DomainException("Persoon zit al in de database");
                person.setUserid(request.getParameter("userid"));
                request.setAttribute("previd", request.getParameter("userid"));
        }catch(DomainException e){
                errors.add(e.getMessage());
        }
    }

    private void SetEmail(Person person, HttpServletRequest request, HttpServletResponse response, ArrayList<String> errors) {
        try{
            person.setEmail(request.getParameter("email"));
            request.setAttribute("prevemail", request.getParameter("email"));
        }catch (DomainException e){
            errors.add(e.getMessage());
        }
    }

    private String signUp(HttpServletRequest request, HttpServletResponse response) {
        return "signUp.jsp";
    }

    private String overview(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("personen", personen.getAll());
        return "personoverview.jsp";
    }

    public String home(HttpServletRequest request, HttpServletResponse response){
        return "index.jsp";
    }
}
