
package ui.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import domain.db.PersonDb;
import domain.model.Person;

public class TestDB {
    public static void main(String[] args) throws SQLException {
        Properties properties = new Properties();
        String url = "jdbc:postgresql://databanken.ucll.be:61920/2TX32";
        properties.setProperty("user", "local_r0745616");
        properties.setProperty("password", "K5b)W7-uOvàw4");
        properties.setProperty("ssl", "true");
        properties.setProperty("sslfactory", "org.postgresql.ssl.NonValidatingFactory");
        properties.setProperty("sslmode","prefer");

        Connection connection = DriverManager.getConnection(url,properties);
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery( "SELECT * FROM herremanspieter.Person" );

        while(result.next()){
            String userid = result.getString("userid");
            String email = result.getString("email");
            String password = result.getString("password");
            String firstName = result.getString("firstName");
            String lastName = result.getString("lastName");
            try {	// validation of data stored in database
                Person person = new Person(userid, email, password, firstName, lastName);
                System.out.println(person.toString());
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        statement.close();
        connection.close();
    }
}