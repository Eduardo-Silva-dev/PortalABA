package com.portalaba.apirest.resource;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
import com.portalaba.apirest.domain.Analista;
import com.portalaba.apirest.dto.AcompanhanteDTO;
import com.portalaba.apirest.dto.AnalistaDTO;
import com.portalaba.apirest.dto.AnalistaNewDTO;
import com.portalaba.apirest.dto.AnalistaTotalDTO;
import com.portalaba.apirest.dto.PacienteDTO;
import com.portalaba.apirest.service.AnalistaService;

@RestController
@RequestMapping(value="/analistas")
public class AnalistaResource {

	@Autowired
	private AnalistaService analsitaservice;
	
	@GetMapping
	public ResponseEntity<Page<Analista>> findAll(Pageable pageable) {
		return ResponseEntity.ok().body(analsitaservice.findAll(pageable));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AnalistaDTO> find(@PathVariable long id) {
		AnalistaDTO obj = analsitaservice.findParcial(id);
		return ResponseEntity.ok().body(obj);
	}	
	
	@GetMapping("/total/{id}")
	public ResponseEntity<AnalistaTotalDTO> findTotal(@PathVariable long id) {
		AnalistaTotalDTO obj = analsitaservice.findTotal(id);
		return ResponseEntity.ok().body(obj);
	}
	@GetMapping("/{id}/pacientes")
	public ResponseEntity<Page<PacienteDTO>> findAllPacientes(@PathVariable long id,Pageable pageable) {
		return ResponseEntity.ok().body(analsitaservice.findAllPacientes(id,pageable));
	}
	
	@GetMapping("/{id}/acompanhantes")
	public ResponseEntity<Page<AcompanhanteDTO>> findAllAcompanhantes(@PathVariable long id,Pageable pageable) {
		return ResponseEntity.ok().body(analsitaservice.findAllAcompanhantes(id,pageable));
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody AnalistaNewDTO objDto){
		Analista obj = analsitaservice.fromDTO(objDto);
		obj = analsitaservice.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable long id, @RequestBody AnalistaNewDTO objDto){
		Analista obj = analsitaservice.fromDTO(objDto);
		obj = analsitaservice.update(obj,id);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable long id){
		analsitaservice.delete(id);
		return ResponseEntity.noContent().build();
	}

}
