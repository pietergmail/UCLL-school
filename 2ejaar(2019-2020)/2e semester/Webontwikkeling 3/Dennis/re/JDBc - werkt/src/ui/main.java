package ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import domain.model.Person;

public class main {
    public static void main(String[] args) throws SQLException {
        Properties properties = new Properties();
        String url = "jdbc:postgresql://databanken.ucll.be:51920/2TX31?currentSchema=WinnepenninckxDennisWeb3";
        properties.setProperty("user", "local_r0748117");
        properties.setProperty("password", "sm(ç6ù=-Hju376(");
        properties.setProperty("ssl", "true");
        properties.setProperty("sslfactory", "org.postgresql.ssl.NonValidatingFactory");
        properties.setProperty("sslmode","prefer");

        Connection connection = DriverManager.getConnection(url,properties);
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery( "SELECT * FROM \"WinnepenninckxDennisWeb3\".\"Person\"" );

        while(result.next()){
            String userid = result.getString("userid");
            String firstname = result.getString("firstname");
            String lastname = result.getString("lastname");
            String email = result.getString("email");
            String password = result.getString("password");
            try {	// validation of data stored in database
                Person p = new Person(userid, email,password, firstname, lastname);
                System.out.println(p.toString());
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        statement.close();
        connection.close();
    }
}