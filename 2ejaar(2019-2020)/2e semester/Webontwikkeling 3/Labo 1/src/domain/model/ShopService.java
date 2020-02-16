package domain.model;

import domain.db.PersonDbInMemory;

import java.util.List;

public class ShopService {
    private PersonDbInMemory personDb = new PersonDbInMemory();

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
}
