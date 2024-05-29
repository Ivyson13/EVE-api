package br.com.opendrive.Drive.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.opendrive.Drive.entity.Folder;

public interface FolderRepository extends JpaRepository<Folder, Long> {
}
