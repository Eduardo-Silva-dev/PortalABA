package com.portalaba.apirest.resource;


import java.net.URI;

import javax.validation.Valid;

import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.portalaba.apirest.domain.Acompanhante;
import com.portalaba.apirest.dto.AcompanhanteDTO;
import com.portalaba.apirest.dto.AcompanhanteNewDTO;
import com.portalaba.apirest.dto.AcompanhanteTotalDTO;
import com.portalaba.apirest.dto.AnalistaDTO;
import com.portalaba.apirest.dto.PacienteDTO;
import com.portalaba.apirest.repository.AcompanhanteRepository;
import com.portalaba.apirest.service.AcompanhanteService;

@RestController
@RequestMapping(value="/acompanhantes") 
public class AcompanhanteResource {

	@Autowired
	private AcompanhanteService acompanhanteservice;

	@Autowired
	private AcompanhanteRepository acompanhanteRepository;
	
	@GetMapping
	public ResponseEntity<Page<Acompanhante>> findAll(Pageable pageable) {
		return ResponseEntity.ok().body(acompanhanteservice.findAll(pageable));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AcompanhanteDTO> find(@PathVariable long id) {
		AcompanhanteDTO obj = acompanhanteservice.findParcial(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping("/total/{id}")
	public ResponseEntity<AcompanhanteTotalDTO> findTotal(@PathVariable long id) {
		AcompanhanteTotalDTO obj = acompanhanteservice.findTotal(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping("/{id}/pacientes")
	public ResponseEntity<Page<PacienteDTO>> findAllPacientes(@PathVariable long id,Pageable pageable) {
		return ResponseEntity.ok().body(acompanhanteservice.findAllPacientes(id,pageable));
	}
	
	@GetMapping("/{id}/analistas")
	public ResponseEntity<Page<AnalistaDTO>> findAllAnalistas(@PathVariable long id,Pageable pageable) {
		return ResponseEntity.ok().body(acompanhanteRepository.findAllAnalistas(id,pageable));
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody AcompanhanteNewDTO objDto){
		Acompanhante obj = acompanhanteservice.fromDTO(objDto);
		obj = acompanhanteservice.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/{id}/analista/{idA}")
	public ResponseEntity<Void> insertAnalista(@PathVariable long id,@PathVariable long idA){
		acompanhanteservice.insertAnalista(id,idA);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable long id, @RequestBody AcompanhanteNewDTO objDto){
		Acompanhante obj = acompanhanteservice.fromDTO(objDto);
		obj = acompanhanteservice.update(obj,id);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable long id){
		acompanhanteservice.delete(id);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/{id}/paciente/{idP}")
	public ResponseEntity<Void> removerPaciente(@PathVariable long id,@PathVariable long idP){
		acompanhanteservice.removerPaciente(id, idP);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}/analista/{idA}")
	public ResponseEntity<Void> removerAnalista(@PathVariable long id,@PathVariable long idA){
		acompanhanteservice.removerAnalista(id, idA);
		return ResponseEntity.noContent().build();
	}
}
