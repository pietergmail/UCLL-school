package domain.db;

import domain.model.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ProductdbSql implements ProductDb {
    private Properties properties;
    private String url;

    public ProductdbSql(Properties p){
        try {
            Class.forName("org.postgresql.Driver");
            this.properties = p;
            this.url = properties.getProperty("url");
        } catch (Exception e) {
            throw new DbException(e.getMessage(), e);
        }
    }
    @Override
    public Product get(int id) {
        Product p = new Product();
        ResultSet result=null;

        try (Connection connection = DriverManager.getConnection(url, properties);
             Statement statement = connection.createStatement()) {
            result = statement.executeQuery("select * from \"herremanspieter\".\"person\" where productid = " + id);
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
            result = statement.executeQuery("SELECT * FROM \"herremanspieter\".\"product\"");
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
            statement.executeUpdate("insert into \"herremanspieter\".\"product\"(productid, name,description,price)\n" +
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
            statement.executeUpdate("UPDATE  \"herremanspieter\".\"product\" \n" +
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
            statement.executeUpdate("delete from \"herremanspieter\".\"product\" \n where  productid = '" + id +"'");
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
