package ui.handler;

import domain.model.ShopService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;

public class HandlerFactory {


    public static RequestHandler getHandler(HttpServletRequest request, HttpServletResponse response, ShopService service) {
        String command = request.getParameter("command");
        if (command == null){command = "home";}
        RequestHandler handler = null;
        try {
            System.out.println("ui.handler." + command + "Handler");
            Class handlerClass = Class.forName("ui.handler." + command + "Handler");
            Object handlerObject = handlerClass.getConstructor().newInstance();
            handler = (RequestHandler) handlerObject;
            handler.setService(service);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw  new RuntimeException("The requested page could not be found");
        }
        return handler;
    }

}
