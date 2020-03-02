package ui.controller;

import domain.model.Role;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Login extends RequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String role = request.getParameter("role");
        Role roleEnum = Role.valueOf(role.toUpperCase());
        request.getSession().setAttribute("user", roleEnum);

        response.sendRedirect("Controller?action=Home");
    }
}
