package ui.controller;

import domain.model.Person;
import domain.model.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

public class addtocart extends RequestHandler{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ArrayList<Product> cart;
        if (session.getAttribute("cart") == null){
            cart = new ArrayList<>();
        }else{
            cart = (ArrayList<Product>) session.getAttribute("cart");
        }

        for (Product p: service.getProducts()) {
            if(p.getProductId().equals(request.getParameter("id"))){
                cart.add(p);
                request.getSession().setAttribute("cart", cart);
                session.setMaxInactiveInterval(3600);
                break;
            }
        }
        return "Controller?command=producten";
    }
}
