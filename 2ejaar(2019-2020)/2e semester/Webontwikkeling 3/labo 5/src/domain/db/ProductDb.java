package domain.db;

import domain.model.Product;

import java.util.List;

public interface ProductDb {
    Product get(int id);

    List<Product> getAll();

    void add(Product product);

    void update(Product product);

    void delete(int id);

    int getNumbeOfProducts();
}
