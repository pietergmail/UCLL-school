package domain.db;

import domain.DomainException;
import domain.model.Lid;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class LedenDBSQL implements LedenDB {
    private Properties properties;
    private String url;

    public LedenDBSQL(Properties properties) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new DbException(e.getMessage(), e);
        }
        this.properties = properties;
        url = properties.getProperty("url");
    }

    public Lid geefLid(String email) {
        String naam = "", niveaugroep = "";
        try (Connection connection = DriverManager.getConnection(url, properties);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM herremanspieter.leden where email = '" + email + "'");
            while (resultSet.next()) {
                naam = resultSet.getString("naam");
                niveaugroep = resultSet.getString("niveaugroep");
            }
            return new Lid(email, naam, niveaugroep);
        } catch (SQLException e) {
            throw new DbException(e.getMessage(), e);
        } catch (DomainException e) {
            return null;
        }
    }

    public List<Lid> geefAlleLeden() {
        try (Connection connection = DriverManager.getConnection(url, properties);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM herremanspieter.leden");
            return createListFromResultset(resultSet);
        } catch (SQLException e) {
            throw new DbException(e.getMessage(), e);
        }
    }

    /**
     * Creates a list of leden from the given resultset
     *
     * @throws SQLException
     */
    private List<Lid> createListFromResultset(ResultSet resultSet) throws SQLException {
        List<Lid> leden = new ArrayList<>();
        while (resultSet.next()) {
            String email = resultSet.getString("email");
            String naam = resultSet.getString("naam");
            String niveaugroep = resultSet.getString("niveaugroep");
            Lid lid = new Lid(email, naam, niveaugroep);
            leden.add(lid);
        }
        return leden;
    }

    @Override
    public List<Lid> getSortedLeden(){
        try (Connection connection = DriverManager.getConnection(url, properties);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM herremanspieter.leden ORDER BY 2 ");
            return createListFromResultset(resultSet);
        } catch (SQLException e) {
            throw new DbException(e.getMessage(), e);
        }
    }
}
