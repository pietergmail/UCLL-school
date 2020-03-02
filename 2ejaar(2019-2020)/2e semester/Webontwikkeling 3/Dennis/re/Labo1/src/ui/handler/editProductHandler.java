package ui.handler;

import domain.model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class editProductHandler extends RequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Product p = null;
        for (Product p2 : service.getProducts()) {
            if (p2.getProductId().equals(id)) {
                p = p2;
            }
        }
        request.setAttribute("Product", p);
        try {
            RequestDispatcher view = request.getRequestDispatcher("editProduct.jsp");
            view.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
