package interviu.person.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import interviu.person.entity.Person;

@Repository
public interface PersonRepo extends JpaRepository<Person,Integer> {

}
