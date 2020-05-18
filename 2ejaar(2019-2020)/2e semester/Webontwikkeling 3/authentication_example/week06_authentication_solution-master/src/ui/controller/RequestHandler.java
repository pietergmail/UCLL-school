package ui.controller;

import domain.db.Users;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class RequestHandler {
    private Users users;

    public abstract String handleRequest(HttpServletRequest request, HttpServletResponse response);

    public void setUsers(Users users) {
        this.users = users;
    }

    public Users getUsers() {
        return users;
    }
}
