package domain.model;

import domain.db.PersonDbInMemory;
import domain.db.ProductDbInMemory;

import java.util.List;

public class ShopService {
    private PersonDbInMemory personDb = new PersonDbInMemory();
    private ProductDbInMemory productDB = new ProductDbInMemory();

    public ShopService() {
    }

    public Person getPerson(String personId) {
        return getPersonDb().get(personId);
    }

    public List<Person> getPersons() {
        return getPersonDb().getAll();
    }

    public void addPerson(Person person) {
        getPersonDb().add(person);
    }

    public void updatePersons(Person person) {
        getPersonDb().update(person);
    }

    public void deletePerson(String id) {
        getPersonDb().delete(id);
    }

    private PersonDbInMemory getPersonDb() {
        return personDb;
    }


    public Product getProduct(int productId) {
        return getproductDB().get(productId);
    }

    public List<Product> getProducts() {
        return getproductDB().getAll();
    }

    public void addProduct(Product product) {
        getproductDB().add(product);
    }

    public void updatePruduct(Product product) {
        getproductDB().update(product);
    }

    public void deleteProduct(String id) {
        getproductDB().delete(id);
    }

    private ProductDbInMemory getproductDB() {
        return productDB;
    }

}