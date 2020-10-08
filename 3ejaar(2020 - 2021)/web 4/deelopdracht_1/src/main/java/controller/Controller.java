package controller;
import db.PersonRepositoryStub;
import domain.Person;

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
        ArrayList<Person> persons = new ArrayList<>();
        persons = personRepository.getAll();
        response.setContentType("application/json");
        response.getWriter().write(String.valueOf(persons));
    }
}
