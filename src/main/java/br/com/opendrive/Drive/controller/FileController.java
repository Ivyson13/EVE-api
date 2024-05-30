package br.com.opendrive.Drive.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.opendrive.Drive.entity.File;
import br.com.opendrive.Drive.service.FileService;

@RestController
@RequestMapping("/files")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping
    public File createFile(@RequestParam String name, @RequestParam String content, @RequestParam Long folderId) {
        return fileService.createFile(name, content, folderId);
    }

    @GetMapping("/folder/{folderId}")
    public List<File> getFilesByFolder(@PathVariable Long folderId) {
        return fileService.getFilesByFolder(folderId);
    }

    @DeleteMapping("/{id}")
    public void deleteFile(@PathVariable Long id) {
        fileService.deleteFile(id);
    }
    
    @PutMapping("/{id}/rename")
    public File renameFile(@PathVariable Long id, @RequestParam String newName) {
        return fileService.renameFile(id, newName);
    }
    
}
