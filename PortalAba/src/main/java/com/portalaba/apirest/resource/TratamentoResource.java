package com.portalaba.apirest.resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.portalaba.apirest.domain.Tratamento;
import com.portalaba.apirest.dto.TratamentoNewDTO;
import com.portalaba.apirest.service.AnalistaService;
import com.portalaba.apirest.service.TratamentoService;

@RestController
@RequestMapping(value="/tratamentos")
public class TratamentoResource {

	@Autowired
	private AnalistaService analsitaservice;
	
	@Autowired
	private TratamentoService tratamentoService;
	
	@GetMapping("/{id}/download")
	public ResponseEntity<Object> downloadFile(@PathVariable long id) throws IOException{
		String filename = tratamentoService.findEnd(id);
		File file = new File(filename);
		InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition",String.format("attachment; filename=\"%s\"", file.getName()));
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");

		ResponseEntity<Object> responseEntity = ResponseEntity.ok().headers(headers)
				.contentLength(file.length()).contentType(MediaType.parseMediaType("application/txt")).body(resource);

		return responseEntity;
	}
	
	@GetMapping("/{id}/tratamento/{idP}")
	public ResponseEntity<Page<Tratamento>> findTratamentos(@PathVariable long id,@PathVariable long idP,Pageable pageable) throws IOException {
		return ResponseEntity.ok().body(analsitaservice.findTratamentos(id,idP,pageable));
	}

	@PostMapping("/{id}/tratamento")
	public ResponseEntity<Void> insertTratamento(@PathVariable long id,@RequestParam("file") MultipartFile file,
		@RequestParam("acompanhante") long acom,@RequestParam("paciente") long pac,@RequestParam("nome") String nome){
		TratamentoNewDTO objDto = new TratamentoNewDTO(acom,pac,nome);
		tratamentoService.fromDTO(objDto,id,file);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PostMapping("/{id}/tratamento-video")
	public ResponseEntity<Void> insertTratamentoVideo(@PathVariable long id,@RequestParam("file") MultipartFile file,
		@RequestParam("acompanhante") long acom,@RequestParam("paciente") long pac,@RequestParam("nome") String nome){
		TratamentoNewDTO objDto = new TratamentoNewDTO(acom,pac,nome);
		tratamentoService.fromDTOMP4(objDto,id,file);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
		return ResponseEntity.created(uri).build();
	}
}
