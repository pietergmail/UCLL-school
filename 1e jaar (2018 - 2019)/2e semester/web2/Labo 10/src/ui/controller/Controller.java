package ui.controller;

import domain.db.DbException;
import domain.db.ProductDbInMemory;
import domain.model.DomainException;
import domain.model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
    // something missing
    private ProductDbInMemory ProductDB = new ProductDbInMemory();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 	// to be completed
        String command = "home";
        if (request.getParameter("command") != null){
            command = request.getParameter("command");
        }
        String destination;
        switch (command) {

            case "DeleteConfirmation":
                destination = DeleteConfirmation(request, response);
                break;
            case "overview":
                destination = showOverview(request, response);
                break;
            case "add":
                destination = showAdd(request, response);
                break;

            case "addProduct":
                destination = showAddProduct(request, response);
                break;
            case  "Delete":
                destination = delete(request, response);
                break;
            case "shop":
                destination = shop(request, response);
                break;
            case "addCart":
                destination = addcart(request, response);
                break;
            default:
                destination = showHome(request, response);
                break;
        }
        request.getRequestDispatcher(destination).forward(request, response);

    }

    private String showHome(HttpServletRequest request, HttpServletResponse response) {
        return "index.jsp";
    }

    private String shop(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<Product> userdb = (ArrayList<Product>)request.getSession().getAttribute("user");
        request.getSession().setAttribute("user", userdb);
        return "shop.jsp";
    }

    private String addcart(HttpServletRequest request, HttpServletResponse response){
        ArrayList<Product> userdb = (ArrayList<Product>)request.getSession().getAttribute("user");
        if(userdb == null){
            userdb = new ArrayList<Product>();
        }
        int id = Integer.parseInt(request.getParameter("id"));
        userdb.add(ProductDB.get(id));

        request.getSession().setAttribute("user", userdb);
        return showOverview(request, response);
    }



    private String showAddProduct(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<String> errors = new ArrayList<String>();

        Product product = new Product();
        setName(product, request, errors);
        setDescription(product, request, errors);
        setPrice(product, request, errors);

        if (errors.size() == 0) {
            try {
                ProductDB.add(product);
                return showOverview(request, response);
            } catch (DbException exc) {
                request.setAttribute("error", exc.getMessage());
                return "addProduct.jsp";
            }
        } else {
            request.setAttribute("errors", errors);
            return "addProduct.jsp";
        }
    }

    private void setPrice(Product product, HttpServletRequest request, ArrayList<String> errors) {
        String price = request.getParameter("price");
        try {
            product.setPrice(price);
            request.setAttribute("Class", "has-success");
            request.setAttribute("pricePreviousValue", price);
        } catch (DomainException exc) {
            errors.add(exc.getMessage());
            request.setAttribute("priceClass", "has-error");
        }
    }

    private void setDescription(Product product, HttpServletRequest request, ArrayList<String> errors) {
        String description = request.getParameter("description");
        try {
            product.setDescription(description);
            request.setAttribute("Class", "has-success");
            request.setAttribute("descriptionPreviousValue", description);
        } catch (DomainException exc) {
            errors.add(exc.getMessage());
            request.setAttribute("descriptionClass", "has-error");
        }

    }

    private void setName(Product product, HttpServletRequest request, ArrayList<String> errors) {
        String name = request.getParameter("name");
        try {
            product.setName(name);
            request.setAttribute("naamClass", "has-success");
            request.setAttribute("naamPreviousValue", name);
        } catch (DomainException exc) {
            errors.add(exc.getMessage());
            request.setAttribute("naamClass", "has-error");
        }

    }

    private String showOverview(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("products", ProductDB.getAll());
        return  "productOverview.jsp";
    }

    private String showAdd(HttpServletRequest request, HttpServletResponse response) {
        return "addProduct.jsp";
    }

    private String DeleteConfirmation(HttpServletRequest request, HttpServletResponse response){
        String name = request.getParameter("name");
        String id = request.getParameter("id");
        request.setAttribute("name", name);
        request.setAttribute("id", id);
        return "DeleteConfirmation.jsp";
    }

    private String delete(HttpServletRequest request, HttpServletResponse response){
        ArrayList<Product> userdb = (ArrayList<Product>)request.getSession().getAttribute("user");
        int id2 = Integer.parseInt(request.getParameter("id")) - 1;
        int index = 0;
        if(request.getParameter("delete").equals("yes")){
            System.out.println("delete");
            for(Product p : userdb){
                if(p.getProductId() == id2){
                    index = p.getProductId();
                }
            }
            userdb.remove(index);
        }
        return showOverview(request, response);
    }
}
