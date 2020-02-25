package ui.handler;

import domain.model.ShopService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class RequestHandler {

    public ShopService getService() {
        return service;
    }
    public void setService(ShopService service) {
        this.service = service;
    }

    ShopService service;

    public abstract void handleRequest(HttpServletRequest request, HttpServletResponse response);

}
