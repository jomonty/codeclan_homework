package org.codeclan.homework.FilesAndFolders.controllers;

import org.codeclan.homework.FilesAndFolders.models.File;
import org.codeclan.homework.FilesAndFolders.repositories.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FileController {
    @Autowired
    FileRepository fileRepo;

    @GetMapping(value = "/files")
    public ResponseEntity<List<File>> getAllFiles() {
        return new ResponseEntity<>(
                fileRepo.findAll(),
                HttpStatus.OK
        );
    }

    @GetMapping(value = "/files/{id}")
    public ResponseEntity<Optional<File>> getOneFile(@PathVariable Long id) {
        return new ResponseEntity<>(
                fileRepo.findById(id),
                HttpStatus.OK
        );
    }

    @PostMapping(value = "/files")
    public ResponseEntity<File> createOneFile(@RequestBody File file) {
        fileRepo.save(file);
        return new ResponseEntity<>(
                file,
                HttpStatus.CREATED
        );
    }
}
