package main.java.controller;

import main.java.db.PersonRepositoryStub;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.util.ServiceConfigurationError;

public class ControllerFactory {

    public RequestHandler getHandler(String handlerName, PersonRepositoryStub model) throws ServiceConfigurationError{
        RequestHandler handler = null;
        if (handlerName == null || handlerName.isEmpty())
        {
            handlerName = "home";
        }
        try{
            Class handlerClass = Class.forName("main.java.controller."+ handlerName);
            Object handlerObject = handlerClass.newInstance();
            handler = (RequestHandler) handlerObject;
            handler.setModel(model);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return handler;
    }
}
