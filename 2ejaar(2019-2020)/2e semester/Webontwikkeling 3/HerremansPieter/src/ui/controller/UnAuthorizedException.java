package ui.controller;

public class UnAuthorizedException extends RuntimeException {
    public UnAuthorizedException(String s) {
        super(s);
    }
}
