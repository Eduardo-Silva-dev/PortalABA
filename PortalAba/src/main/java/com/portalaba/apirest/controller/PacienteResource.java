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
import com.portalaba.apirest.models.Paciente;
import com.portalaba.apirest.repository.PacienteRepository;

@RestController
@RequestMapping(value="/pacientes")
public class PacienteResource {

	@Autowired
	private PacienteRepository pacienterepository;
	
	@GetMapping
	public List<Paciente> listartodos(){
		return pacienterepository.findAll();
	}
	
	@GetMapping("{id}")
	public Paciente listar(@PathVariable(value="id")long id) {
		return pacienterepository.findById(id);
	}
	
	@PostMapping
	public Paciente salvarCliente (@RequestBody Paciente paciente) {
		return pacienterepository.save(paciente);
	}
	
	@DeleteMapping
	public void deletarCliente (@RequestBody Paciente paciente) {
		pacienterepository.delete(paciente);
	}
	
	@PutMapping
	public Paciente atualizaCLiente (@RequestBody Paciente paciente) {
		return pacienterepository.save(paciente);
	}
}
