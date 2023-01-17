package interviu.person.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import interviu.person.entity.Person;
import interviu.person.service.PersonService;

@RestController
@RequestMapping("/rest")
public class PersonController {
	
	@Autowired
	private PersonService service;
	
	
	@GetMapping("/all")
	public List<Person> getAll(){
		
		return service.findAll();
	}
	
	@GetMapping("/person/{id}")
	public Person getPersonById(@PathVariable(name="id") Integer id) {

		return service.findOne(id);
	}
	
	@PostMapping("/person")
	public Person savePerson(@RequestBody Person p) {
		
		return service.create(p);
	}
	
	@PutMapping("/person/{id}")
	public Person update(@PathVariable(name="id") Integer id, @RequestBody Person p) {
		
		return service.update(p, id);
		
	}
	
	@DeleteMapping("/person/{id}")
	public void deleteById(@PathVariable(name="id") Integer id) {
		
		service.delete(id);
		
	}
	
	@DeleteMapping("/all")
	public void deleteAllPersons() {
		
		service.deleteAll();
	}


	@PatchMapping("/person/{id}/{name}")
	public Person updatePartially(@PathVariable Integer id, @PathVariable String name) {

		return service.partialUpdate(id, name);
	}
}
