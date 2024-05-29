package br.com.opendrive.Drive.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.opendrive.Drive.entity.Pasta;
import br.com.opendrive.Drive.repository.PastaRepository;

@Service
public class PastaService {
	
	@Autowired
	private PastaRepository pastaRepository;


	public Pasta criarPastaRaiz(int criador) {
		Pasta novaPasta = new Pasta();
		novaPasta.setCriador(criador);
		novaPasta.setNome("/");
		
		return pastaRepository.save(novaPasta);
		
	}
	
	public Pasta criarPasta(Pasta novaPasta) {
		
		return pastaRepository.save(novaPasta);
		
	}

	public void novaSubPasta(int pai, int id) {
		Optional<Pasta> optionalPasta = pastaRepository.findById(pai);
		
		Pasta pastaUpdate = optionalPasta.get();
		
		pastaUpdate.addListaPastas(id);
		
		pastaRepository.save(pastaUpdate);		
	}
	
	public List<Pasta> listarPastas(int pai){
		return pastaRepository.findByPai(pai);
		
	}
	
}
