package ui.controller;

import domain.model.ShopService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.util.ServiceConfigurationError;

public class ControllerFactory {

    public RequestHandler getHandler(String handlerName, ShopService model) throws ServiceConfigurationError{
        RequestHandler handler = null;
        if (handlerName == null || handlerName.isEmpty())
        {
            handlerName = "home";
        }
        try{
            Class handlerClass = Class.forName("ui.controller."+ handlerName);
            Object handlerObject = handlerClass.newInstance();
            handler = (RequestHandler) handlerObject;
            handler.setModel(model);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return handler;
    }
}
