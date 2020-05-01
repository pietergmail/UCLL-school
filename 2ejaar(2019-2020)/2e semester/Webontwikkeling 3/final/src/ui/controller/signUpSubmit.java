package ui.controller;

import domain.model.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class signUpSubmit extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Person p = new Person();
        /* UUID uuid = UUID.randomUUID();*/
        ArrayList<String> errors = new ArrayList<>();
        setId(request, p, errors);
        setFirstName(request, p, errors);
        setLastName(request, p, errors);
        setEmail(request, p, errors);
        setPassword(request, p, errors);
        try {
            service.addPerson(p);
        } catch (Exception e) {
            errors.add(e.getMessage());
        }
        if (errors.size() > 0) {
            request.setAttribute("errors", errors);
            return "signUp.jsp";
        } else {
            return "Controller?command=overview";
        }

    }

    protected void setId(HttpServletRequest request, Person p, ArrayList<String> errors) {
        String id = request.getParameter("userid");
        try {
            p.setUserid(id);
            request.setAttribute("prevId", id);
        } catch (Exception e) {
            errors.add(e.getMessage());
        }
    }

    protected void setFirstName(HttpServletRequest request, Person p, ArrayList<String> errors) {
        String firstName = request.getParameter("firstName");
        try {
            p.setFirstName(firstName);
            request.setAttribute("prevFirstName", firstName);
        } catch (Exception e) {
            errors.add(e.getMessage());
        }
    }

    protected void setLastName(HttpServletRequest request, Person p, ArrayList<String> errors) {
        String lastName = request.getParameter("lastName");
        try {
            p.setLastName(lastName);
            request.setAttribute("prevLastName", lastName);
        } catch (Exception e) {
            errors.add(e.getMessage());
        }
    }

    protected void setEmail(HttpServletRequest request, Person p, ArrayList<String> errors) {
        String email = request.getParameter("email");
        try {
            p.setEmail(email);
            request.setAttribute("prevEmail", email);
        } catch (Exception e) {
            errors.add(e.getMessage());
        }
    }

    protected void setPassword(HttpServletRequest request, Person p, ArrayList<String> errors) {
        String password = request.getParameter("password");
        try {
            p.setPasswordHashed(password);
            request.setAttribute("prevPassword", password);
        } catch (Exception e) {
            errors.add(e.getMessage());
        }
    }
}
