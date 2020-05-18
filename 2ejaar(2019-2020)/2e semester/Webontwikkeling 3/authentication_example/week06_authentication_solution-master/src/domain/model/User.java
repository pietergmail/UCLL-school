package domain.model;

public class User {
    String name;
    Role role;
    String password;

    public User() {

    }

    public User(String name, Role role, String password) {
        this.setName(name);
        this.setRole(role);
        this.setPassword(password);
    }

    public boolean isPasswordCorrect(String password) {
        return this.password.equals(password);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!isValidName(name))
            throw new IllegalArgumentException("No valid name");
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (!isValidPassword(password))
            throw new IllegalArgumentException("No valid password");
        this.password = password;
    }

    public boolean isValidPassword(String password) {
        return password != null && password.length() > 2;
    }

    public boolean isValidName(String name) {
        return name != null && !name.isEmpty();
    }
}
