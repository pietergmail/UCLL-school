package domain.service;

import domain.db.*;
import domain.model.Person;
import domain.model.Product;

import java.util.List;
import java.util.Properties;

public class ShopService {
    private PersonDb personDb;
    private ProductDb productDb;

    public ShopService(Properties properties) {
        personDb = new PersonDbSql(properties);
        productDb = new ProductDbSql(properties);
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

    public Product getProduct(int id){
        return productDb.get(id);
    }

    public List<Product> getProducts(){
        return productDb.getAll();
    }

    public void addProduct(Product product){
        productDb.add(product);
    }

    public void updateProduct(Product product){
        productDb.update(product);
    }

    public void deleteProduct(int id){
        productDb.delete(id);
    }
}
