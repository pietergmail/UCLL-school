package ui.controller;

public class ControllerException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ControllerException() {
		super();
	}
	
	public ControllerException(String message, Throwable exception) {
		super(message, exception);
	}
	
	public ControllerException(String message) {
		super(message);
	}
	
	public ControllerException(Throwable exception) {
		super(exception);
	}
	

}
