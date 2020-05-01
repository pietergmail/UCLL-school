package ui.controller;

import domain.model.ShopService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class RequestHandler{
    public ShopService service;

    public ShopService getSerivce(){
        return service;
    }

    public void setService(ShopService service){ this.service = service; }

    public abstract String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

    public void setModel(ShopService service){this.service = service;}
}
