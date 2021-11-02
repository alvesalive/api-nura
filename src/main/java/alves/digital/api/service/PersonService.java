package alves.digital.api.service;

import alves.digital.api.dto.response.MessageResponseDTO;
import alves.digital.api.entity.Person;
import alves.digital.api.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service //spring manager class responsible to all rules of biz
public class PersonService {


    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    //rule of creation
    public MessageResponseDTO createPerson(Person person) {
        Person savedPerson = personRepository.save(person);
        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + savedPerson.getId())
                .build();
    }



}
