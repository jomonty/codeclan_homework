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
        List<Whisky> whiskies = new ArrayList<>();
        if (allParams.size() == 0) {
            whiskies = whiskyRepo.findAll();
        } else if (allParams.size() == 1 && allParams.containsKey("year")) {
            whiskies = whiskyRepo.findByYearEquals(Integer.parseInt(allParams.get("year")));
        } else if (allParams.size() == 1 && allParams.containsKey("distilleryRegion")) {
            whiskies = whiskyRepo.findByDistilleryRegion(allParams.get("distilleryRegion"));
        } else if (allParams.size() == 2 && allParams.containsKey("distilleryName") && allParams.containsKey("age")) {
            whiskies = whiskyRepo.findByAgeAndDistilleryName(
                    Integer.parseInt(allParams.get("age")),
                    allParams.get("distilleryName")
            );
        }
        return new ResponseEntity<>(
                whiskies,
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
