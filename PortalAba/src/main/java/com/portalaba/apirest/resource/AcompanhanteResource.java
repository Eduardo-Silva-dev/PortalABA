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

import com.portalaba.apirest.domain.Acompanhante;
import com.portalaba.apirest.domain.Analista;
import com.portalaba.apirest.domain.Paciente;
import com.portalaba.apirest.dto.AcompanhanteDTO;
import com.portalaba.apirest.dto.AcompanhanteNewDTO;
import com.portalaba.apirest.dto.AcompanhanteTotalDTO;
import com.portalaba.apirest.dto.AnalistaDTO;
import com.portalaba.apirest.dto.PacienteDTO;
import com.portalaba.apirest.service.AcompanhanteService;

@RestController
@RequestMapping(value="/acompanhantes") 
public class AcompanhanteResource {

	@Autowired
	private AcompanhanteService acompanhanteservice;
	
	@GetMapping
	public ResponseEntity<List<Acompanhante>> findAll() {
		List<Acompanhante> list = acompanhanteservice.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}/pacientes")
	public ResponseEntity<List<PacienteDTO>> findAllPacientes(@PathVariable long id) {
		List<PacienteDTO> list = acompanhanteservice.findAllPacientes(id);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}/analistas")
	public ResponseEntity<List<AnalistaDTO>> findAllAnalistas(@PathVariable long id) {
		List<AnalistaDTO> list = acompanhanteservice.findAllAnalistas(id);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/total/{id}")
	public ResponseEntity<AcompanhanteTotalDTO> findTotal(@PathVariable long id) {
		AcompanhanteTotalDTO obj = acompanhanteservice.findTotal(id);
		return ResponseEntity.ok().body(obj);
	}

	
	@GetMapping("/{id}")
	public ResponseEntity<AcompanhanteDTO> find(@PathVariable long id) {
		AcompanhanteDTO obj = acompanhanteservice.findParcial(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody AcompanhanteNewDTO objDto){
		Acompanhante obj = acompanhanteservice.fromDTO(objDto);
		obj = acompanhanteservice.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable long id, @RequestBody Acompanhante obj){
		obj = acompanhanteservice.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable long id){
		acompanhanteservice.delete(id);
		return ResponseEntity.noContent().build();
	}

}
