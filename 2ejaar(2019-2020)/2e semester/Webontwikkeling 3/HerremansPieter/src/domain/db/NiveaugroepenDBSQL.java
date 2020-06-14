package domain.db;

import domain.DomainException;
import domain.model.Lid;
import domain.model.Niveaugroep;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class NiveaugroepenDBSQL implements NiveaugroepenDB {
    private Properties properties = new Properties();
    private String url;

    public NiveaugroepenDBSQL(Properties properties) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new DbException(e.getMessage(), e);
        }
        this.properties = properties;
        url = properties.getProperty("url");
    }

    public Niveaugroep geefNiveaugroep(String naam) {
		throw new UnsupportedOperationException("to be completed");
    }

    public List<Niveaugroep> geefAlleNiveaugroepen() {
        try (Connection connection = DriverManager.getConnection(url, properties);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM herremanspieter.groepen");
            return createListFromResultset(resultSet);
        } catch (SQLException e) {
            throw new DbException(e.getMessage(), e);
        }
    }

    /**
     * Creates a list of groups from the given resultset
     *
     * @throws SQLException
     */
    private List<Niveaugroep> createListFromResultset(ResultSet resultSet) throws SQLException {
        List<Niveaugroep> groepen = new ArrayList<>();
        while (resultSet.next()) {
            String naam = resultSet.getString("naam");
            double richtsnelheid = resultSet.getDouble("richtsnelheid");
            String omschrijving = resultSet.getString("omschrijving");
            Niveaugroep groep = new Niveaugroep(naam, omschrijving, richtsnelheid);
            groepen.add(groep);
        }
        return groepen;
    }

}
