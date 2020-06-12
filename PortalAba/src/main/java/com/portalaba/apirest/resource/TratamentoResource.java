package com.portalaba.apirest.resource;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.portalaba.apirest.domain.Paciente;
import com.portalaba.apirest.domain.Tratamento;
import com.portalaba.apirest.dto.AcompanhanteDTO;
import com.portalaba.apirest.dto.AnalistaDTO;
import com.portalaba.apirest.dto.TratamentoNewDTO;
import com.portalaba.apirest.service.AnalistaService;
import com.portalaba.apirest.service.PacienteService;
import com.portalaba.apirest.service.TratamentoService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value="/tratamentos")
public class TratamentoResource {

	@Autowired
	private AnalistaService analsitaservice;
	
	@Autowired
	private PacienteService pacienteService;
	
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
	
	@GetMapping("/{id}-pdf")
	public ResponseEntity<byte[]>  exibirFile(@PathVariable long id) throws IOException{
		String filename = tratamentoService.findEnd(id);
		File file = new File(filename);
		FileInputStream fis = new FileInputStream(file);
		byte[] data = new byte[fis.available()];
		fis.read(data);
		  HttpHeaders headers = new HttpHeaders();

		    headers.setContentType(MediaType.parseMediaType("application/pdf"));
		    
		    headers.add("content-disposition", "inline;filename=" + filename);
		    
		    headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
		    ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(data,headers, HttpStatus.OK);
		    return response;
	}
	
	@GetMapping("/{id}/tratamento/{idP}")
	public ResponseEntity<Page<Tratamento>> findTratamentos(@PathVariable long id,@PathVariable long idP,Pageable pageable) throws IOException {
		return ResponseEntity.ok().body(analsitaservice.findTratamentos(id,idP,pageable));
	}

	@PostMapping("/{id}/nome/{nome}")
	public ResponseEntity<Void> insertTratamento(@PathVariable long id,@RequestParam("file") MultipartFile file
			,@PathVariable String nome) throws IOException{
		AnalistaDTO analistaDTO = pacienteService.findAnalista(id);
		AcompanhanteDTO acompanhanteDTO = pacienteService.findAcompanhante(id);
		TratamentoNewDTO objDto = new TratamentoNewDTO(acompanhanteDTO.getId(),id,nome);
		tratamentoService.fromDTO(objDto,analistaDTO.getId(),file);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PostMapping("/{id}/retorno-tratamento/nome/{nome}")
	public ResponseEntity<Void> retornoTratamentoPDF(@PathVariable long id,@RequestParam("file") MultipartFile file
			,@PathVariable String nome) throws IOException{
		AnalistaDTO analistaDTO = pacienteService.findAnalista(id);
		AcompanhanteDTO acompanhanteDTO = pacienteService.findAcompanhante(id);
		TratamentoNewDTO objDto = new TratamentoNewDTO(acompanhanteDTO.getId(),id,nome);
		tratamentoService.fromDTOR(objDto,analistaDTO.getId(),file);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PostMapping("/{id}/relatorio/nome/{nome}")
	public ResponseEntity<Void> relatorioTratamento(@PathVariable long id,@RequestParam("file") MultipartFile file
			,@PathVariable String nome) throws IOException{
		AnalistaDTO analistaDTO = pacienteService.findAnalista(id);
		AcompanhanteDTO acompanhanteDTO = pacienteService.findAcompanhante(id);
		TratamentoNewDTO objDto = new TratamentoNewDTO(acompanhanteDTO.getId(),id,nome);
		tratamentoService.fromDTORelatorio(objDto,analistaDTO.getId(),file);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PostMapping("/{id}/nome-video/{nome}")
	public ResponseEntity<Void> insertTratamentoVideo(@PathVariable long id,@RequestParam("file") MultipartFile file
			,@PathVariable String nome) throws IOException{
		AnalistaDTO analistaDTO = pacienteService.findAnalista(id);
		AcompanhanteDTO acompanhanteDTO = pacienteService.findAcompanhante(id);
		TratamentoNewDTO objDto = new TratamentoNewDTO(acompanhanteDTO.getId(),id,nome);
		tratamentoService.fromDTOMP4(objDto,analistaDTO.getId(),file);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
		return ResponseEntity.created(uri).build();
	}
}
