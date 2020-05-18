package domain.db;

import domain.model.Role;
import domain.model.User;

import java.util.HashMap;
import java.util.Map;

public class Users {
    private Map<String, User> users;

    public Users() {
        this.users = new HashMap<>();
        addUser(new User("Anne", Role.ADMIN, "anne"));
        addUser(new User("Celine", Role.CUSTOMER, "celine"));
    }

    public void addUser(User user) {
        if (user == null)
            throw new IllegalArgumentException("No user to add");
        if (findUser(user.getName()) != null)
            throw new IllegalArgumentException("User already exists");
        users.put(user.getName(), user);
    }

    /**
     * find user with given name
     *
     * @return registered user if user with given name exists
     * and null if no user with given name exists
     */
    public User findUser(String name) {
        if (name == null)
            throw new IllegalArgumentException("No name to find");
        return users.get(name);
    }

    /**
     * Check password of user with given name
     *
     * @return user in case of matching name/password
     * and null otherwise
     */
    public User getUserIfAuthenticated(String name, String password) {
        User user = findUser(name);
        if (user != null && user.isPasswordCorrect(password))
            return user;
        return null;
    }
}
