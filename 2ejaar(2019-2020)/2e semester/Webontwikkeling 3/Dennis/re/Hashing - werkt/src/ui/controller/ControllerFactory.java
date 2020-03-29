package ui.controller;

import domain.model.ShopService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;

public class ControllerFactory {
    public RequestHandler getHandler(HttpServletRequest request, HttpServletResponse response, ShopService service){
        String command = request.getParameter("command");
        ui.controller.RequestHandler handler = null;
        try{
            Class handlerClass = Class.forName("controller." + command + "Handler");
            Object handlerObject = handlerClass.getConstructor().newInstance();
            handler = (ui.controller.RequestHandler) handlerObject;
            handler.setService(service);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException("The requested page could not be found");
        }
        return handler;
    }
}
