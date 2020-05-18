package ui.controller;



public class ControllerFactory {

    public RequestHandler getController(String key) {
        return createHandler(key);
    }

    private RequestHandler createHandler(String handlerName) {
        RequestHandler handler = null;
        try {
            Class<?> handlerClass = Class.forName("ui.controller." + handlerName);
            Object handlerObject = handlerClass.getConstructor().newInstance();
            handler = (RequestHandler) handlerObject;
        } catch (Exception e) {
            throw new RuntimeException("The requested page doesn’t exist");
        }
        return handler;
    }


}
