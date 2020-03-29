package ui.controller;

import domain.model.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public class checkPasswordSubmit extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        String password = request.getParameter("password");

        Person p = service.getPerson(id);
        boolean awnser = false;
        try {
            System.out.println(p.getPassword());
            System.out.println(password);
            awnser = p.isCorrectPasswordHashed(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        request.setAttribute("awnser", awnser);

        response.sendRedirect("Controller?action=overview");
        return null;
    }
}
