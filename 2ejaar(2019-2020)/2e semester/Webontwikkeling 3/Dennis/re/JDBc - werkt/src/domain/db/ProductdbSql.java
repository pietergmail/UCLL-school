package domain.db;

import domain.model.Person;
import domain.model.Product;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ProductdbSql implements ProductDb {
    private Properties properties;
    private String url = "jdbc:postgresql://databanken.ucll.be:51920/2TX31?currentSchema=WinnepenninckxDennisWeb3";

    public ProductdbSql(){
        properties = new Properties();
        properties.setProperty("user", "local_r0748117");
        properties.setProperty("password", "sm(ç6ù=-Hju376(");
        properties.setProperty("ssl", "true");
        properties.setProperty("sslfactory", "org.postgresql.ssl.NonValidatingFactory");
        properties.setProperty("sslmode","prefer");
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Override
    public Product get(int id) {
        Product p = new Product();
        ResultSet result=null;

        try (Connection connection = DriverManager.getConnection(url, properties);
             Statement statement = connection.createStatement()) {
            result = statement.executeQuery("select * from \"WinnepenninckxDennisWeb3\".\"Product\" where productid = " + id);
            p = makeProdFromSet(result);
        }catch (Exception e){
            e.printStackTrace();
        }
        return p;

    }

    @Override
    public List<Product> getAll() {
        ResultSet result=null;
        ArrayList list = new ArrayList();
        try (Connection connection = DriverManager.getConnection(url, properties);
             Statement statement = connection.createStatement()) {
            result = statement.executeQuery("SELECT * FROM \"WinnepenninckxDennisWeb3\".\"Product\"");
            list = (ArrayList) makeProductsFromSet(result);
            }catch (Exception e){
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public void add(Product product) {

        String name = product.getName();
        String id = product.getProductId();
        String description = product.getDescription();
        double price = product.getPrice();
        try (Connection connection = DriverManager.getConnection(url, properties);
             Statement statement = connection.createStatement()) {
             statement.executeUpdate("insert into \"WinnepenninckxDennisWeb3\".\"Product\"(productid, name,description,price)\n" +
                    "values('" + id + "','" + name + "','" + description + "'," + price + ")");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void update(Product product) {
        String name = product.getName();
        String id = product.getProductId();
        String description = product.getDescription();
        double price = product.getPrice();

        try (Connection connection = DriverManager.getConnection(url, properties);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("UPDATE  \"WinnepenninckxDennisWeb3\".\"Product\" \n" +
                    "set name='" + name + "',description='" + description + "',price=" + price + "\n" +
                    "Where productid = '" + id +"'");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void delete(String id) {
        try (Connection connection = DriverManager.getConnection(url, properties);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("delete from \"WinnepenninckxDennisWeb3\".\"Product\" \n where  productid = '" + id +"'");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public int getNumbeOfProducts() {
        return getAll().size();
    }


    private Product makeProdFromSet(ResultSet result) {
        Product p = null;
        try {
            String productid = result.getString("productid");
            String name = result.getString("name");
            String description = result.getString("description");
            String price = result.getString("price");
            try {    // validation of data stored in database
                p = new Product(productid, name, description, Double.parseDouble(price));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }

    private List<Product> makeProductsFromSet(ResultSet result) {
        ArrayList<Product> products = new ArrayList<>();
        Product p = null;

        try {
            while (result.next()) {
                String productid = result.getString("productid");
                String name = result.getString("name");
                String description = result.getString("description");
                String price = result.getString("price");
                try {    // validation of data stored in database
                    p = new Product(productid, name, description, Double.parseDouble(price));
                    products.add(p);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

}
