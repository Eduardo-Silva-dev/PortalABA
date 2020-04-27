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
import com.portalaba.apirest.domain.Paciente;
import com.portalaba.apirest.dto.AcompanhanteDTO;
import com.portalaba.apirest.dto.AnalistaDTO;
import com.portalaba.apirest.dto.PacienteDTO;
import com.portalaba.apirest.dto.PacienteNewDTO;
import com.portalaba.apirest.dto.PacienteTotalDTO;
import com.portalaba.apirest.service.PacienteService;

@RestController
@RequestMapping(value="/pacientes")
public class PacienteResource {

	@Autowired
	private PacienteService pacienteService;
	
	@GetMapping
	public ResponseEntity<Page<Paciente>> findAll(Pageable pageable) {
		return ResponseEntity.ok().body(pacienteService.findAll(pageable));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PacienteDTO> find(@PathVariable long id) {
		PacienteDTO obj = pacienteService.findParcial(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping("/total/{id}")
	public ResponseEntity<PacienteTotalDTO> findTotal(@PathVariable long id) {
		PacienteTotalDTO obj = pacienteService.findTotal(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping("/{id}/analista")
	public  ResponseEntity<AnalistaDTO> findAnalista(@PathVariable long id) {
		AnalistaDTO obj = pacienteService.findAnalista(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping("/{id}/acompanhante")
	public  ResponseEntity<AcompanhanteDTO> findAcompanhante(@PathVariable long id) {
		AcompanhanteDTO obj = pacienteService.findAcompanhante(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody PacienteNewDTO objDto){
		Paciente obj = pacienteService.fromDTO(objDto);
		obj = pacienteService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable long id, @RequestBody PacienteNewDTO objDto){
		Paciente obj = pacienteService.fromDTO(objDto);
		pacienteService.update(obj, id);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/{idP}/acompanhante/{idA}")
	public ResponseEntity<Void> inserirAcompanhante(@PathVariable long idP,@PathVariable long idA){
		pacienteService.insertAcompanhante(idP,idA);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/{id}/analista/{idA}")
	public ResponseEntity<Void> insertAnalista(@PathVariable long id,@PathVariable long idA){
		pacienteService.insertAnalista(id,idA);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable long id){
		pacienteService.delete(id);
		return ResponseEntity.ok().build();
	}

}
