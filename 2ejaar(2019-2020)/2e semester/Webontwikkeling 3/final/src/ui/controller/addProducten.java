package ui.controller;

import domain.model.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class addProducten extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Person person = (Person) request.getSession().getAttribute("person");
        try {
            if (person.getRole().equals("Admin")) {
                return "addProduct.jsp";
            } else {
                return "Controller?command=producten";
            }
        }catch (Exception e){
            return "Controller?command=producten";
        }
    }
}
