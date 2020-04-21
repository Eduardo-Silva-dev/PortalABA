package com.portalaba.apirest.resource;


import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public ResponseEntity<List<Paciente>> findAll() {
		List<Paciente> list = pacienteService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/total/{id}")
	public ResponseEntity<PacienteTotalDTO> findTotal(@PathVariable long id) {
		PacienteTotalDTO obj = pacienteService.findTotal(id);
		return ResponseEntity.ok().body(obj);
	}

	
	@GetMapping("/{id}")
	public ResponseEntity<PacienteDTO> find(@PathVariable long id) {
		PacienteDTO obj = pacienteService.findParcial(id);
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
	public ResponseEntity<Void> insert(@RequestBody PacienteNewDTO objDto){
		Paciente obj = pacienteService.fromDTO(objDto);
		obj = pacienteService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable long id, @RequestBody Paciente obj){
		obj = pacienteService.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{idP}/{idA}")
	public ResponseEntity<Void> inserirAcompanhante(@PathVariable long idP,@PathVariable long idA){
		pacienteService.inserirAcompanhante(idP,idA);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable long id){
		pacienteService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
