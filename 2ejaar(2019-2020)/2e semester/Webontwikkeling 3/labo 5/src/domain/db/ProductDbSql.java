package domain.db;

import domain.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ProductDbSql implements ProductDb{
    private Properties properties = new Properties();
    private String url = "jdbc:postgresql://databanken.ucll.be:61920/2TX35";

    public ProductDbSql(Properties properties){
        try{
            Class.forName("org.postgresql.Driver");
            this.properties = properties;
            this.url = properties.getProperty("url");
        }catch (ClassNotFoundException e){
            throw new DbException(e.getMessage(), e);
        }
    }
    @Override
    public Product get(int id) {
        if(id < 0){
            throw new DbException("No valid id given");
        }
        Product product = null;
        String sql = "select * from herremanspieter.product where productid = ?";
        try (Connection connection = DriverManager.getConnection(url, properties);
             PreparedStatement statement = connection.prepareStatement(sql))
        {
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                String productid = result.getString("productid");
                String name = result.getString("name");
                String description = result.getString("description");
                String price= result.getString("price");

                product = new Product(Integer.parseInt(productid), name, description, Double.parseDouble(price));
            }
        }
        catch (SQLException e){
            throw new DbException(e.getMessage(), e);
        }
        return product;
    }

    @Override
    public List<Product> getAll() {
        List<Product> producten = new ArrayList<>();
        String sql = "SELECT * FROM herremanspieter.product";
        try (Connection connection = DriverManager.getConnection(url, properties);
             Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                String productid = result.getString("productid");
                String name = result.getString("name");
                String description = result.getString("description");
                String price= result.getString("price");

                Product product = new Product(Integer.parseInt(productid), name, description, Double.parseDouble(price));
                producten.add(product);
            }
        }
        catch (SQLException e){
            throw new DbException(e.getMessage(), e);
        }
        return producten;
    }

    @Override
    public void add(Product product) {
        String sql = "";
        if(product == null){
            throw new DbException("No product given");
        }
        sql ="select max(productid) as aantal from herremanspieter.product";
        String id = "";
        try (
                Connection connection = DriverManager.getConnection(url, properties);
                Statement statement = connection.createStatement()){
            ResultSet result = statement.executeQuery(sql);
            while (result.next()){
                id = result.getString("aantal");
            }
        }
        catch (SQLException e){
            throw new DbException(e);
        }
        product.setProductId(Integer.parseInt(id)+1);
        sql ="select count(productid) as aantal from herremanspieter.product where productid = ?";
        String aantal = "";
        try (
                Connection connection = DriverManager.getConnection(url, properties);
                PreparedStatement statement = connection.prepareStatement(sql))
        {
            statement.setInt(1, product.getProductId());
            ResultSet result = statement.executeQuery();
            while (result.next()){
                aantal = result.getString("aantal");
            }
        }
        catch (SQLException e){
            throw new DbException(e);
        }
        if (Integer.parseInt(aantal) != 0 ){
            throw new DbException("Product already exists");
        }

        sql = "insert into herremanspieter.product(productid, name, description, price) values(?, ?, ?, ?)";
        try {
            Connection connection = DriverManager.getConnection(url, properties);
            PreparedStatement statement = connection.prepareStatement(sql);
            {
                statement.setInt(1, product.getProductId());
                statement.setString(2, product.getName());
                statement.setString(3, product.getDescription());
                statement.setDouble(4, product.getPrice());
                statement.execute();
            }
        }
        catch (SQLException e){
            throw new DbException(e);
        }

    }

    @Override
    public void update(Product product) {
        String sql = "";
        if(product == null){
            throw new DbException("No product given");
        }
        sql ="select count(productid) as aantal from herremanspieter.product where productid = ?";
        String aantal = "";
        try (
                Connection connection = DriverManager.getConnection(url, properties);
                PreparedStatement statement = connection.prepareStatement(sql))
        {
            statement.setInt(1, product.getProductId());
            ResultSet result = statement.executeQuery();
            while (result.next()){
                aantal = result.getString("aantal");
            }
        }
        catch (SQLException e){
            throw new DbException(e);
        }
        if (Integer.parseInt(aantal) == 0 ){
            throw new DbException("No product found");
        }
        sql = "update herremanspieter.product set name = ?, description = ?, price = ? where productid = ?";
        try {
            Connection connection = DriverManager.getConnection(url, properties);
            PreparedStatement statement = connection.prepareStatement(sql);
            {
                statement.setString(1, product.getName());
                statement.setString(2, product.getDescription());
                statement.setDouble(3, product.getPrice());
                statement.setInt(4, product.getProductId());
                statement.executeUpdate();
            }
        }
        catch (SQLException e){
            throw new DbException(e);
        }
    }

    @Override
    public void delete(int id) {
        if(id < 0){
            throw new DbException("No valid id given");
        }
        String sql = "delete from herremanspieter.product where productid = ?";
        try {
            Connection connection = DriverManager.getConnection(url, properties);
            PreparedStatement statement = connection.prepareStatement(sql);
            {
                statement.setInt(1, id);
                statement.executeUpdate();
            }
        }
        catch (SQLException e){
            throw new DbException(e);
        }
    }

    @Override
    public int getNumbeOfProducts() {
        String sql ="select count(productid) as aantal from herremanspieter.product";
        String aantal = "";
        try (
                Connection connection = DriverManager.getConnection(url, properties);
                Statement statement = connection.createStatement()){
            ResultSet result = statement.executeQuery(sql);
            while (result.next()){
                aantal = result.getString("aantal");
            }
        }
        catch (SQLException e){
            throw new DbException(e);
        }
        return Integer.parseInt(aantal);
    }
}
