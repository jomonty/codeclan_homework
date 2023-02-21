package org.codeclan.homework.FilesAndFolders.components;

import org.codeclan.homework.FilesAndFolders.models.File;
import org.codeclan.homework.FilesAndFolders.models.Folder;
import org.codeclan.homework.FilesAndFolders.models.Person;
import org.codeclan.homework.FilesAndFolders.repositories.FileRepository;
import org.codeclan.homework.FilesAndFolders.repositories.FolderRepository;
import org.codeclan.homework.FilesAndFolders.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("!test")
@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    FileRepository fileRepo;
    @Autowired
    FolderRepository folderRepo;
    @Autowired
    PersonRepository personRepo;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        fileRepo.deleteAll();
        folderRepo.deleteAll();
        personRepo.deleteAll();

        Person josh = new Person("Josh");
        Person kelsie = new Person("Kelsie");
        Person james = new Person("James");
        personRepo.save(josh);
        personRepo.save(kelsie);
        personRepo.save(james);

        Folder jo_f_1 = new Folder("Josh Folder One", josh);
        Folder jo_f_2 = new Folder("Josh Folder Two", josh);
        Folder ke_f_1 = new Folder("Kelsie Folder One", kelsie);
        Folder ke_f_2 = new Folder("Kelsie Folder Two", kelsie);
        Folder ja_f_1 = new Folder("James Folder One", james);
        folderRepo.save(jo_f_1);
        folderRepo.save(jo_f_2);
        folderRepo.save(ke_f_1);
        folderRepo.save(ke_f_2);
        folderRepo.save(ja_f_1);

        for (Folder folder : folderRepo.findAll()) {
            for (int i=0; i<3; i++) {
                File file = new File(
                        String.format("%s, %s File %s", folder.getPerson().getName(), folder.getTitle(), i),
                        "txt",
                        (i + 3) * 4,
                        folder
                );
                fileRepo.save(file);
            }
        }

    }
}
