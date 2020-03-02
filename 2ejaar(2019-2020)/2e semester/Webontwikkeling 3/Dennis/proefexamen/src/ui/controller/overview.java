package ui.controller;

import domain.model.ProductService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class overview extends RequestHandler{
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductService service = getProductService();
        request.setAttribute("products", service.getAll());
        request.getRequestDispatcher("products.jsp").forward(request,response);
    }
}
