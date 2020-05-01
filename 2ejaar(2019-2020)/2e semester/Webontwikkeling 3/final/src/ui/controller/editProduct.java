package ui.controller;

import domain.model.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class editProduct extends RequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Product p = null;
        for (Product p2 : service.getProducts()) {
            if (p2.getProductId().equals(id)) {
                p = p2;
            }
        }
        request.setAttribute("Product", p);
        return "editProduct.jsp";
    }
}
