package ec.tcs.springcrud.services;

import ec.tcs.springcrud.entities.Person;

import java.util.List;

public interface PersonService {
    public List<Person> listPeople();

    public void save(Person person);

    public void delete(Person person);

    public Person findPerson(Person person);

}
