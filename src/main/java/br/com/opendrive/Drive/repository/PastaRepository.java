package br.com.opendrive.Drive.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.opendrive.Drive.entity.Pasta;

@Repository
public interface PastaRepository extends JpaRepository<Pasta, Integer>{

	
	 //@Query("SELECT e FROM pasta e WHERE e.pai = :pai")
	 //List<Pasta> findByPai(@Param("pai") int pai); 
	 
	 List<Pasta> findByPai(int pai);
	
}
