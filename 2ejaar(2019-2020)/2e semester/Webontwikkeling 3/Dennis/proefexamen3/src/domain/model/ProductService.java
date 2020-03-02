package domain.model;

import domain.db.ProductRepository;
import domain.db.ProductRepositorySQL;
import domain.model.Product;

import java.util.List;
import java.util.Properties;

public class ProductService {
    private ProductRepository productRepository;

    public ProductService(Properties properties) {
        this.productRepository = new ProductRepositorySQL(properties);
    }

    /**
     * Returns product with given name
     *
     * @return null if no product with given name is found
     * @trows IllegalArgumentException if the given name is not effective of empty
     */
    public Product get(String name) {
        return productRepository.get(name);
    }

    ;

    /**
     * Returns a list with all products
     */
    public List<Product> getAll() {
        return productRepository.getAll();
    }

    /**
     * Sorts products on price
     */
    public List<Product> sortProducts() {
        return productRepository.sortProducts();
    }

    /**
     * Gives list of vegetarian products
     */
    public List<Product> allVegetarianProducts() {
        return productRepository.getAllVegetarianProducts();
    }

    /**
     * Gives list of all non-vegetarian products
     */
    public List<Product> allNonVegetarianProducts() {
        return productRepository.getAllNonVegetarianProducts();
    }
}
