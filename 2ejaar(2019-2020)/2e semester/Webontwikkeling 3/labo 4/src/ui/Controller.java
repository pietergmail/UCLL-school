package ui;

import domain.db.DbException;
import domain.db.PersonDbInMemory;
import domain.db.ProductDbInMemory;
import domain.model.Person;
import domain.model.Product;
import domain.service.ShopService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.SplittableRandom;

@WebServlet("/Controller")
public class Controller extends HttpServlet {

    private ShopService service;

    @Override
    public void init() throws ServletException{
        super.init();

        ServletContext context = getServletContext();

        Properties properties = new Properties();
        properties.setProperty("user", context.getInitParameter("user"));
        properties.setProperty("password", context.getInitParameter("password"));
        properties.setProperty("ssl", context.getInitParameter("ssl"));
        properties.setProperty("sslfactory", context.getInitParameter("sslfactory"));
        properties.setProperty("url", context.getInitParameter("url"));

        service = new ShopService(properties);
    }

    public Controller(){super();}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String command = "home";
        if (request.getParameter("command") != null){
            command = request.getParameter("command");
        }
        String destination;
        switch (command){
            case "home":
                destination = home(request, response);
                break;
            case "overview":
                destination = overview(request, response);
                break;
            case "signUp":
                destination = signUp(request,response);
                break;
            case "addPerson":
                destination = addPerson(request, response);
                break;
            case "verwijderpersonpage":
                destination = verwijderpersonpage(request, response);
                break;
            case "verwijderPerson":
                destination = verwijderPerson(request, response);
                break;
            case "producten":
                destination = productoverview(request, response);
                break;
            case "addproductpage":
                destination = addProductPage(request, response);
                break;
            case "addProduct":
                destination = addProduct(request, response);
                break;
            case "updateproductpage":
                destination = updateproductpage(request, response);
                break;
            case "updateProduct":
                destination = updateProduct(request, response);
                break;
            case "verwijderproductpage":
                destination = verwijderproductpage(request, response);
                break;
            case "verwijderProduct":
                destination = verwijderProduct(request, response);
                break;
            default:
                destination = home(request, response);
        }
        request.getRequestDispatcher(destination).forward(request,response);
    }




    private String home(HttpServletRequest request, HttpServletResponse response) {
        return "index.jsp";
    }

    private String overview(HttpServletRequest request,  HttpServletResponse response) {
        request.setAttribute("personen", service.getPersons());
        return "personoverview.jsp";
    }

    private String productoverview(HttpServletRequest request, HttpServletResponse response){
        request.setAttribute("producten", service.getProducts());
        return "productoverview.jsp";
    }

    private String addProductPage(HttpServletRequest request, HttpServletResponse response){
        return "voegproducttoe.jsp";
    }

    private String addProduct(HttpServletRequest request, HttpServletResponse response){
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String price = request.getParameter("price");
        if (name.isEmpty() || description.isEmpty() || price.isEmpty()) {
            return "voegproducttoe.jsp";
        }
        else{
            Product product = new Product(name, description, Double.parseDouble(price));
            service.addProduct(product);
            return productoverview(request, response);
        }

    }

    private String updateproductpage(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("productId"));
        Product product = service.getProduct(id);
        request.setAttribute("nameVorige", product.getName());
        request.setAttribute("descriptionVorige", product.getDescription());
        request.setAttribute("priceVorige", product.getPrice());
        request.setAttribute("idVorige", product.getProductId());
        return "updateproduct.jsp";
    }

    private String updateProduct(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("productId"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String price = request.getParameter("price");

        Product product = new Product(id,name,description,Double.parseDouble(price));
        service.updateProduct(product);
        return productoverview(request, response);
    }

    private String verwijderproductpage(HttpServletRequest request, HttpServletResponse response){
        return "verwijderproduct.jsp";
    }

    private String verwijderProduct(HttpServletRequest request, HttpServletResponse response){
        /*
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String price = request.getParameter("price");

        List<Product> p = shopService.getProducts();
        for (Product product : p) {
            if(product.getName().equals(name) && product.getDescription().equals(description) && product.getPrice() == Double.parseDouble(price)){
                int id = product.getProductId();
                shopService.deleteProduct(id);
            }
        }

         */
        String id = request.getParameter("productid");
        service.deleteProduct(Integer.parseInt(id));
        return productoverview(request, response);
    }

    private String signUp(HttpServletRequest request, HttpServletResponse response) {
        return "signUp.jsp";
    }

    private String addPerson(HttpServletRequest request, HttpServletResponse response){
        ArrayList<String> errors = new ArrayList<>();

        Person persoon = new Person();
        setUserid(persoon, request, errors);
        setFirstName(persoon, request, errors);
        setLastName(persoon, request, errors);
        setEmail(persoon, request, errors);
        setPassword(persoon, request, errors);


        if(errors.size() == 0){
            try{
                service.addPerson(persoon);
                return "index.jsp";
            }
            catch (DbException e){
                request.setAttribute("errors", e.getMessage());
                return "signUp.jsp";
            }
        }else {
            request.setAttribute("errors", errors);
            return "signUp.jsp";
        }
    }

    private String verwijderpersonpage(HttpServletRequest request, HttpServletResponse response){
        return "verwijderpersoon.jsp";
    }

    private String verwijderPerson(HttpServletRequest request, HttpServletResponse response){
        /*
        String email = request.getParameter("email");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        List<Person> p = shopService.getPersons();
        for (Person person : p) {
            if(person.getEmail().equals(email) && person.getFirstName().equals(firstname) && person.getLastName().equals(lastname)){
                String id = person.getUserid();
                shopService.deletePerson(id);
            }
        }

         */
        String id = request.getParameter("userid");
        service.deletePerson(id);
        return overview(request, response);
    }


    private void setUserid(Person persoon, HttpServletRequest request, ArrayList<String> errors) {
        String userid = request.getParameter("userid");

        try{
            persoon.setUserid(userid);
            request.setAttribute("useridVorige", userid);
        }
        catch (IllegalArgumentException e){
            errors.add(e.getMessage());
        }
    }

    private void setFirstName(Person persoon, HttpServletRequest request, ArrayList<String> errors) {
        String firstName = request.getParameter("firstName");

        try{
            persoon.setFirstName(firstName);
            request.setAttribute("firstNameVorige", firstName);
        }
        catch (IllegalArgumentException e){
            errors.add(e.getMessage());
        }
    }

    private void setLastName(Person persoon, HttpServletRequest request, ArrayList<String> errors) {
        String lastName = request.getParameter("lastName");

        try{
            persoon.setLastName(lastName);
            request.setAttribute("lastNameVorige", lastName);
        }
        catch (IllegalArgumentException e){
            errors.add(e.getMessage());
        }
    }

    private void setEmail(Person persoon, HttpServletRequest request, ArrayList<String> errors) {
        String email = request.getParameter("email");

        try{
            persoon.setEmail(email);
            request.setAttribute("emailVorige", email);
        }
        catch (IllegalArgumentException e){
            errors.add(e.getMessage());
        }
    }

    private void setPassword(Person persoon, HttpServletRequest request, ArrayList<String> errors) {
        String password = request.getParameter("password");

        try{
            persoon.setPassword(password);
            request.setAttribute("passwordVorige", password);
        }
        catch (IllegalArgumentException e){
            errors.add(e.getMessage());
        }
    }



}
