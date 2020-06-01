package com.portalaba.apirest.resource;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;

import javax.activation.FileTypeMap;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
	public ResponseEntity<Page<PacienteTotalDTO>> findAll(Pageable pageable) throws IOException {
		return ResponseEntity.ok().body(pacienteService.findAll(pageable));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PacienteDTO> find(@PathVariable long id) throws IOException {
		PacienteDTO obj = pacienteService.findParcial(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping("/total/{id}")
	public ResponseEntity<PacienteTotalDTO> findTotal(@PathVariable long id) throws IOException {
		PacienteTotalDTO obj = pacienteService.findTotal(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping("/{id}/analista")
	public  ResponseEntity<AnalistaDTO> findAnalista(@PathVariable long id) throws IOException {
		AnalistaDTO obj = pacienteService.findAnalista(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping("/{id}/acompanhante")
	public  ResponseEntity<AcompanhanteDTO> findAcompanhante(@PathVariable long id) throws IOException {
		AcompanhanteDTO obj = pacienteService.findAcompanhante(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping("/image/{id}")
	public ResponseEntity<byte[]> getImage(@PathVariable long id) throws IOException{
		Paciente paciente = pacienteService.find(id);
	    File img = new File(paciente.getImage().toString());
	    return ResponseEntity.ok().contentType(MediaType.valueOf(FileTypeMap.getDefaultFileTypeMap()
	    		.getContentType(img))).body(Files.readAllBytes(img.toPath()));
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody PacienteNewDTO objDto){
		MultipartFile file = null;
		Paciente obj = pacienteService.fromDTO(objDto);
		obj = pacienteService.insert(obj,file);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
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
	

	@PutMapping("/{id}/image")
	public ResponseEntity <Void> uploadToLocalFileSystem(@RequestParam("file") MultipartFile file,@PathVariable long id) {
		Paciente obj = pacienteService.updateImage(id,file);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}	

	@PreAuthorize("hasAnyRole('ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable long id){
		pacienteService.delete(id);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}/acompanhante/{idP}")
	public ResponseEntity<Void> removerPaciente(@PathVariable long id,@PathVariable long idP){
		pacienteService.removerAcompanhante(id, idP);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}/analista/{idA}")
	public ResponseEntity<Void> removerAnalista(@PathVariable long id,@PathVariable long idA){
		pacienteService.removerAnalista(id, idA);
		return ResponseEntity.noContent().build();
	}
}
