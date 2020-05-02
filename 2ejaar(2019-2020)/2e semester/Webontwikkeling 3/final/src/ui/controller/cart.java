package ui.controller;

import domain.model.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class cart extends RequestHandler{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Product> cart = (ArrayList<Product>) request.getSession().getAttribute("cart");
        request.setAttribute("cart", cart);
        return "cart.jsp";
    }
}
