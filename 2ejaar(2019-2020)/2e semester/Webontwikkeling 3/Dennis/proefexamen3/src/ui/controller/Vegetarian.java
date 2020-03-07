package ui.controller;

import domain.model.Role;
import domain.model.Utility;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Vegetarian extends RequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("products", getProductService().allVegetarianProducts());
        Role[] roles = new Role[]{Role.ADMIN};
        Utility.checkRole(roles, (Role) request.getSession().getAttribute("user"));

        request.getRequestDispatcher("vegetarianProducts.jsp").forward(request,response);
    }
}