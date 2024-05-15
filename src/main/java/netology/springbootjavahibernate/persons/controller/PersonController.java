package netology.springbootjavahibernate.persons.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import netology.springbootjavahibernate.persons.repository.PersonEntity;
import netology.springbootjavahibernate.persons.repository.PersonRepository;

@RestController
@RequestMapping("/")
public class PersonController {
    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("persons")
    public ResponseEntity<List<PersonEntity>> getAllPersons() {
        List<PersonEntity> persons = personRepository.findAll();

        return new ResponseEntity<>(persons, HttpStatus.OK);
    }

    @GetMapping("persons/find-by-city")
    public ResponseEntity<List<PersonEntity>> getCustomerProducts(@Valid String city) {
        List<PersonEntity> persons = personRepository.getPersonsByCity(city).stream().toList();

        return new ResponseEntity<>(persons, HttpStatus.OK);
    }
}
