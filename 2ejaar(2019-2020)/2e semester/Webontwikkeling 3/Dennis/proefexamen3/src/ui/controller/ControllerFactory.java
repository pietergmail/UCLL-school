package ui.controller;

import domain.model.ProductService;

public class ControllerFactory {
	
    public RequestHandler getController(String key, ProductService model) {
        return createHandler(key, model);
    }
    
	private RequestHandler createHandler(String handlerName, ProductService model) {
		RequestHandler handler = null;
		if (handlerName == null || handlerName.isEmpty())
		{
			handlerName = "Home";
		}
		try {
			Class<?> handlerClass = Class.forName("ui.controller."+ handlerName);
			Object handlerObject = handlerClass.getConstructor().newInstance();
			handler = (RequestHandler) handlerObject;
	    	handler.setModel(model);
		} catch (Exception e) {
			throw new RuntimeException("Deze pagina bestaat niet!!!!");
		}
		return handler;
	}


}
