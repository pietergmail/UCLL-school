package db;

import domain.Person;

import java.util.ArrayList;

public interface PersonRepository {

    public abstract void add(Person person) throws IllegalAccessException;

    public abstract void delete(String userId);

    public abstract Person get(String userId) throws IllegalAccessException;

    public abstract ArrayList<Person> getAll();

    public abstract void update(Person person);
}
