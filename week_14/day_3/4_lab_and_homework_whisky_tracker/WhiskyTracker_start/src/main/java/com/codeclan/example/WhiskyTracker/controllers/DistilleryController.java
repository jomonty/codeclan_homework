package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DistilleryController {

    @Autowired
    private DistilleryRepository distRepo;

    @GetMapping(value = "/distilleries")
    public ResponseEntity<List<Distillery>> getDistilleries(
            @RequestParam Optional<String> region,
            @RequestParam Optional<Integer> age
    ) {
        return region.map(s -> new ResponseEntity<>(
                distRepo.findByRegionEquals(s),
                HttpStatus.OK)
        ).orElseGet(() -> age.map(integer -> new ResponseEntity<>(
                distRepo.findByWhiskiesAgeEquals(integer),
                HttpStatus.OK)
        ).orElseGet(() -> new ResponseEntity<>(
                distRepo.findAll(),
                HttpStatus.OK
        )));
    }

    @GetMapping(value = "/distilleries/{id}")
    public ResponseEntity<Optional<Distillery>> getSingleDistillery(
            @PathVariable long id
    ) {
        return new ResponseEntity<>(
                distRepo.findById(id),
                HttpStatus.OK
        );
    }

}
