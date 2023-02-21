package org.codeclan.homework.FilesAndFolders.controllers;

import org.codeclan.homework.FilesAndFolders.models.Person;
import org.codeclan.homework.FilesAndFolders.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonContoller {
    @Autowired
    PersonRepository personRepo;

    @GetMapping(value = "/persons")
    public ResponseEntity<List<Person>> getAllPersons() {
        return new ResponseEntity<>(
                personRepo.findAll(),
                HttpStatus.OK
        );
    }
}
