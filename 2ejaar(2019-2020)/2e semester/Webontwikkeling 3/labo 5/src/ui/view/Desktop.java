package ui.view;
import domain.model.Person;

import javax.swing.*;
import java.io.StringReader;
import java.sql.*;
import java.util.Properties;


public class Desktop {
    public static void main(String[] args) throws SQLException {
        Properties properties = new Properties();
        String url = "jdbc:postgresql://databanken.ucll.be:61920/2TX35";
        properties.setProperty("user", "local_r0749536");
        properties.setProperty("password", "LE3vh7-,w)U1$Tv");
        //Secret.setPass(properties);	// implements line 17 and 18
        properties.setProperty("ssl", "true");
        properties.setProperty("sslfactory", "org.postgresql.ssl.NonValidatingFactory");
        properties.setProperty("sslmode","prefer");

        Connection connection = DriverManager.getConnection(url,properties);
        Statement statement = connection.createStatement();



        String uid = JOptionPane.showInputDialog("userid");
        String mail = JOptionPane.showInputDialog("email");
        String pass = JOptionPane.showInputDialog("password");
        String fname = JOptionPane.showInputDialog("firstname");
        String lname = JOptionPane.showInputDialog("lastname");

        statement.executeUpdate("insert into vanhaerencorentinweb3.person(userid, email, password, firstname, lastname) values('" + uid + "', '" + mail + "', '" + pass + "', '" + fname + "', '" + lname + "')");


        ResultSet result = statement.executeQuery( "SELECT * FROM vanhaerencorentinweb3.person" );

        while(result.next()){
            String userid = result.getString("userid");
            String email = result.getString("email");
            String password = result.getString("password");
            String firstname = result.getString("firstname");
            String lastname = result.getString("lastname");
            try {	// validation of data stored in database
                Person person = new Person(userid, email, password, firstname,lastname);
                System.out.println(person.getFirstName() + " " + person.getLastName() + ": " + person.getUserid() + ", " + person.getEmail());
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        statement.close();
        connection.close();
    }
}

