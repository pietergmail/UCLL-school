package ui.controller;

import domain.model.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class editProductSubmit extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Product p = null;
        for (Product p2 : service.getProducts()) {
            if (p2.getProductId().equals(request.getParameter("id"))) {
                p = p2;
            }
        }
        assert p != null;
        p.setPrice(request.getParameter("price"));
        p.setDescription(request.getParameter("desc"));
        p.setName(request.getParameter("name"));
        service.updatePruduct(p);
        return "Controller?command=producten";
    }
}
