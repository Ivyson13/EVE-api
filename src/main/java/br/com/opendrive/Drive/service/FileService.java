package br.com.opendrive.Drive.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.opendrive.Drive.entity.File;
import br.com.opendrive.Drive.entity.Folder;
import br.com.opendrive.Drive.repository.FileRepository;
import br.com.opendrive.Drive.repository.FolderRepository;
import jakarta.transaction.Transactional;

@Service
public class FileService {

    @Autowired
    private FileRepository fileRepository;

    @Autowired
    private FolderRepository folderRepository;

    public File createFile(String name, String content, Long folderId) {
        File file = new File();
        file.setName(name);
        file.setContent(content);

        Folder folder = folderRepository.findById(folderId).orElseThrow();
        file.setFolder(folder);

        return fileRepository.save(file);
    }

    public List<File> getFilesByFolder(Long folderId) {
        Folder folder = folderRepository.findById(folderId).orElseThrow();
        return folder.getFiles();
    }

    @Transactional
    public void deleteFile(Long fileId) {
        File file = fileRepository.findById(fileId).orElseThrow(() -> new RuntimeException("File not found"));
        fileRepository.delete(file);
    }
    
    @Transactional
    public File renameFile(Long fileId, String newName) {
        File file = fileRepository.findById(fileId).orElseThrow(() -> new RuntimeException("File not found"));
        file.setName(newName);
        return fileRepository.save(file);
    }
}
