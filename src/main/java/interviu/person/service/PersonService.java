package interviu.person.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import interviu.person.entity.Person;
import interviu.person.exception.PersonNotFoundException;
import interviu.person.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository repository;


	public List<Person> findAll() {

		return repository.findAll();
	}


	public Person findOne(Integer id) {

		return repository.findById(id).orElseThrow(() -> new PersonNotFoundException("person not found with id: " + id));
	}


	public Person update(Person personRequest, Integer id) {

		Person newPerson = repository.findById(id).orElseThrow(() -> new PersonNotFoundException("person not found with id: " + id));

        newPerson.setEmployed(personRequest.isEmployed());
        newPerson.setMobile(personRequest.getMobile());
        newPerson.setName(personRequest.getName());

        return repository.save(newPerson);
	}


	public Person create(Person personRequest) {

		return repository.save(personRequest);

	}


	public void delete(Integer id) {

		Person person = repository.findById(id).orElseThrow(() -> new PersonNotFoundException("person not found with id: " + id));

		repository.delete(person);
	}


	public void deleteAll() {

        repository.deleteAll();

	}
}
