package domain.db;

import domain.model.Person;
import domain.model.Product;

import java.util.List;

public interface PersonDb {
    Person get(String personId) ;

    List<Person> getAll() ;

    void add(Person person) ;

    void update(Person person);

    void delete(String personId);

    int getNumberOfPersons();
}
