package netology.springbootjavahibernate.persons.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import netology.springbootjavahibernate.persons.repository.PersonEntity;
import netology.springbootjavahibernate.persons.repository.PersonRepository;

@RestController
@RequestMapping("/")
public class PersonController {
    @Autowired
    private PersonRepository personRepository;

    @GetMapping("persons")
    public ResponseEntity<List<PersonEntity>> getAllPersons() {
        List<PersonEntity> persons = personRepository.findAll();

        return new ResponseEntity<>(persons, HttpStatus.OK);
    }

    @PostMapping("persons/create")
    public ResponseEntity<PersonEntity> create(@Valid @RequestBody PersonEntity person) {
        var entity = new PersonEntity();

        entity.setName(person.getName());
        entity.setSurname(person.getSurname());
        entity.setAge(person.getAge());
        entity.setCityOfLiving(person.getCityOfLiving());
        entity.setPhoneNumber(person.getPhoneNumber());

        PersonEntity personEntity = personRepository.save(entity);

        return new ResponseEntity<>(personEntity, HttpStatus.OK);
    }

    @PostMapping("persons/update")
    public ResponseEntity<PersonEntity> update(
            @Valid String name,
            @Valid String surname,
            @Valid Integer age,
            @Valid @RequestBody PersonEntity person
    ) {
        var entity = this.personRepository.getFirstPersonByNameAndSurnameAndAge(name, surname, age);

        entity.setCityOfLiving(person.getCityOfLiving());
        entity.setPhoneNumber(person.getPhoneNumber());

        PersonEntity personEntity = personRepository.save(entity);

        return new ResponseEntity<>(personEntity, HttpStatus.OK);
    }

    @DeleteMapping("persons/delete")
    public ResponseEntity<List<PersonEntity>> delete(
            @Valid String name,
            @Valid String surname,
            @Valid Integer age
    ) {
        var entity = this.personRepository.getFirstPersonByNameAndSurnameAndAge(name, surname, age);

        personRepository.delete(entity);

        List<PersonEntity> persons = personRepository.findAll();

        return new ResponseEntity<>(persons, HttpStatus.OK);
    }

    @GetMapping("persons/find-by-city")
    public ResponseEntity<List<PersonEntity>> findByCity(@Valid String city) {
        List<PersonEntity> persons = personRepository.getPersonsByCity(city).stream().toList();

        return new ResponseEntity<>(persons, HttpStatus.OK);
    }

    @GetMapping("persons/find-by-age")
    public ResponseEntity<List<PersonEntity>> findByAge(@Valid Integer age) {
        List<PersonEntity> persons = personRepository.getPersonsByAgeLessThan(age).stream().toList();

        return new ResponseEntity<>(persons, HttpStatus.OK);
    }

    @GetMapping("persons/find-by-name-and-surname")
    public ResponseEntity<List<PersonEntity>> findByNameAndSurname(@Valid String name, @Valid String surname) {
        List<PersonEntity> persons = personRepository.getFirstPersonByNameAndSurname(name, surname).stream().toList();

        return new ResponseEntity<>(persons, HttpStatus.OK);
    }
}
