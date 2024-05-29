package br.com.opendrive.Drive.repository;

import org.apache.logging.log4j.Logger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.opendrive.Drive.entity.Arquivo;

@Repository
public interface ArquivoRepository extends JpaRepository<Arquivo, Logger> {

}
