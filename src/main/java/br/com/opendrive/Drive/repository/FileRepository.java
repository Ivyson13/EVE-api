package br.com.opendrive.Drive.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.opendrive.Drive.entity.File;

public interface FileRepository extends JpaRepository<File, Long> {
}
