package ui.controller;


import domain.db.Wielerclub;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;

public class ControllerFactory {
    public RequestHandler getHandler(HttpServletRequest request, HttpServletResponse response, Wielerclub wielerclub) {
        String command = request.getParameter("command");
        if(command == null){
            command = "Home";
        }
        RequestHandler handler = null;
        try {
            Class handlerClass = Class.forName("ui.controller." + command + "Handler");
            Object handlerObject = handlerClass.getConstructor().newInstance();
            handler = (RequestHandler) handlerObject;
            handler.setWielerclub(wielerclub);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw  new RuntimeException("The requested page could not be found");
        }
        return handler;
    }
}