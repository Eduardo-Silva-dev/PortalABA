package com.portalaba.apirest.resource;

import java.io.IOException;
import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.portalaba.apirest.domain.Empresa;
import com.portalaba.apirest.dto.AcompanhanteDTO;
import com.portalaba.apirest.dto.AnalistaDTO;
import com.portalaba.apirest.dto.EmpresaDTO;
import com.portalaba.apirest.dto.EmpresaNewDTO;
import com.portalaba.apirest.dto.EmpresaTotalDTO;
import com.portalaba.apirest.dto.PacienteDTO;

import com.portalaba.apirest.service.EmpresaService;

@RestController
@RequestMapping(value="/empresas")
public class EmpresaResource {

	@Autowired
	private EmpresaService empresaService;
	
	@GetMapping
	public ResponseEntity<Page<EmpresaTotalDTO>> findAll(Pageable pageable) throws IOException {
		return ResponseEntity.ok().body(empresaService.findAll(pageable));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EmpresaDTO> find(@PathVariable long id) throws IOException {
		EmpresaDTO obj = empresaService.findParcial(id);
		return ResponseEntity.ok().body(obj);
	}	
	
	@GetMapping("/total/{id}")
	public ResponseEntity<EmpresaTotalDTO> findTotal(@PathVariable long id) throws IOException {
		EmpresaTotalDTO obj = empresaService.findTotal(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping("/{id}/pacientes")
	public ResponseEntity<Page<PacienteDTO>> findAllPacientes(@PathVariable long id,Pageable pageable) throws IOException {
		return ResponseEntity.ok().body(empresaService.findAllPaciente(id,pageable));
	}
	
	@GetMapping("/{id}/acompanhantes")
	public ResponseEntity<Page<AcompanhanteDTO>> findAllAcompanhantes(@PathVariable long id,Pageable pageable) throws IOException {
		return ResponseEntity.ok().body(empresaService.findAllAcompanhante(id,pageable));
	}
	
	@GetMapping("/{id}/analistas")
	public ResponseEntity<Page<AnalistaDTO>> findAllAnalistas(@PathVariable long id,Pageable pageable) throws IOException {
		return ResponseEntity.ok().body(empresaService.findAllAnalista(id,pageable));
	}
	
	@GetMapping("/{id}/analistas/{idA}/pacientes")
	public ResponseEntity<Page<PacienteDTO>> findAllPacienteAnalistas(@PathVariable long id,@PathVariable long idA,Pageable pageable) throws IOException {
		return ResponseEntity.ok().body(empresaService.findAnalista_Paciente(id,idA,pageable));
	}
	
//	@GetMapping("/{id}/acompanhantes/{idA}/pacientes")
//	public ResponseEntity<Page<PacienteDTO>> findAllPacienteAcompanhante(@PathVariable long id,@PathVariable long idA,Pageable pageable) throws IOException {
//		return ResponseEntity.ok().body(empresaService.findAcomapanhante_Paciente(id,idA,pageable));
//	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody EmpresaNewDTO objDto){
		Empresa obj = empresaService.fromDTO(objDto);
		obj = empresaService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable long id, @RequestBody EmpresaNewDTO objDto){
		Empresa obj = empresaService.fromDTO(objDto);
		obj = empresaService.update(obj,id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}/acompanhante/{idA}")
	public ResponseEntity<Void> inserirAcompanhante(@PathVariable long id,@PathVariable long idA){
		empresaService.insertAcompanhante(id,idA);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/{id}/paciente/{idP}")
	public ResponseEntity<Void> insertPaciente(@PathVariable long id,@PathVariable long idP){
		empresaService.insertPaciente(id,idP);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}/analista/{idP}")
	public ResponseEntity<Void> insertAnalista(@PathVariable long id,@PathVariable long idP){
		empresaService.insertAnalista(id,idP);
		return ResponseEntity.noContent().build();
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable long id){
		empresaService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}/paciente/{idP}")
	public ResponseEntity<Void> removerPaciente(@PathVariable long id,@PathVariable long idP){
		empresaService.removerPaciente(id, idP);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}/acompanhante/{idA}")
	public ResponseEntity<Void> removerAcompanhante(@PathVariable long id,@PathVariable long idA){
		empresaService.removerAcompanhante(id, idA);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}/analista/{idA}")
	public ResponseEntity<Void> removerAnalista(@PathVariable long id,@PathVariable long idA){
		empresaService.removerAnalista(id, idA);
		return ResponseEntity.noContent().build();
	}
}