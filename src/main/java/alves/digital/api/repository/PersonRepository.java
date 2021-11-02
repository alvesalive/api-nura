package alves.digital.api.repository;

import alves.digital.api.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

//generics to Class Person e type of data ID (long)
public interface PersonRepository extends JpaRepository<Person, Long> {
}
