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
import com.portalaba.apirest.domain.Analista;
import com.portalaba.apirest.dto.AnalistaNewDTO;
import com.portalaba.apirest.service.AnalistaService;

@RestController
@RequestMapping(value="/analistas")
public class AnalistaResource {

	@Autowired
	private AnalistaService analsitaservice;
	
	@GetMapping
	public ResponseEntity<List<Analista>> findAll() {
		List<Analista> list = analsitaservice.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<String> find(@PathVariable long id) {
		Analista obj = analsitaservice.find(id);
		return ResponseEntity.ok().body(obj.toString());
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody AnalistaNewDTO objDto){
		Analista obj = analsitaservice.fromDTO(objDto);
		obj = analsitaservice.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable long id, @RequestBody Analista obj){
		obj = analsitaservice.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable long id){
		analsitaservice.delete(id);
		return ResponseEntity.noContent().build();
	}

}
