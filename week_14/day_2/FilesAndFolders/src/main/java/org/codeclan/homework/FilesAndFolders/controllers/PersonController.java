package org.codeclan.homework.FilesAndFolders.controllers;

import org.codeclan.homework.FilesAndFolders.models.Person;
import org.codeclan.homework.FilesAndFolders.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {
    @Autowired
    PersonRepository personRepo;

    @GetMapping(value = "/persons")
    public ResponseEntity<List<Person>> getAllPersons() {
        return new ResponseEntity<>(
                personRepo.findAll(),
                HttpStatus.OK
        );
    }

    @GetMapping(value = "/persons/{id}")
    public ResponseEntity<Optional<Person>> getOnePerson(@PathVariable Long id) {
        return new ResponseEntity<>(
                personRepo.findById(id),
                HttpStatus.OK
        );
    }

    @PostMapping(value = "/persons")
    public ResponseEntity<Person> createOnePerson(@RequestBody Person person) {
        personRepo.save(person);
        return new ResponseEntity<>(
                person,
                HttpStatus.CREATED
        );
    }
}
