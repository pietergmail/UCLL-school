package domain.model;

public class User {
    String name;
    Role role;

    public User() {

    }

    public User(String name, Role role) {
        this.setName(name);
        this.setRole(role);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


}
