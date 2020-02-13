package domain.db;

import domain.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductDbInMemory {
    private Map<Integer, Product> records = new HashMap<>();
    private int recordedProducts = 0;

    public ProductDbInMemory() {
        Product rose = new Product("Rose", "Thorny plant", 2.25);
        add(rose);
        Product aster = new Product("Aster", "Daisy-like perennials", 1.18);
        add(aster);
        Product daisy = new Product("Daisy","Composed of white petals", 0.50);
        add (daisy);
        Product lavender = new Product("Lavender", "Decorates landscapes", 3.50);
        add(lavender);
    }

    public Product get(int id) {
        if (id < 0 || id > recordedProducts) {
            throw new DbException("No valid id given");
        }
        return records.get(id);
    }

    public List<Product> getAll() {
        return new ArrayList<Product>(records.values());
    }

    public void add(Product product) {
        if (product == null) {
            throw new DbException("No product given");
        }
        int id = recordedProducts + 1;
        product.setProductId(id);
        if (records.containsKey(product.getProductId())) {
            throw new DbException("Product already exists");
        }
        recordedProducts++;
        records.put(product.getProductId(), product);
    }

    public void update(Product product) {
        if (product == null) {
            throw new DbException("No product given");
        }
        if (!records.containsKey(product.getProductId())) {
            throw new DbException("No product found");
        }
        records.put(product.getProductId(), product);
    }

    public void delete(int id) {
        if (id < 0 || id > recordedProducts) {
            throw new DbException("No valid id given");
        }
        records.remove(id);
    }

    public int getNumberOfProducts() {
        return records.size();
    }
}
