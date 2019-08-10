package interviu.person.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import interviu.person.entity.Person;
import interviu.person.exception.PersonNotFoundException;
import interviu.person.repository.PersonRepo;

@Service
public class PersonService {

    @Autowired
    PersonRepo repo;

    public List<Person> findAll() {

        return repo.findAll();
    }

    public Person findById(int id) {

        Optional<Person> optional = repo.findById(id);
        
        return optional.orElseThrow(() -> new PersonNotFoundException("Could not found a Person with id " + id));
    	
    }


    public Person createPerson(Person p) {

        return repo.save(p);
    }


    public Person updatePerson(int id, Person newP) {

        Optional<Person> optional = repo.findById(id);

        Person p;
        
        if (!(optional.isPresent())) {
            throw new PersonNotFoundException("Could not found a Person with id " + id);

        } 
        
        else {
            p = optional.get();
            p.setEmployed(newP.isEmployed());
            p.setName(newP.getName());
            p.setMobile(newP.getMobile());
        }

        return repo.save(p);

    }
    
    public void deletePersonById(int id) {
    	
        Optional<Person> optional = repo.findById(id);
        
        if (!(optional.isPresent())) {
            throw new PersonNotFoundException("Could not found a Person with id " + id);
        }
        
        else {
        	   repo.delete(optional.get());
				
			}
    }
        
        public void deleteAll() {
        	
        	repo.deleteAll();
        	
        }
}
