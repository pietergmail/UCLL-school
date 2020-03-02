package ui.controller;

import domain.model.Person;
import domain.model.Product;
import domain.model.ShopService;
import org.openqa.selenium.remote.server.Session;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.*;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
    ShopService service;

    @Override
    public void init() throws ServletException {
        super.init();
        ServletContext context = getServletContext();
        Properties properties = new Properties();
        properties.setProperty("user", context.getInitParameter("user"));
        properties.setProperty("password", context.getInitParameter("password"));
        properties.setProperty("ssl", context.getInitParameter("ssl"));
        properties.setProperty("sslfactory", context.getInitParameter("sslfactory"));
        properties.setProperty("sslmode", context.getInitParameter("sslmode"));
        properties.setProperty("url", context.getInitParameter("url"));
        service = new ShopService(properties);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String command = request.getParameter("command");
        if (command == null) {
            command = "home";
        }
        String destination = "";


        HttpSession session = request.getSession();
        TreeMap<LocalTime, String> Tmap;
        if (session.getAttribute("pages") == null) {
            Tmap = new TreeMap<LocalTime, String>();
        } else {
            Tmap = (TreeMap<LocalTime, String>) session.getAttribute("pages");
        }
        Tmap.put(LocalTime.now(), command);
        session.setAttribute("pages", Tmap);

        switch (command) {
            case "home":
                destination = home(request, response);
                break;
            case "overview":
                destination = overview(request, response);
                break;
            case "signUp":
                destination = signUp(request, response);
                break;
            case "signUpSubmit":
                destination = signUpSubmit(request, response);
                break;
            case "changeTeam":
                destination = changeTeam(request, response);
                break;
            case "activiteiten":
                destination = activiteiten(request, response);
                break;
            case "producten":
                destination = producten(request, response);
                break;
            case "addProducten":
                destination = addProducten(request, response);
                break;
            case "addProductSubmit":
                destination = addProductSubmit(request, response);
                break;
            case "editProduct":
                destination = editProduct(request, response);
                break;
            case "editProductSubmit":
                destination = editProductSubmit(request, response);
                break;
            case "DeleteSubmit":
                destination = DeleteSubmit(request, response);
                break;
            case "DeletePersonSubmit":
                destination = DeletePersonSubmit(request, response);
                break;
            case "checkPasswordSubmit":
                destination = checkPasswordSubmit(request, response);
                break;
            default:
                destination = home(request, response);
        }


        request.getRequestDispatcher(destination).forward(request, response);
    }

    protected String home(HttpServletRequest request, HttpServletResponse response) {
        return "index.jsp";
    }

    protected String overview(HttpServletRequest request, HttpServletResponse response) {

        request.setAttribute("personen", service.getPersons());
        return "personoverview.jsp";
    }

    protected String signUp(HttpServletRequest request, HttpServletResponse response) {
        return "signUp.jsp";
    }

    protected String signUpSubmit(HttpServletRequest request, HttpServletResponse response) {
        Person p = new Person();
        /* UUID uuid = UUID.randomUUID();*/
        ArrayList<String> errors = new ArrayList<>();
        setId(request, p, errors);
        setFirstName(request, p, errors);
        setLastName(request, p, errors);
        setEmail(request, p, errors);
        setPassword(request, p, errors);
        try {
            service.addPerson(p);
        } catch (Exception e) {
            errors.add(e.getMessage());
        }
        if (errors.size() > 0) {
            request.setAttribute("errors", errors);
            return "signUp.jsp";
        } else {
            return overview(request, response);
        }
    }

    protected void setId(HttpServletRequest request, Person p, ArrayList<String> errors) {
        String id = request.getParameter("userid");
        try {
            p.setUserid(id);
            request.setAttribute("prevId", id);
        } catch (Exception e) {
            errors.add(e.getMessage());
        }
    }

    protected void setFirstName(HttpServletRequest request, Person p, ArrayList<String> errors) {
        String firstName = request.getParameter("firstName");
        try {
            p.setFirstName(firstName);
            request.setAttribute("prevFirstName", firstName);
        } catch (Exception e) {
            errors.add(e.getMessage());
        }
    }

    protected void setLastName(HttpServletRequest request, Person p, ArrayList<String> errors) {
        String lastName = request.getParameter("lastName");
        try {
            p.setLastName(lastName);
            request.setAttribute("prevLastName", lastName);
        } catch (Exception e) {
            errors.add(e.getMessage());
        }
    }

    protected void setEmail(HttpServletRequest request, Person p, ArrayList<String> errors) {
        String email = request.getParameter("email");
        try {
            p.setEmail(email);
            request.setAttribute("prevEmail", email);
        } catch (Exception e) {
            errors.add(e.getMessage());
        }
    }

    protected void setPassword(HttpServletRequest request, Person p, ArrayList<String> errors) {
        String password = request.getParameter("password");
        try {
            p.setPasswordHashed(password);
            request.setAttribute("prevPassword", password);
        } catch (Exception e) {
            errors.add(e.getMessage());
        }
    }

    protected String changeTeam(HttpServletRequest request, HttpServletResponse response) {
        Cookie c = findCookie(request.getCookies(), "IndexPicture");
        if (c == null) {
            c = new Cookie("IndexPicture", "yes");
        } else {
            if (c.getValue().equals("yes")) {
                c.setValue("no");
            } else {
                c.setValue("yes");
            }
        }
        request.setAttribute("IndexPicture", c.getValue());
        response.addCookie(c);
        return home(request, response);
    }

    protected Cookie findCookie(Cookie[] cookies, String key) {
        for (Cookie c : cookies) {
            if (c.getName().equals(key)) {
                return c;
            }
        }
        return null;
    }

    protected String activiteiten(HttpServletRequest request, HttpServletResponse response) {

        TreeMap<LocalTime, String> Tmap = (TreeMap<LocalTime, String>) request.getSession().getAttribute("pages");

        request.setAttribute("activities", Tmap);

        return "activiteiten.jsp";
    }

    protected String producten(HttpServletRequest request, HttpServletResponse response) {

        request.setAttribute("producten", service.getProducts());
        return "productenoverview.jsp";
    }

    protected String addProducten(HttpServletRequest request, HttpServletResponse response) {

        return "addProduct.jsp";
    }

    protected String addProductSubmit(HttpServletRequest request, HttpServletResponse response) {
        Product p = new Product();
        ArrayList<String> errors = new ArrayList<>();
        UUID id = UUID.randomUUID();
        p.setProductId(id + "");
        setProductDescription(request, p, errors);
        setProductName(request, p, errors);
        setProductPrice(request, p, errors);

        if (errors.size() > 0) {
            request.setAttribute("errors", errors);
            return "addProduct.jsp";
        } else {
            service.addProduct(p);
            return producten(request, response);
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

    protected String editProduct(HttpServletRequest request, HttpServletResponse response) {
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

    protected String editProductSubmit(HttpServletRequest request, HttpServletResponse response) {
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
        return producten(request, response);

    }

    protected String DeleteSubmit(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");

        service.deleteProduct(id);
        return producten(request, response);
    }

    protected String DeletePersonSubmit(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");

        service.deletePerson(id);
        return overview(request, response);
    }

    protected String checkPasswordSubmit(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String password = request.getParameter("password");

        Person p = service.getPerson(id);
        boolean awnser = false;
        try {
            System.out.println(p.getPassword());
            System.out.println(password);
            awnser = p.isCorrectPasswordHashed(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        request.setAttribute("awnser", awnser);

        return overview(request, response);
    }
}
