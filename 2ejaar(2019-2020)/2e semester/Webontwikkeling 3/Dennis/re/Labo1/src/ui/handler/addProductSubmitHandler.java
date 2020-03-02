package ui.handler;

import domain.model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

public class addProductSubmitHandler extends RequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) {
        addProductSubmit(request,response);
    }
    protected void addProductSubmit(HttpServletRequest request, HttpServletResponse response) {
        Product p = new Product();
        ArrayList<String> errors = new ArrayList<>();
        UUID id = UUID.randomUUID();
        p.setProductId(id + "");
        setProductDescription(request, p, errors);
        setProductName(request, p, errors);
        setProductPrice(request, p, errors);

        if (errors.size() > 0) {
            request.setAttribute("errors", errors);
            RequestHandler handler = new addProductenHandler();
            handler.setService(getService());
            handler.handleRequest(request, response);

        } else {
            service.addProduct(p);
            RequestHandler handler = new productenHandler();
            handler.setService(getService());
            handler.handleRequest(request, response);
        }
    }

    protected void setProductName(HttpServletRequest request, Product p, ArrayList errors) {
        String name = request.getParameter("name");
        try {
            p.setName(name);
            request.setAttribute("prevName", name);
        } catch (Exception e) {
            errors.add(e.getMessage());
        }
    }

    protected void setProductDescription(HttpServletRequest request, Product p, ArrayList errors) {
        String description = request.getParameter("description");
        try {
            p.setDescription(description);
            request.setAttribute("prevDescription", description);
        } catch (Exception e) {
            errors.add(e.getMessage());
        }
    }

    protected void setProductPrice(HttpServletRequest request, Product p, ArrayList errors) {
        String price = request.getParameter("price");
        try {
            p.setPrice(price);
            request.setAttribute("prevPrice", price);
        } catch (Exception e) {
            errors.add(e.getMessage());
        }
    }
}
