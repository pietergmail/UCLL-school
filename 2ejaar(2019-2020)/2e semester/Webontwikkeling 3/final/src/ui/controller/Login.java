package ui.controller;

import domain.db.PersonDbInMemory;
import domain.model.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class Login extends RequestHandler{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NoSuchAlgorithmException {
        List<Person> personList = service.getPersons();
        Person person = null;
        for (Person p: personList) {
            if(p.getUserid().equals(request.getParameter("id"))){
                person = p;
            }
        }
        if (person == null){
            request.setAttribute("error", "no matchig name/password");
        }else if(person.isCorrectPasswordHashed(request.getParameter("password"))){
            request.getSession().setAttribute("person", person);
        }else{
            request.setAttribute("error", "wrong password");
        }
        return "index.jsp";
    }
}
