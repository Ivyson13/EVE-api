package br.com.opendrive.Drive.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.opendrive.Drive.entity.Folder;
import br.com.opendrive.Drive.service.FolderService;

@CrossOrigin
@RestController
@RequestMapping("/folders")
public class FolderController {

	@Autowired
	private FolderService folderService;

	@PostMapping
	public Folder createFolder(@RequestParam String name, @RequestParam(required = false) Long parentId) {
		return folderService.createFolder(name, parentId);
	}

	@GetMapping
	public List<Folder> getAllFolders() {
		return folderService.getAllFolders();
	}

	@DeleteMapping("/{id}")
	public void deleteFolder(@PathVariable Long id) {
		folderService.deleteFolder(id);
	}

	@PutMapping("/{id}/rename")
	public Folder renameFolder(@PathVariable Long id, @RequestParam String newName) {
		return folderService.renameFolder(id, newName);
	}
	
	// Endpoint para listar subpastas
    @GetMapping("/{parentFolderId}/subfolders")
    public ResponseEntity<List<Folder>> listSubfolders(@PathVariable Long parentFolderId) {
        List<Folder> subfolders = folderService.listSubfolders(parentFolderId);
        return ResponseEntity.ok(subfolders);
    }
}