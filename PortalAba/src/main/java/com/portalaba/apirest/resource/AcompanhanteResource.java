package com.portalaba.apirest.resource;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;

import javax.activation.FileTypeMap;
import javax.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.portalaba.apirest.domain.Acompanhante;
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
		return ResponseEntity.ok().body(acompanhanteservice.findAllAnalistas(id,pageable));
	}
	
	@GetMapping("/image/{id}")
	public ResponseEntity<byte[]> getImage(@PathVariable long id) throws IOException{
		Acompanhante acompanhante = acompanhanteservice.find(id);
	    File img = new File(acompanhante.getImage().toString());
	    return ResponseEntity.ok().contentType(MediaType.valueOf(FileTypeMap.getDefaultFileTypeMap()
	    		.getContentType(img)))
	    	    .body(Files.readAllBytes(img.toPath()));
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody AcompanhanteNewDTO objDto){
		MultipartFile file = null;
		Acompanhante obj = acompanhanteservice.fromDTO(objDto);
		obj = acompanhanteservice.insert(obj,file);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/{id}/analista/{idA}")
	public ResponseEntity<Void> insertAnalista(@PathVariable long id,@PathVariable long idA){
		acompanhanteservice.insertAnalista(id,idA);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}/paciente/{idA}")
	public ResponseEntity<Void> insertPaciente(@PathVariable long id,@PathVariable long idA){
		acompanhanteservice.insertPaciente(id,idA);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{id}/image")
	public ResponseEntity <Void> uploadToLocalFileSystem(@RequestParam("file") MultipartFile file,@PathVariable long id) {
		Acompanhante obj = acompanhanteservice.updateImage(id,file);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
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
