package br.com.opendrive.Drive.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.opendrive.Drive.entity.Folder;
import br.com.opendrive.Drive.repository.FolderRepository;

@Service
public class FolderService {

    @Autowired
    private FolderRepository folderRepository;

    public Folder createFolder(String name, Long parentId) {
        Folder folder = new Folder();
        folder.setName(name);

        if (parentId != null) {
            Folder parent = folderRepository.findById(parentId).orElseThrow();
            folder.setParent(parent);
        }

        return folderRepository.save(folder);
    }

    public List<Folder> getAllFolders() {
        return folderRepository.findAll();
    }

    // Other CRUD operations
}
