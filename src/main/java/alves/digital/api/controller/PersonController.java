package alves.digital.api.controller;

import alves.digital.api.dto.response.MessageResponseDTO;
import alves.digital.api.entity.Person;
import alves.digital.api.repository.PersonRepository;
import alves.digital.api.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {


    //inject class PersonRepository
   /* Refactor to Service
    private PersonRepository personRepository;

    @Autowired //Spring inject one implementation of type Repository here (on constructor or attribute or get/set)
    //on construct is easy to create  unity test, why frequently use mock of class
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }*/

    // Inject dependecy of class PersonService
    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) //code return 201
    //for verbs of type Post, need send a body of requisition
    public MessageResponseDTO createPerson(@RequestBody Person person) {

        //refactor to service
        /*Person savedPerson = personRepository.save(person);
        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + savedPerson.getId())
                .build();*/

        return personService.createPerson(person);
    }
}
