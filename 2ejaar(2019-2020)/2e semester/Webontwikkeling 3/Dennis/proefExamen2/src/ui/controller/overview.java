package ui.controller;

import domain.model.ProductService;
import domain.model.Role;
import domain.model.Utility;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class overview extends RequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NotAuthorizedException {

        Utility.checkRole(request, new Role[]{Role.ADMIN, Role.CUSTOMER});
        ProductService service = getProductService();
        request.setAttribute("products", service.getAll());
        request.getRequestDispatcher("products.jsp").forward(request, response);
    }
}
