package org.codeclan.homework.FilesAndFolders.controllers;

import org.codeclan.homework.FilesAndFolders.models.Folder;
import org.codeclan.homework.FilesAndFolders.repositories.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FolderController {
    @Autowired
    FolderRepository folderRepo;

    @GetMapping(value = "/folders")
    public ResponseEntity<List<Folder>> getAllFolders() {
        return new ResponseEntity<>(
                folderRepo.findAll(),
                HttpStatus.OK
        );
    }

    @GetMapping(value = "/folders/{id}")
    public ResponseEntity<Optional<Folder>> getOneFolder(@PathVariable Long id) {
        return new ResponseEntity<>(
                folderRepo.findById(id),
                HttpStatus.OK
        );
    }

    @PostMapping(value = "/folders")
    public ResponseEntity<Folder> createOneFolder(@RequestBody Folder folder) {
        folderRepo.save(folder);
        return new ResponseEntity<>(
                folder,
                HttpStatus.CREATED
        );
    }
}
