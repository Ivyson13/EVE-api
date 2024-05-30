package br.com.opendrive.Drive.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.opendrive.Drive.entity.Folder;

public interface FolderRepository extends JpaRepository<Folder, Long> {
	
	@Query("SELECT f FROM Folder f WHERE f.parent.id = :parentFolderId")
    List<Folder> findSubfoldersByParentId(@Param("parentFolderId") Long parentFolderId);
}
