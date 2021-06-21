package restful.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import restful.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
