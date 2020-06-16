package ui.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.beans.EventHandler;
import java.util.Objects;

public class VegetarianProductOverviewHandler extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String test = (String) request.getSession().getAttribute("user");
        if(Objects.equals(test, "admin")){
            return "vegetarianProducts.jsp";
        }else{
            return "error.jsp";
        }
    }
}
