package org.codeclan.homework.FilesAndFolders.controllers;

import org.codeclan.homework.FilesAndFolders.models.File;
import org.codeclan.homework.FilesAndFolders.repositories.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
