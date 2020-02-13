package controller;

import db.BikeRepository;
import domain.Bike;
import domain.Category;
import domain.DomainException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    BikeRepository bikes = new BikeRepository();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processrequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processrequest(request, response);
    }

    protected void processrequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Cookie[] cookies = request.getCookies();
        Cookie c = findCookie(cookies, "brief");

        if(c != null){
            if(c.getValue().equals("Nieuwsbrief")){
                request.setAttribute("brief", "Nieuwsbrief");
            }
        }

        String command = "";
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
            case "detail":
                destination = detail(request, response);
                break;
            case "add":
                destination = add(request, response);
                break;
            case "addBike":
                destination = addBike(request, response);
                break;
            case "cookie":
                destination = cookie(request, response);
                break;
            case "nieuwsbrief":
                destination = brief(request, response);
                break;
            case "gesch":
                destination = gesch(request, response);
                break;
            default:
                destination = home(request, response);
        }
        request.getRequestDispatcher(destination).forward(request, response);
    }

    public String home(HttpServletRequest request, HttpServletResponse response){return "index.jsp";}

    public String overview(HttpServletRequest request, HttpServletResponse response){
        request.setAttribute("bikes", bikes.getAll());
        return "bikeOverview.jsp";
    }

    public String add(HttpServletRequest request, HttpServletResponse response){return "bikeAdd.jsp";}

    public String detail(HttpServletRequest request, HttpServletResponse response){
        request.setAttribute("bike", bikes.get(request.getParameter("id")));
        ArrayList<Bike> user = (ArrayList<Bike>) request.getSession().getAttribute("gesch");
        if(user == null){
            user = new ArrayList<Bike>();
        }
        user.add(bikes.get(request.getParameter("id")));
        request.getSession().setAttribute("gesch", user);
        return "bikeDetail.jsp";
    }

    protected String addBike(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<String> errors = new ArrayList<>();

        Bike bike = new Bike();
        setId(bike,request,errors);
        setCat(bike,request,errors);
        setBrand(bike,request,errors);
        setDesc(bike,request,errors);
        setPrice(bike,request,errors);

        if(errors.size() == 0){
            bikes.add(bike);
            return overview(request, response);
        }else{
            request.setAttribute("errors", errors);
            return "bikeAdd.jsp";
        }

    }

    protected String cookie(HttpServletRequest request, HttpServletResponse response){
        Cookie c = new Cookie("brief", request.getParameter("nieuwsbrief"));
        response.addCookie(c);
        request.setAttribute("brief", request.getParameter("nieuwsbrief"));
        return "index.jsp";
    }

    protected Cookie findCookie(Cookie[] c, String key){
        if(c == null || c.length == 0){return null;}
        for(Cookie co : c){
            if(co.getName().equals(key)){
                return co;
            }
        }
        return null;
    }

    protected String brief(HttpServletRequest request, HttpServletResponse response){return "nieuwsbrief.jsp";}

    public String gesch(HttpServletRequest request, HttpServletResponse response){
        request.setAttribute("bikes", request.getSession().getAttribute("gesch"));
        return "overview.jsp";
    }

    protected void setId(Bike bike, HttpServletRequest request, ArrayList<String> errors){
        try{
            if(bikes.get(request.getParameter("itemId")) != null){throw new DomainException("Bike id al in database");}
            bike.setItemId(request.getParameter("itemId"));
            request.setAttribute("previd", request.getParameter("itemId"));
        }catch (DomainException e){
            errors.add(e.getMessage());
        }
    }

    protected void setCat(Bike bike, HttpServletRequest request, ArrayList<String> errors){
        try{
            bike.setCategory(Category.valueOf(request.getParameter("category")));
            request.setAttribute("precat", request.getParameter("category"));
        }catch (DomainException e){
            errors.add(e.getMessage());
        }catch (IllegalArgumentException eg){
            errors.add(eg.getMessage() + "ROAD / CITY");
        }
    }

    protected void setBrand(Bike bike, HttpServletRequest request, ArrayList<String> errors){
        try{
            bike.setBrand(request.getParameter("brand"));
            request.setAttribute("prevbrand", request.getParameter("brand"));
        }catch (DomainException e){
            errors.add(e.getMessage());
        }
    }

    protected void setDesc(Bike bike, HttpServletRequest request, ArrayList<String> errors){
        try{
            bike.setDescription(request.getParameter("description"));
            request.setAttribute("prevdesc", request.getParameter("description"));
        }catch (DomainException e){
            errors.add(e.getMessage());
        }
    }

    protected void setPrice(Bike bike, HttpServletRequest request, ArrayList<String> errors){
        try{
            bike.setPrice(Double.parseDouble(request.getParameter("price")));
            request.setAttribute("prevprice", request.getParameter("price"));
        }catch (DomainException e){
            errors.add(e.getMessage());
        }catch (NumberFormatException eg){
            errors.add(eg.getMessage());
        }
    }
}
