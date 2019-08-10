package interviu.person.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import interviu.person.entity.Person;
import interviu.person.service.PersonService;

@RestController
@RequestMapping("/api")
public class PersonController {
	
	@Autowired
	PersonService service;
	
	
	@GetMapping("/persons")
	public List<Person> getAll(){
		
		return service.findAll();
	}
	
	@GetMapping("/person/{id}")
	public Person getPersonById(@PathVariable(name="id") Integer id) {

		return service.findById(id);
	}
	
	@PostMapping("/persons")
	public Person savePerson(@RequestBody Person p) {
		
		return service.createPerson(p);
	}
	
	@PutMapping("/person/{id}")
	public Person update(@PathVariable(name="id") Integer id, @RequestBody Person p) {
		
		return service.updatePerson(id,p);
		
	}
	
	@DeleteMapping("/person/{id}")
	public void deleteById(@PathVariable(name="id") Integer id) {
		
		service.deletePersonById(id);
		
	}
	
	@DeleteMapping("/persons")
	public void deleteAllPersons() {
		
		service.deleteAll();
	}
}
