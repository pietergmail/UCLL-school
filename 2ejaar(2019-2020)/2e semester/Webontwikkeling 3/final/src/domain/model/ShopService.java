package domain.model;

import domain.db.PersonDb;
import domain.db.PersonDbSql;
import domain.db.ProductDb;
import domain.db.ProductdbSql;

import java.util.List;
import java.util.Properties;

public class ShopService {
    private PersonDb personDb;
    private ProductDb productDB ;

    public ShopService(Properties p) {
        personDb = new PersonDbSql(p);
        productDB = new ProductdbSql(p);
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

    private PersonDb getPersonDb() {
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

    private ProductDb getproductDB() {
        return productDB;
    }

}