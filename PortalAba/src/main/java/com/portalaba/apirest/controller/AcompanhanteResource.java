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
import com.portalaba.apirest.models.Acompanhante;
import com.portalaba.apirest.repository.AcompanhanteRepository;

@RestController
@RequestMapping(value="/acompanhantes")
public class AcompanhanteResource {

	@Autowired
	private AcompanhanteRepository acompanhanterepository;
	
	@GetMapping
	public List<Acompanhante> listartodos(){
		return acompanhanterepository.findAll();
	}
	
	@GetMapping("{id}")
	public Acompanhante listar(@PathVariable(value="id")long id) {
		return acompanhanterepository.findById(id);
	}
	
	@PostMapping
	public Acompanhante salvarCliente (@RequestBody Acompanhante acompanhante) {
		return acompanhanterepository.save(acompanhante);
	}
	
	@DeleteMapping
	public void deletarCliente (@RequestBody Acompanhante acompanhante) {
		acompanhanterepository.delete(acompanhante);
	}
	
	@PutMapping
	public Acompanhante atualizaCLiente (@RequestBody Acompanhante acompanhante) {
		return acompanhanterepository.save(acompanhante);
	}
}
