package br.com.opendrive.Drive.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.opendrive.Drive.entity.Pasta;
import br.com.opendrive.Drive.service.PastaService;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/pasta")
public class PasstaController {

	@Autowired
	private PastaService pastaService;
		
	@PostMapping("/novoUsuario") // na criação de um usiario deve-se criar sua pasta raiz, passando seu criador
	public ResponseEntity<Pasta> criarPastaRaiz(@RequestBody int criador){
		Pasta p = pastaService.criarPastaRaiz(criador);
		return  new ResponseEntity<Pasta>(p, HttpStatus.CREATED);
		
	}
	
	@PostMapping("/nova-sub-pasta")
	public ResponseEntity<Pasta> criarSubPasta(@RequestBody Pasta novaPasta){
		Pasta p = pastaService.criarPasta(novaPasta);
		pastaService.novaSubPasta(p.getPai(), p.getId());
		
		return new ResponseEntity<Pasta>(p, HttpStatus.CREATED);
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<List<Pasta>> listarSubPastas(@PathVariable("id") int pai){
		
		List<Pasta> p = pastaService.listarPastas(pai);
		
		return new ResponseEntity<>(p, HttpStatus.OK);
		
	}
	
	
	
}
