package domain.db;

import domain.model.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonDbInMemory implements PersonDb {
	private Map<String, Person> persons = new HashMap<>();
	
	public PersonDbInMemory () {
		Person administrator = new Person("admin", "admin@ucll.be", "t", "Ad", "Ministrator","Admin");
		add(administrator);
	}

	/*public Person getUserIfAuthenticated(String name, String password){
		Person person = findPerson(name);
		if (person != null && person.isPasswordCorrect(password)){
			return Person;
		}
		return null;
	}*/
	
	@Override
	public Person get(String personId){
		if(personId == null){
			throw new DbException("No id given");
		}
		return persons.get(personId);
	}
	
	@Override
	public List<Person> getAll(){
		return new ArrayList<Person>(persons.values());	
	}

	@Override
	public void add(Person person){

		if(person == null){
			throw new DbException("No person given");
		}
		if (persons.containsKey(person.getUserid())) {
			throw new DbException("User already exists");
		}
		persons.put(person.getUserid(), person);
	}
	
	@Override
	public void update(Person person){
		if(person == null){
			throw new DbException("No person given");
		}
		if(!persons.containsKey(person.getUserid())){
			throw new DbException("No person found");
		}
		persons.put(person.getUserid(), person);
	}
	
	@Override
	public void delete(String personId){
		if(personId == null){
			throw new DbException("No id given");
		}
		persons.remove(personId);
	}

	@Override
	public int getNumberOfPersons() {
		return persons.size();
	}

}
