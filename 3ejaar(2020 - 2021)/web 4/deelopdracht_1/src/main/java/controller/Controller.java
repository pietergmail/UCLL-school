package main.java.controller;
import main.java.domain.Person;
import main.java.db.PersonRepositoryStub;

import javax.jws.WebService;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

@WebServlet("/Controller")
public class Controller extends HttpServlet {

    private PersonRepositoryStub personRepository;

    public Controller(){
        super();
        personRepository = new PersonRepositoryStub();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ProcessRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        ProcessRequest(request, response);
    }

    protected void ProcessRequest(HttpServletRequest request, HttpServletResponse response){
        String command = "";
        if (request.getParameter("command") != null){
            command = request.getParameter("command");
        }
        switch (command){
            case "getpersons":
                getPersons(request, response);
                break;
            case "addperson":
                addPerson(request, response);
                break;
        }
    }

    private void getPersons(HttpServletRequest request, HttpServletResponse response){
        String persons;
        persons = personRepository.toJson();
        response.setContentType("application/json");
        try {
            response.getWriter().write(String.valueOf(persons));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addPerson(HttpServletRequest request, HttpServletResponse response){
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String email = request.getParameter("email");
        String GSM = request.getParameter("GSM");
        String date = request.getParameter("date");
        String room = request.getParameter("room");
        Person person = new Person(email, fname, lname, date, room, GSM);
        try {
            personRepository.add(person);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
