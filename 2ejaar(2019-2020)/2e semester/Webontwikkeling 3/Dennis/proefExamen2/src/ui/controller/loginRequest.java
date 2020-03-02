package ui.controller;

import domain.model.Role;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class loginRequest extends RequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String role = request.getParameter("role");
        Role EnumRole = null;
        if (role.equals("admin")){
            EnumRole = Role.ADMIN;
        }else{
            EnumRole = Role.CUSTOMER;
        }
        request.getSession().setAttribute("user", EnumRole);
        request.setAttribute("userRole", EnumRole.name());
        request.setAttribute("username", EnumRole.getStringValue());
        request.getRequestDispatcher("index.jsp").forward(request,response);

    }
}
