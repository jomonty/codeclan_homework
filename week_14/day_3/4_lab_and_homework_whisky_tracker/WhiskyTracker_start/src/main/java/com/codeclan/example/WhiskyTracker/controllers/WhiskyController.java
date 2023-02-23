package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class WhiskyController {

    @Autowired
    private WhiskyRepository whiskyRepo;

    @GetMapping(value = "/whiskies")
    public ResponseEntity<List<Whisky>> getWhiskies(
            @RequestParam Map<String, String> allParams
            ) {

        // If the query params are only year
        if (allParams.size() == 1 && allParams.containsKey("year")) {
            return new ResponseEntity<>(
                    whiskyRepo.findByYearEquals(Integer.parseInt(allParams.get("year"))),
                    HttpStatus.OK
            );
        }
        // If the query params are only Distillery Region
        if (allParams.size() == 1 && allParams.containsKey("distilleryRegion")) {
            return new ResponseEntity<>(
                    whiskyRepo.findByDistilleryRegion(allParams.get("distilleryRegion")),
                    HttpStatus.OK
            );
        }
        // If the query params are distillery name and age
        if (allParams.size() == 2 && allParams.containsKey("distilleryName") && allParams.containsKey("age")) {
            return new ResponseEntity<>(
                    whiskyRepo.findByAgeAndDistilleryName(
                            Integer.parseInt(allParams.get("age")),
                            allParams.get("distilleryName")
                    ),
                    HttpStatus.OK
            );
        }
        // If we have no query params, return all results
        return new ResponseEntity<>(
                whiskyRepo.findAll(),
                HttpStatus.OK
        );
    }

    @GetMapping(value = "/whiskies/{id}")
    public ResponseEntity<Optional<Whisky>> getSingleWhisky(
            @PathVariable long id
    ) {
        return new ResponseEntity<>(
                whiskyRepo.findById(id),
                HttpStatus.OK
        );
    }

}
