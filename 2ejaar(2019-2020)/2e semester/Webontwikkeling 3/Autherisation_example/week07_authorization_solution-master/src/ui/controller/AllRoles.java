package ui.controller;

import domain.model.Role;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AllRoles extends RequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws NotAuthorizedException, ServletException, IOException {
        Role[] roles = { Role.ADMIN, Role.CUSTOMER };
        Utility.checkRole(request, roles);
        request.getRequestDispatcher("allRoles.jsp").forward(request,response);

    }
}
