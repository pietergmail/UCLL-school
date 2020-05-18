package domain.db;

import domain.model.Role;
import domain.model.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UsersTest {
    private Users users;
    private User validAdmin = new User("Dina",Role.ADMIN,"dina");
    private User validCustomer = new User("Els",Role.CUSTOMER,"els");

    @Before
    public void setUp() throws Exception {
        users = new Users();
    }

    @Test
    public void validUserIsAdded() {
        users.addUser(validAdmin);
        assertEquals(validAdmin,users.findUser(validAdmin.getName()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addingUserTwiceThrowsException() {
        users.addUser(validAdmin);
        users.addUser(validAdmin);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addingNullUserThrowsException() {
        users.addUser(null);
    }

    @Test
    public void validPasswordReturnsUser() {
        assertEquals(users.findUser("Anne"),users.getUserIfAuthenticated("Anne","anne"));
    }

    @Test
    public void invalidPasswordReturnsNull() {
        assertNull(users.getUserIfAuthenticated("Anne",""));
    }
}