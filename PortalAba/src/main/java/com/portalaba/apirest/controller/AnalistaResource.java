package com.portalaba.apirest.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.portalaba.apirest.models.Analista;
import com.portalaba.apirest.repository.AnalistaRepository;

@RestController
@RequestMapping(value="/analistas")
public class AnalistaResource {

	@Autowired
	private AnalistaRepository analsitarepository;
	
	@GetMapping
	public List<Analista> listartodos(){
		return analsitarepository.findAll();
	}
	
	@GetMapping("{id}")
	public Analista listar(@PathVariable(value="id")long id) {
		return analsitarepository.findById(id);
	}
	
	@PostMapping
	public Analista salvarCliente (@RequestBody Analista analista) {
		return analsitarepository.save(analista);
	}
	
	@DeleteMapping
	public void deletarCliente (@RequestBody Analista analista) {
		analsitarepository.delete(analista);
	}
	
	@PutMapping
	public Analista atualizaCLiente (@RequestBody Analista analista) {
		return analsitarepository.save(analista);
	}
}
