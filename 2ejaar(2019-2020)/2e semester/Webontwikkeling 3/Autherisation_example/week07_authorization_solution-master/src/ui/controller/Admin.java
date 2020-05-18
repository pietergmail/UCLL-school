package ui.controller;

import domain.model.Role;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Admin extends RequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws NotAuthorizedException, ServletException, IOException {
        Role[] roles = {Role.ADMIN};
        Utility.checkRole(request, roles);
        request.getRequestDispatcher("admin.jsp").forward(request, response);
    }
}
