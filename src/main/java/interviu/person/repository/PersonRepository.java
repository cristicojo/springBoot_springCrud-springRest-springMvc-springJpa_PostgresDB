package interviu.person.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import interviu.person.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person,Integer> {

}
