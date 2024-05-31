package br.com.opendrive.Drive.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.opendrive.Drive.entity.Folder;
import br.com.opendrive.Drive.projection.FolderProjection;

public interface FolderRepository extends JpaRepository<Folder, Long> {
	
	// Método para encontrar subpastas de uma pasta pai
	@Query("SELECT f.id as id, f.name as name FROM Folder f WHERE f.parent.id = :parentFolderId")
    List<FolderProjection> findSubfoldersByParentId(@Param("parentFolderId") Long parentFolderId);
	
	// Método para encontrar pastas sem subpastas
    @Query("SELECT f.id as id, f.name as name FROM Folder f WHERE f.parent IS NULL")
    List<FolderProjection> findFoldersWithoutSubfolders();
}
