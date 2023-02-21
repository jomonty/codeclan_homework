package org.codeclan.homework.FilesAndFolders.controllers;

import org.codeclan.homework.FilesAndFolders.models.Folder;
import org.codeclan.homework.FilesAndFolders.repositories.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
