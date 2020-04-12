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
import com.portalaba.apirest.dto.AcompanhanteNewDTO;
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
	
	@GetMapping("/{id}")
	public ResponseEntity<String> find(@PathVariable long id) {
		Acompanhante obj = acompanhanteservice.find(id);
		return ResponseEntity.ok().body(obj.toString());
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
