package db;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Person;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class PersonRepositoryStub implements PersonRepository{

    ObjectMapper mapper = new ObjectMapper();

    private ArrayList<Person> persons = new ArrayList<Person>();



    public PersonRepositoryStub () {
        Person test = new Person("test@ucll.be", "test", "testl", new Date(1970, Calendar.AUGUST, 8), "E102", "0497327892");
        Person test2 = new Person("test@ucll.be", "test2", "testl2", new Date(1970, Calendar.AUGUST, 8), "E102", "0497327892");
        Person test3 = new Person("test@ucll.be", "test3", "testl3", new Date(1970, Calendar.AUGUST, 8), "E102", "0497327892");
        Person test4 = new Person("test@ucll.be", "test4", "testl4", new Date(1970, Calendar.AUGUST, 8), "E102", "0497327892");
        Person test5 = new Person("test@ucll.be", "test5", "testl5", new Date(1970, Calendar.AUGUST, 8), "E102", "0497327892");
        persons.add(test);
        persons.add(test2);
        persons.add(test3);
        persons.add(test4);
        persons.add(test5);
    }
    @Override
    public void add(Person person) throws IllegalAccessException {
        for (Person p: persons) {
                if(p == person){
                    throw new IllegalAccessException("person already exists.");
            }
            persons.add(person);
        }
    }

    @Override
    public void delete(String userId) {
        persons.removeIf(p -> p.getUserId().equals(userId));
    }

    @Override
    public Person get(String userId) throws IllegalAccessException {
        for (Person p: persons) {
            if(p.getUserId().equals(userId)){
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

    public String toJson(){
        try {
            final ByteArrayOutputStream out = new ByteArrayOutputStream();
            final ObjectMapper mapper = new ObjectMapper();


            mapper.writeValue(out, persons);

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
