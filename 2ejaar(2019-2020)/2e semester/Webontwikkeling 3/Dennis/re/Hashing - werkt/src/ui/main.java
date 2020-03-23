package ui;

import domain.model.Person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.swing.JOptionPane;
import java.util.UUID;

public class main {
    private static Connection connection;
    private static Statement statement;

    public static void main(String[] args) throws SQLException {

        String AskName = "Wat is de naam?";
        String AskSurname = "Wat is de voornaam?";
        String AskEmail = "Wat is het emailadress?";
        String AskPassword = "Wat is het wachtwoord?";
        String AskPassword2 = "Type the password again please?";

        String fillfirstname = JOptionPane.showInputDialog(AskName);
        String filllastname = JOptionPane.showInputDialog(AskSurname);
        String fillemail = JOptionPane.showInputDialog(AskEmail);
        String fillpassword = JOptionPane.showInputDialog(AskPassword);
        String fillpassword2 = JOptionPane.showInputDialog(AskPassword2);
        if (!fillpassword.equals(fillpassword2)) {
            JOptionPane.showMessageDialog(null, "Passwords did not match, restarting daand");
            main(args);
        }
        UUID uuid=null;
        try {
            uuid = UUID.randomUUID();
            Person p = new Person(uuid.toString(), fillemail, fillpassword, fillfirstname, filllastname);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            main(args);
        }
        setup();
        statement = connection.createStatement();
        statement.execute("INSERT INTO \"herremanspieter\".\"person\"(userid,email,password, firstname,lastname) " +"values('"+ uuid +"','"+fillemail+"','"+fillpassword+"','"+fillfirstname+"','"+filllastname+"')");
        close();

        setup();
        actions();
        close();
    }

    public static void setup() throws SQLException {
        Properties properties = new Properties();
        String url = "jdbc:postgresql://databanken.ucll.be:61920/2TX32";
        properties.setProperty("user", "local_r0745616");
        properties.setProperty("password", "K5b)W7-uOvàw4");
        properties.setProperty("ssl", "true");
        properties.setProperty("sslfactory", "org.postgresql.ssl.NonValidatingFactory");
        properties.setProperty("sslmode", "prefer");
        connection = DriverManager.getConnection(url, properties);

    }

    public static void actions() throws SQLException {
        statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM \"herremanspieter\".\"person\"");

        while (result.next()) {
            String firstname = result.getString("firstname");
            String lastname = result.getString("lastname");
            String userid = result.getString("userid");
            String email = result.getString("email");
            String password = result.getString("password");
            try {    // validation of data stored in database

                Person p = new Person(userid, email, password, firstname, lastname);
                System.out.println(p.toString());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void close() throws SQLException {
        statement.close();
        connection.close();
    }
}