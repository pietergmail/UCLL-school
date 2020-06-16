package domain.db;

import domain.model.Product;

import java.util.List;

public interface ProductRepository {
    /**
     * Returns product with given name
     * @trows IllegalArgumentException if the given name is not effective of empty
     * @return the product with given name, if it exists
     * @return null if no product with given name is found
     */
    Product get(String name);

    /**
     * Returns a list with all products
     */
    List<Product> getAll();

    /**
     * Sorts products on price
     */
    List<Product> sortProducts();

    /**
     * Gives list of all vegetarian products
     */
    List<Product> getAllVegetarianProducts();

    /**
     * Gives list of all non-vegetarian products
     */
    List<Product> getAllNonVegetarianProducts();
}
