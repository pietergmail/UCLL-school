package main.java.db;

import com.fasterxml.jackson.core.JsonProcessingException;
import main.java.domain.Person;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.*;

public class PersonRepositoryStub implements PersonRepository {

    ObjectMapper mapper = new ObjectMapper();
    private ArrayList<Person> persons = new ArrayList<Person>();

    public PersonRepositoryStub () {
        Person test = new Person("test@ucll.be", "test", "testl", "1970/07/08", "E102", "0497327862");
        Person test2 = new Person("test@ucll.be", "test2", "testl2", "1970/07/08", "E102", "0497357892");
        Person test3 = new Person("test@ucll.be", "test3", "testl3", "1971/07/08", "E103", "0497327892");
        Person test4 = new Person("test@ucll.be", "test4", "testl4", "1972/07/08", "E102", "0497325892");
        Person test5 = new Person("test@ucll.be", "test5", "testl5", "1973/07/08", "E103", "0497327892");
        Person t = new Person("t","t","t","t","t", "t");
        persons.add(test);
        persons.add(test2);
        persons.add(test3);
        persons.add(test4);
        persons.add(test5);
        persons.add(t);
    }
    @Override
    public void add(Person person) throws IllegalAccessException {
        for (Person p: persons) {
                if(p == person){
                    throw new IllegalAccessException("person already exists.");
            }
        }
        persons.add(person);
    }

    @Override
    public void delete(String email) {
        persons.removeIf(p -> p.getEmail().equals(email));
    }

    @Override
    public Person get(String email) throws IllegalAccessException {
        for (Person p: persons) {
            if(p.getEmail().equals(email)){
                return p;
            }
        }
        throw new IllegalAccessException("No person found.");
    }

    @Override
    public ArrayList<Person> getAll() {
        return persons;
    }

    public ArrayList<Person> search(String Date, String Room) throws IllegalAccessException {
        ArrayList<Person> ret = new ArrayList<Person>();

        for (Person p: persons) {
            if(p.getDate().equals(Date) && p.getRoom().equals(Room)){
                ret.add(p);
            }
        }
        if(ret.isEmpty()){
            throw new IllegalAccessException("No matches found.");
        }else{
            return ret;
        }
    }

    public String toJson(ArrayList<Person> people){
        try {
            final ByteArrayOutputStream out = new ByteArrayOutputStream();
            final ObjectMapper mapper = new ObjectMapper();


            mapper.writeValue(out, people);

            final byte[] data = out.toByteArray();
            return new String(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public void update(Person person) {
        //not yet implemented
    }
}
