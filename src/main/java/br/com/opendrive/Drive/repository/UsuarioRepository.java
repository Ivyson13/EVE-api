package br.com.opendrive.Drive.repository;

import org.apache.logging.log4j.Logger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.opendrive.Drive.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Logger>{

}
