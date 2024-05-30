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
public class FolderService {

	@Autowired
	private FolderRepository folderRepository;

	@Autowired
	private FileRepository fileRepository;

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

	@Transactional
	public void deleteFolder(Long folderId) {
		Folder folder = folderRepository.findById(folderId).orElseThrow();
		deleteRecursively(folder);
	}

	private void deleteRecursively(Folder folder) {
		// Delete files in the folder
		List<File> files = folder.getFiles();
		for (File file : files) {
			fileRepository.delete(file);
		}

		// Delete subfolders recursively
		if (folder.getSubfolders() != null) {
			for (Folder subfolder : folder.getSubfolders()) {
				deleteRecursively(subfolder);
			}
		}

		// Delete the folder itself
		folderRepository.delete(folder);
	}

	@Transactional
	public Folder renameFolder(Long folderId, String newName) {
		Folder folder = folderRepository.findById(folderId).orElseThrow(() -> new RuntimeException("Folder not found"));
		folder.setName(newName);
		return folderRepository.save(folder);
	}
	
	public List<Folder> listSubfolders(Long parentFolderId) {
        return folderRepository.findSubfoldersByParentId(parentFolderId);
    }

}