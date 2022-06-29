package ec.tcs.springcrud.dao;

import ec.tcs.springcrud.entities.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonDao extends CrudRepository<Person, Long> {

}
