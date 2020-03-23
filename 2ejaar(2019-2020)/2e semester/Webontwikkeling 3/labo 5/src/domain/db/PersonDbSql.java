package domain.db;

import domain.model.Person;
import domain.model.Product;

import javax.servlet.ServletContext;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PersonDbSql implements PersonDb {

    private Properties properties = new Properties();
    private String url = "jdbc:postgresql://databanken.ucll.be:61920/2TX32";

    public PersonDbSql(Properties properties) {
        try {
            Class.forName("org.postgresql.Driver");
            this.properties = properties;
            this.url = properties.getProperty("url");
        } catch (ClassNotFoundException e) {
            throw new DbException(e.getMessage(), e);
        }
    }

    @Override
    public Person get(String personId) {
        if (personId == null) {
            throw new DbException("No id given");
        }
        Person person = null;
        String sql = "select * from person where lower(userid) like lower (?)";
        try (Connection connection = DriverManager.getConnection(url, properties);
             PreparedStatement statement = connection.prepareStatement(sql))
        {
            statement.setString(1, personId);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                String userid = result.getString("userid");
                String email = result.getString("email");
                String password = result.getString("password");
                String firstname = result.getString("firstname");
                String lastname = result.getString("lastname");

                person = new Person(userid, email, password, firstname, lastname);
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage(), e);
        }
        return person;
    }

    @Override
    public List<Person> getAll() {
        List<Person> personnen = new ArrayList<>();
        String sql = "SELECT * FROM herremanspieter.person";
        try (Connection connection = DriverManager.getConnection(url, properties);
             Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                String userid = result.getString("userid");
                String email = result.getString("email");
                String password = result.getString("password");
                String firstname = result.getString("firstname");
                String lastname = result.getString("lastname");

                Person person = new Person(userid, email, password, firstname, lastname);
                personnen.add(person);
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage(), e);
        }
        return personnen;
    }

    @Override
    public void add(Person person) {
        String sql = "";
        if (person == null) {
            throw new DbException("No person given");
        }

        sql = "select count(userid) as aantal from herremanspieter.person where userid = ?";
        String aantal = "";
        try (
                Connection connection = DriverManager.getConnection(url, properties);
                PreparedStatement statement = connection.prepareStatement(sql))
        {
        statement.setString(1, person.getUserid());
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                aantal = result.getString("aantal");
            }
        } catch (SQLException e) {
            throw new DbException(e);
        }
        if (Integer.parseInt(aantal) != 0) {
            throw new DbException("User already exists");
        }

        sql = "insert into herremanspieter.person(userid, email, password, firstname, lastname) values(?, ?, ?, ?, ?)";
        try {
            Connection connection = DriverManager.getConnection(url, properties);
            PreparedStatement statement = connection.prepareStatement(sql);
            {
                statement.setString(1, person.getUserid());
                statement.setString(2, person.getEmail());
                statement.setString(3, person.getPassword());
                statement.setString(4, person.getFirstName());
                statement.setString(5, person.getLastName());
                statement.execute();
            }
        } catch (SQLException e) {
            throw new DbException(e);
        }
    }

    @Override
    public void update(Person person) {
        String sql = "";
        if (person == null) {
            throw new DbException("No person given");
        }
        sql = "select count(userid) as aantal from person where userid = ?";
        String aantal = "";
        try (
                Connection connection = DriverManager.getConnection(url, properties);
                PreparedStatement statement = connection.prepareStatement(sql))
        {
            statement.setString(1, person.getUserid());
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                aantal = result.getString("aantal");
            }
        } catch (SQLException e) {
            throw new DbException(e);
        }
        if (Integer.parseInt(aantal) == 0) {
            throw new DbException("No person found");
        }
        sql = "update herremanspieter.person set email = ?, password = ?, firstname = ?, lastname = ? where userid = ?";
        try {
            Connection connection = DriverManager.getConnection(url, properties);
            PreparedStatement statement = connection.prepareStatement(sql);
            {
                statement.setString(1, person.getEmail());
                statement.setString(2, person.getPassword());
                statement.setString(3, person.getFirstName());
                statement.setString(4, person.getLastName());
                statement.setString(5, person.getUserid());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new DbException(e);
        }
    }

    @Override
    public void delete(String personId) {
        if (personId == null) {
            throw new DbException("No id given");
        }
        String sql = "delete from herremanspieter.person where userid = ?";
        try {
            Connection connection = DriverManager.getConnection(url, properties);
            PreparedStatement statement = connection.prepareStatement(sql);
            {
                statement.setString(1, personId);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new DbException(e);
        }
    }

    @Override
    public int getNumberOfPersons() {
        String sql = "select count(userid) as aantal from person";
        String aantal = "";
        try (
                Connection connection = DriverManager.getConnection(url, properties);
                Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                aantal = result.getString("aantal");
            }
        } catch (SQLException e) {
            throw new DbException(e);
        }
        return Integer.parseInt(aantal);
    }
}
