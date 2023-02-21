package org.codeclan.homework.FilesAndFolders.repositories;

import org.codeclan.homework.FilesAndFolders.models.Folder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FolderRepository extends JpaRepository<Folder, Long> {
}
