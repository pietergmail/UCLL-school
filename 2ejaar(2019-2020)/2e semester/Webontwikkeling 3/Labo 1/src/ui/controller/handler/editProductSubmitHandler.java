package ui.handler;

import domain.model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class editProductSubmitHandler extends RequestHandler{
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) {
        Product p = null;
        for (Product p2 : service.getProducts()) {
            if (p2.getProductId().equals(request.getParameter("id"))) {
                p = p2;
            }
        }
        p.setPrice(request.getParameter("price"));
        p.setDescription(request.getParameter("desc"));
        p.setName(request.getParameter("name"));
        service.updatePruduct(p);
        RequestHandler handler = new productenHandler();
        handler.setService(getService());
        handler.handleRequest(request, response);

    }
}
